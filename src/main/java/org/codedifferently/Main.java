package org.codedifferently;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MaintenanceRequest> requests = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Intake requests from the user
        while (true) {
            System.out.print("Enter issue type (or 'done' to finish): ");
            String issueType = scanner.nextLine();
            if (issueType.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter severity level (1-5): ");
            int severity = Integer.parseInt(scanner.nextLine());

            MaintenanceRequest request = new MaintenanceRequest(issueType, severity);
            requests.add(request);
            System.out.println("Request logged: " + request);
            if (severity >= 4) {
                System.out.println("HIGH PRIORITY");
            }
        }

        // Print all requests
        System.out.println("\nAll logged requests:");
        for (MaintenanceRequest req : requests) {
            System.out.println(req);
        }
    }
}