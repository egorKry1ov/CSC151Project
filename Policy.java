/**
 * Represents an insurance policy with policyholder details.
 */
public class Policy {
    // Fields
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;   // in inches
    private double weight;   // in pounds

    /**
     * No-arg constructor that initializes a Policy object with default values.
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "";
        this.height = 0.0;
        this.weight = 0.0;
    }

    /**
     * Constructor that accepts all fields to initialize a Policy object.
     * 
     * @param policyNumber The policy number.
     * @param providerName The name of the insurance provider.
     * @param firstName The policyholder's first name.
     * @param lastName The policyholder's last name.
     * @param age The policyholder's age.
     * @param smokingStatus The policyholder's smoking status.
     * @param height The policyholder's height in inches.
     * @param weight The policyholder's weight in pounds.
     */
    public Policy(String policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Gets the policy number.
     * @return The policy number.
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Gets the provider name.
     * @return The provider name.
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Gets the policyholder's first name.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the policyholder's last name.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the policyholder's age.
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the policyholder's smoking status.
     * @return The smoking status.
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Gets the policyholder's height.
     * @return The height in inches.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the policyholder's weight.
     * @return The weight in pounds.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the policy number.
     * @param policyNumber The policy number to set.
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Sets the provider name.
     * @param providerName The provider name to set.
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Sets the policyholder's first name.
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the policyholder's last name.
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the policyholder's age.
     * @param age The age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the policyholder's smoking status.
     * @param smokingStatus The smoking status to set.
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Sets the policyholder's height.
     * @param height The height to set in inches.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Sets the policyholder's weight.
     * @param weight The weight to set in pounds.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates the Body Mass Index (BMI) of the policyholder.
     * @return The calculated BMI.
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the insurance price based on age, smoking status, and BMI.
     * @return The total calculated policy price.
     */
    public double calculatePrice() {
        double price = 600.0; // base fee

        // Additional fee if over 50
        if (age > 50) {
            price += 75;
        }

        // Additional fee if smoker
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }

        // Additional fee if BMI > 35
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }
}