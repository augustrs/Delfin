package data;

public class SwimmingClubMembers {
    private String name;
    private int age;
    private boolean subscriptionActive;
    private String ageGroup;
    private String excerciseType;

    public SwimmingClubMembers(String name, int age, boolean subscriptionActive, String ageGroup, String excerciseType) {
        this.name = name;
        this.age = age;
        this.subscriptionActive = subscriptionActive;
        this.ageGroup = ageGroup;
        this.excerciseType = excerciseType;
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

    public String getExcerciseType() {
        return excerciseType;
    }

    public String toString() {
        return "Member: " + name +
                ", age: " + age +
                ", active subscription: " + subscriptionActive +
                ", age group: " + ageGroup +
                ", excercise type: " + excerciseType;
    }
}