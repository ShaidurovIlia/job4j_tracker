package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User not found");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ilya", true)
        };
        try {
            User user = findUser(users, "Ilya");
            if (validate(user)) {
                System.out.println("This user has an access.");
            }
        } catch (UserInvalidException u) {
            u.printStackTrace();
        } catch (UserNotFoundException s) {
            s.printStackTrace();
        }
    }
}
