package data;

public class SwimmingClubMembers {
    private String name;
    private int age;
    private boolean subscriptionActive;
    private String ageGroup;



    public SwimmingClubMembers(String name, int age, boolean subscriptionActive, String ageGroup) {
        this.name = name;
        this.age = age;
        this.subscriptionActive = subscriptionActive;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public String getAgeGroup() {
        return ageGroup;
    }
}
