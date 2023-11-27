package ui;

import domain.Controller;

import java.awt.*;
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
                        "(2) Print members\n" +
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

                    String subscriptionString;
                    boolean subscriptionStatus = false;
                    boolean validSubscriptionStatus = true;
                    do {
                        validSubscriptionStatus = true;
                        System.out.println("Input subscription status (ACTIVE/PASSIVE)");
                        System.out.print("Status: ");

                        subscriptionString = scanner.nextLine().trim().toLowerCase();
                        if (subscriptionString.equals("active") || subscriptionString.equals("passive")) {
                            subscriptionStatus = true;
                        } else {
                            System.out.println(color.ANSI_RED + "Invalid input" + color.ANSI_RESET);
                            validSubscriptionStatus = false;
                        }
                    } while (!validSubscriptionStatus);

                    String ageGroup;
                    boolean junior = false;
                    boolean validAgeGroup = true;
                    do {
                        validAgeGroup = true;
                        System.out.println("Select your age group: ('Junior' for under 18, 'Senior' for over 18");
                        ageGroup = scanner.nextLine().trim().toLowerCase();
                        if (ageGroup.equals("junior") || ageGroup.equals("senior")) {
                            junior = true;
                        }
                        if (ageGroup.equals("senior")) {
                            junior = false;
                        } else {
                            System.out.println(color.ANSI_RED + "Invalid input" + color.ANSI_RESET);
                            validAgeGroup = false;
                        }
                    } while (!validAgeGroup);

                    String exerciseType;
                    boolean excerciseActive = false;
                    boolean validType = true;
                    do {
                        validType = true;
                        System.out.println("Input your exercise type ('Regular' or 'Competitive')");
                        exerciseType = scanner.nextLine().trim().toLowerCase();
                        if (exerciseType.equals("regular") || exerciseType.equals("competitive")) {
                            excerciseActive = true;
                        } else {
                            System.out.println(color.ANSI_RED + "Invalid input" + color.ANSI_RESET);
                            validType = false;
                        }
                    } while (!validType);


                    controller.addMember(name, age, subscriptionStatus, ageGroup, exerciseType);

                    System.out.println(color.ANSI_GREEN + "Swimming member added" + color.ANSI_RESET);
                    System.out.println("\u2500".repeat(50) + " ");
                }

                case "2", "two" -> {
                    System.out.println("Printing:");
                    controller.printMember();

                }
                case "9", "nine" -> {
                    System.exit(0);
                }

                //TODO ADD SAVING ONTO CSV FIL

            }
        } while (run);
    }
}