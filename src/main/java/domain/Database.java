package domain;

import data.SwimmingClubMembers;

import java.util.ArrayList;

public class Database {

    ArrayList<SwimmingClubMembers> members = new ArrayList<>();

    public void addMember(String name, int age, boolean subscriptionActive, String ageGroup, String excerciseType) {
        members.add(new SwimmingClubMembers(name, age, subscriptionActive, ageGroup, excerciseType));

    }
    public void printMembers() {
   for (SwimmingClubMembers member : members) {
            System.out.println(member);
        }
    }

}