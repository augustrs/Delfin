import data.Filehandler;
import data.SwimmingClubMember;
import domain.Database;
import jdk.jfr.DataAmount;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DelfinTest {

    @Test
    public void testAddMember() {
        Database database = new Database();
        database.addMember("John", 25, true, "Senior", "Regular");

        assertEquals(1, database.getMembers().size());
    }

    @Test
    public void testCheckSubscription() {
        Database database = new Database();


        database.addMember("John", 17, true, "Junior", "Regular");
        database.addMember("Jane", 25, true, "Senior", "Regular");
        database.addMember("Bob", 65, true, "Senior", "Competitive");

        double yearlyIncome = database.checkSubscription();
        assertEquals(1000 + 1600 + (1600 * 0.75), yearlyIncome);
    }

    @Test
    public void testLoadMemberData() {
        String fileName = "Delfin.csv";
        ArrayList<SwimmingClubMember> swimmingClubMemberArrayList = new ArrayList<>();
        SwimmingClubMember SwimmingClubMember1  = new SwimmingClubMember("John", 17, true, "Junior", "Regular");
        SwimmingClubMember SwimmingClubMember2  = new SwimmingClubMember("John2", 17, true, "Junior", "Regular");
        SwimmingClubMember SwimmingClubMember3  = new SwimmingClubMember("John3", 17, true, "Junior", "Regular");
/*
        try {
            PrintStream output = new PrintStream(fileName);
            output.println("Heroname,Realname,SuperPower,Strength,BirthYear,IsHuman");
            for (SwimmingClubMember swimmingClubMember : swimmingClubMemberArrayList) {
                output.println(swimmingClubMember.csvString());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
*/


    }
}

