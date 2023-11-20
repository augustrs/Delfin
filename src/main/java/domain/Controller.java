package domain;

import domain.Database;

public class Controller {
    Database database = new Database();

    public void addMember(String name, int age, boolean subscriptionActive, String ageGroup) {
        database.addMember(name, age, subscriptionActive, ageGroup);
    }
}
