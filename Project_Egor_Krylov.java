import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Project_Egor_Krylov {
    public static void main(String[] args) {
        // Create an ArrayList to store Policy objects (automatically adjusts size)
        ArrayList<Policy> policies = new ArrayList<>();
        
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            // Open the file
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            // Read through the file until there are no more lines
            while (fileScanner.hasNext()) {
                // Read each piece of information
                String policyNumber = fileScanner.nextLine();
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                
                // Parse numeric values
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                // Create a new Policy object with the gathered information
                Policy policy = new Policy(policyNumber, providerName, firstName,
                                           lastName, age, smokingStatus, height, weight);

                // Add the Policy object to the ArrayList
                policies.add(policy);

                // Count smokers and non-smokers
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else if (smokingStatus.equalsIgnoreCase("non-smoker")) {
                    nonSmokerCount++;
                }
            }
            
            // Close the file scanner
            fileScanner.close();

            // Iterate over the ArrayList and display the information for each policy
            for (Policy policy : policies) {
                System.out.println("Policy Number: " + policy.getPolicyNumber());
                System.out.println("Provider Name: " + policy.getProviderName());
                System.out.println("Policyholder's First Name: " + policy.getFirstName());
                System.out.println("Policyholder's Last Name: " + policy.getLastName());
                System.out.println("Policyholder's Age: " + policy.getAge());
                System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
                System.out.printf("Policyholder's Height: %.1f inches%n", policy.getHeight());
                System.out.printf("Policyholder's Weight: %.1f pounds%n", policy.getWeight());
                System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
                System.out.printf("Policy Price: $%.2f%n", policy.calculatePrice());
                System.out.println(); // Blank line between policies for readability
            }

            // Display the final counts
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            // Handle the error if the file isn't found
            System.out.println("Error: The file 'PolicyInformation.txt' was not found.");
            System.out.println("Please make sure the file is in the project directory.");
        }
    }
}