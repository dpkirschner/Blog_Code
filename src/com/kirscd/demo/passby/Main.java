package com.kirscd.demo.passby;

public class Main {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
    }

    public static void exampleOne() {
        int a = 5;
        System.out.println("------ Example One ------");
        System.out.println("Before method call...");
        System.out.println(String.format("the value of a: %d", a));
        intSwap(a);
        System.out.println("After method call...");
        System.out.println(String.format("the value of a: %d", a));
    }

    public static void exampleTwo() {
        ValetTicket a = new ValetTicket(5);

        System.out.println("------ Example Two ------");
        System.out.println("Before method call...");
        System.out.println(String.format("the value of valetTicket a: %d", a.getId()));
        ValetTicket.swap(a);
        System.out.println("After method call...");
        System.out.println(String.format("the value of valetTicket a: %d", a.getId()));
    }

    public static void exampleThree() {
        ValetTicket a = new ValetTicket(5);

        System.out.println("------ Example Three ------");
        System.out.println("Before running the confusing method...");
        System.out.println(String.format("the value of valetTicket a: %d",
                a.getId()));
        ValetTicket.confusing(a);
        System.out.println("After running the confusing method...");
        System.out.println(String.format("the value of valetTicket a: %d",
                a.getId()));
    }

    public static void intSwap(int a) {
        System.out.println("During method call...");
        a = 10;
        System.out.println(String.format("the value of a is now: %d", a));
    }
}
