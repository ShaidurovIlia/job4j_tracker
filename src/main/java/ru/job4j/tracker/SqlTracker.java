package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("insert into items(name,created)"
                + "values(?, ?)"
                + "returning id")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    item.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "update items set name = ?, created =?"
                        + "where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "delete from items where id = ?")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(
                "select id, name, created from items;")) {
            try (ResultSet itemSet = statement.executeQuery()) {
                while (itemSet.next()) {
                    items.add(makeItem(itemSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(
                "select id, name, created from items "
                        + "where name = ?")) {
            statement.setString(1, key);
            try (ResultSet itemSet = statement.executeQuery()) {
                while (itemSet.next()) {
                    items.add(makeItem(itemSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = cn.prepareStatement(
                "select id, name, created from items "
                        + "where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet itemSet = statement.executeQuery()) {
                if (itemSet.next()) {
                    item = makeItem(itemSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item makeItem(ResultSet result) throws SQLException {
        return new Item(result.getInt(1),
                result.getString(2),
                result.getTimestamp(3)
                        .toLocalDateTime());
    }
}