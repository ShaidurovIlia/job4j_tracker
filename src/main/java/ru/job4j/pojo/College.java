package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setLastname(" Shaidurov ");
        student.setName(" Ilia ");
        student.setPatronymic(" Valerevich ");
        student.setGroup(" 102 ");
        student.setOfReceipt(" 01.08.2012 ");

        System.out.println(student.getLastname() + student.getName()
                + student.getPatronymic() + " of "
                + student.getGroup() + student.getOfReceipt());
    }
}
