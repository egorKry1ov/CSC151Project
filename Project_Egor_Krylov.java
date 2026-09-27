import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Project_Egor_Krylov {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                String policyNumber = fileScanner.nextLine();
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                // Create PolicyHolder object first
                PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);

                // Create Policy object, passing the holder (Class collaboration)
                Policy policy = new Policy(policyNumber, providerName, holder);

                policies.add(policy);

                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else if (smokingStatus.equalsIgnoreCase("non-smoker")) {
                    nonSmokerCount++;
                }
            }
            
            fileScanner.close();

            // Step 6: Iterate and implicitly call toString
            for (Policy policy : policies) {
                System.out.println(policy);
                System.out.println(); // Blank line between policies
            }

            // Step 7: Display final counts
            System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'PolicyInformation.txt' was not found.");
        }
    }
}