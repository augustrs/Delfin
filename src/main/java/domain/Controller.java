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

    public void loadData() {
        filehandler.loadMemberData(database.getMembers());

    }

}
