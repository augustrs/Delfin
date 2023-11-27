package domain;

import domain.Database;

public class Controller {
    Database database = new Database();

    public void addMember(String name, int age, boolean subscriptionActive, String ageGroup, String excerciseType) {
        database.addMember(name, age, subscriptionActive, ageGroup, excerciseType);
    }
    public void printMember() {
        database.printMembers();
    }
    public double checkSubscription () {
        return database.checkSubscription();
    }

}
