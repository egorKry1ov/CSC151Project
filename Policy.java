public class Policy {
    // Step 3: Static field to track number of Policy objects
    private static int policyCount = 0;

    private String policyNumber;
    private String providerName;
    
    // Step 4: Class collaboration (Policy has a PolicyHolder)
    private PolicyHolder policyHolder; 

    // No-arg constructor
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyHolder = null;
        policyCount++;
    }

    // Parameterized constructor
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        // Step 5: Use copy constructor to prevent security holes
        this.policyHolder = new PolicyHolder(policyHolder); 
        policyCount++;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    
    // Step 5: Return a copy to prevent security holes
    public PolicyHolder getPolicyHolder() { 
        return new PolicyHolder(policyHolder); 
    }

    // Setters
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    
    // Step 5: Set using a copy to prevent security holes
    public void setPolicyHolder(PolicyHolder policyHolder) { 
        this.policyHolder = new PolicyHolder(policyHolder); 
    }

    // Static method to get the count
    public static int getPolicyCount() {
        return policyCount;
    }

    // Calculate Price (uses PolicyHolder's data)
    public double calculatePrice() {
        double price = 600.0; 

        if (policyHolder.getAge() > 50) {
            price += 75;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100;
        }

        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }

    // Step 2: toString method
    public String toString() {
        return String.format("Policy Number: %s\n" +
                             "Provider Name: %s\n" +
                             "%s\n" + // Implicitly calls PolicyHolder's toString
                             "Policy Price: $%.2f\n",
                             policyNumber, providerName, policyHolder.toString(), calculatePrice());
    }
}