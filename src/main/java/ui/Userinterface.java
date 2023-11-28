package ui;

import data.SwimmingClubMember;
import domain.Controller;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
                        "(2) Print all members\n" +
                        "(3) Print revenue\n" +
                        "(4) Swimming Result\n" +
                        "(5)\n" +
                        "(6)\n" +
                        "(7)\n" +
                        "(8)\n" +
                        "(9) EXIT\n" + "\u2500".repeat(50)

        );


    }

    public void startProgram() {
        boolean run = true;
        String input;
        controller.loadData();
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
                case "3", "three" -> {


                    System.out.println(controller.checkSubscription() + ",- DKK");
                }

                case "4", "four" -> {
                    System.out.println("Adding Swimming Result:");
                    System.out.print("Input the member's name: ");
                    String memberName = scanner.nextLine();


                    ArrayList<SwimmingClubMember> foundMembers = controller.searchMember(memberName);

                    if (foundMembers.isEmpty()) {
                        System.out.println(color.ANSI_RED + "Member not found. Please make sure the name is correct." + color.ANSI_RESET);
                    } else {

                        SwimmingClubMember selectedMember = foundMembers.get(0);

                        System.out.print("Input the swimming result date (yyyy-MM-dd): ");
                        String dateString = scanner.nextLine();

                        System.out.print("Input the swimming result time (HH:mm): ");
                        String timeString = scanner.nextLine();

                        String dateTimeString = dateString + " " + timeString;
                        LocalDateTime swimmingResultDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                        System.out.print("Input the event (if competitive, otherwise leave empty): ");
                        String event = scanner.nextLine();

                        int placement = 0;
                        if (!event.isEmpty()) {
                            System.out.print("Input the placement: ");
                            placement = scanner.nextInt();
                            scanner.nextLine();
                        }

                        controller.addSwimmingResult(selectedMember.getName(), swimmingResultDateTime, event, placement);
                        System.out.println(color.ANSI_GREEN + "Swimming result added for " + selectedMember.getName() + color.ANSI_RESET);
                        System.out.println("\u2500".repeat(50) + " ");
                    }

                }
                case "9", "nine" -> {
                    System.exit(0);
                }

                //TODO ADD SAVING ONTO CSV FIL

            }
        } while (run);
    }
}

