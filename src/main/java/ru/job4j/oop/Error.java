package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo(){
        System.out.println("Активный: " + active  + System.lineSeparator() + "Статус: " + status
                + System.lineSeparator() + "Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorOne = new Error(true, 100, "Done!");
        Error errorTwo = new Error(false, 10, "Victory!");
        error.printInfo();
        errorOne.printInfo();
        errorTwo.printInfo();
    }
}
