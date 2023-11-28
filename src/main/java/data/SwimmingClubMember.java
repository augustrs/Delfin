package data;

public class SwimmingClubMember {
    private String name;
    private int age;
    private boolean subscriptionActive;
    private String ageGroup;
    private String excerciseType;

    public SwimmingClubMember(String name, int age, boolean subscriptionActive, String ageGroup, String excerciseType) {
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
    public Boolean getSubscriptionActive() {
        return subscriptionActive;
    }

    public String toString() {
        return "Member: " + name +
                ", age: " + age +
                ", active subscription: " + subscriptionActive +
                ", age group: " + ageGroup +
                ", excercise type: " + excerciseType;
    }
}