package com.payroll;

public class Main {

    public static void main(String[] args) {

        DB.getInstance().seed();

        System.out.println(DB.getInstance());
        System.out.println("------------------");

        Menu.show();

        System.out.println(DB.getInstance());
        System.out.println("------------------");
    }
}
