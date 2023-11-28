package domain;

import data.Filehandler;
import domain.Database;

import java.io.FileNotFoundException;

public class Controller {
    Database database = new Database();
    Filehandler filehandler = new Filehandler();

    public void addMember(String name, int age, boolean subscriptionActive, String ageGroup, String excerciseType) {
        database.addMember(name, age, subscriptionActive, ageGroup, excerciseType);
    }

    public void printMember() {
        database.printMembers();
    }

    public double checkSubscription() {
        return database.checkSubscription();
    }

    public void loadData() throws FileNotFoundException {
        filehandler.loadMemberData(database.getMembers());

    }
    public void saveData() {
        try {
        filehandler.saveMemberData(database.getMembers());
    } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        }

    }
