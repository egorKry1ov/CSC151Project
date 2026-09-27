public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds

    // No-arg constructor
    public PolicyHolder() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "";
        this.height = 0.0;
        this.weight = 0.0;
    }

    // Parameterized constructor
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Copy Constructor (Step 5: Minimize security holes)
    public PolicyHolder(PolicyHolder object) {
        this.firstName = object.firstName;
        this.lastName = object.lastName;
        this.age = object.age;
        this.smokingStatus = object.smokingStatus;
        this.height = object.height;
        this.weight = object.weight;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }

    // Method to calculate BMI
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    // toString method (Step 2)
    public String toString() {
        return String.format("Policyholder's First Name: %s\n" +
                             "Policyholder's Last Name: %s\n" +
                             "Policyholder's Age: %d\n" +
                             "Policyholder's Smoking Status (Y/N): %s\n" +
                             "Policyholder's Height: %.1f inches\n" +
                             "Policyholder's Weight: %.1f pounds\n" +
                             "Policyholder's BMI: %.2f",
                             firstName, lastName, age, smokingStatus, height, weight, calculateBMI());
    }
}