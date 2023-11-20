package ui;

import domain.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Userinterface {
    private int age;
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    Color color = new Color();

    public void welcomeMessage() {
        System.out.println(
                "Welcome to the swimclub-database (Delfin)\n" + "\u2500".repeat(50) + "\n" +
                        "Interact with the menu by inputting the corresponding number\n" +
                        "(1) Add member\n" +
                        "(2)\n" +
                        "(4)\n" +
                        "(5)\n" +
                        "(6)\n" +
                        "(7)\n" +
                        "(8)\n" +
                        "(9) EXIT"

        );


    }

    public void startProgram() {
        boolean run = true;
        String input;
        //TODO add LOADER FOR LOADING INITIAL DATA
        do {
            welcomeMessage();
            System.out.print("Input: ");
            input = scanner.nextLine().trim().toLowerCase();
            String[] commands = input.split("\\s+");
            String command = commands[0];


            switch (command) {
                case "1", "one" -> {
                    System.out.println("Input the members name");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Input the members age");
                    System.out.print("Age: ");
                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                        scanner.nextLine();

                    } else {
                        System.out.println(color.ANSI_RED + "You need to input a number" + color.ANSI_RESET);
                        scanner.nextLine();

                    }
                    System.out.println("Input subscription status (ACTIVE/PASSIVE)");
                    System.out.print("Status: ");
                    boolean subscriptonActive = true;
                    String subscriptionStatus = scanner.nextLine().trim().toLowerCase();
                    if (subscriptionStatus.equals("active")) {
                        subscriptonActive = true;
                    } else if (subscriptionStatus.equals("passive")) {
                        subscriptonActive = false;
                    } else {
                        System.out.println(color.ANSI_RED + "Invalid input"+ color.ANSI_RESET);
                    }
                    String ageGroup = null;
                    if (age < 18) {
                        ageGroup = "junior";
                    } else if (age >= 18) {
                        ageGroup = "senior";
                    } else if (age >= 60) {
                        ageGroup = "pensionist";
                    }
                    System.out.println("Input ");
                    controller.addMember(name, age, subscriptonActive, ageGroup);

                    System.out.println(color.ANSI_GREEN + "Swimming member added" + color.ANSI_RESET);
                    System.out.println("\u2500".repeat(50) + " ");

                }
                case "2", "two" -> {
                    
                }
                case "9", "nine" -> {
                    System.exit(0);
                    //TODO ADD SAVING ONTO CSV FILE
                }
            }
        } while (run);


    }

}