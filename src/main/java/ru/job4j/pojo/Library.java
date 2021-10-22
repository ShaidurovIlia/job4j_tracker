package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book roman = new Book("Anna Karenina", 1824);
        Book fantasy = new Book("Glow", 900);
        Book horror = new Book("Stiven King", 1543);
        Book science = new Book("Clean Code", 800);
        Book[] books = new Book[4];
        books[0] = roman;
        books[1] = fantasy;
        books[2] = horror;
        books[3] = science;
        for (Book bo : books) {
            System.out.println(bo.getName() + " - " + bo.getCount());
        }
        System.out.println("Replace roman to science");
        for (int i = 0; i < books.length; i++) {
            Book bo = books[3];
            books[3] =  books[0];
            books[0] = bo;
            System.out.println(bo.getName() + " - " + bo.getCount());
        }
        System.out.println("show only Clean Code");
        for (Book bo : books) {
            if (bo.getName().equals("Clean Code")) {
                System.out.println(bo.getName() + " - " + bo.getCount());
            }
        }
    }
}
