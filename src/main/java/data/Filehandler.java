package data;

import data.SwimmingClubMember;
import domain.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    public void loadMemberData(ArrayList<SwimmingClubMember> members) throws FileNotFoundException {
        members.clear();
        Scanner loader = new Scanner(new File("members.csv"));
        while (loader.hasNextLine()) {
            String memberInfo = loader.nextLine();
            SwimmingClubMember swimmingClubMember = parseCSV(memberInfo);
            members.add(swimmingClubMember);

        }
    }

public SwimmingClubMember parseCSV(String line) {
    try {
                String[] values = line.split(",");
                SwimmingClubMember swimmingClubMember = new SwimmingClubMember(values[0], Integer.parseInt(values[1]),Boolean.parseBoolean(values[2]),values[3],values[4]);

return swimmingClubMember;

        } catch (NumberFormatException e) {
            System.out.println("File not found");
return null;

        }
    }
    public void saveMemberData(ArrayList<SwimmingClubMember> members) throws FileNotFoundException {
        PrintStream memberOutput = new PrintStream(new File ("members.csv"));
        for (SwimmingClubMember member : members) {
            memberOutput.print(member.getName());
            memberOutput.print(",");
            memberOutput.print(member.getAge());
            memberOutput.print(",");
            memberOutput.print(member.getSubscriptionActive());
            memberOutput.print(",");
            memberOutput.print(member.getAgeGroup());
            memberOutput.print(",");
            memberOutput.print(member.getExcerciseType());
        }
        memberOutput.close();
    }
}
