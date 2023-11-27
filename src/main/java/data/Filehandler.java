package data;

import data.SwimmingClubMember;
import domain.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    public void loadMemberData(ArrayList<SwimmingClubMember> members) {
        try {
            File file = new File("members.csv");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                if (values.length == 5) {
                    String name = values[0];
                    int age = Integer.parseInt(values[1]);
                    boolean subscriptionActive = Boolean.parseBoolean(values[2]);
                    String ageGroup = values[3];
                    String exerciseType = values[4];

                    SwimmingClubMember swimmingClubMember = new SwimmingClubMember(name, age, subscriptionActive, ageGroup, exerciseType);
                    members.add(swimmingClubMember);
                } else {

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");


        }
    }
    public void saveMemberData(SwimmingClubMember swimmingClubMember) {

    }
}
