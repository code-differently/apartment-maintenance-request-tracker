package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MaintenanceRequest request1 = new MaintenanceRequest("Bob", "A1", "Water Leak", 4);
        MaintenanceRequest request2 = new MaintenanceRequest("Sam", "B1", "Broken Spring", 1, "Old");
        MaintenanceRequest request3 = new MaintenanceRequest("Larry", "C1", "Window Repair", 2);

        ArrayList<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest>();

        requests.add(request1);
        requests.add(request2);
        requests.add(request3);

        for (MaintenanceRequest request : requests) {
            System.out.println(request.toString());
            if (request.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");

            }
        }


        Scanner scanner = new Scanner(System.in);

        boolean exitCondition = false;

        while (!exitCondition) {

            System.out.print("Enter tenant name (or type 'done' to exit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter apartment number: ");
            String aptnum = scanner.nextLine();
            if (aptnum.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter issue type: ");
            String issue = scanner.nextLine();
            if (issue.equalsIgnoreCase("done")) {
                break;
            }

            int severity = 0;

            while (true) {
                System.out.print("Enter severity (1-5): ");
                String severityInput = scanner.nextLine();

                if (severityInput.equalsIgnoreCase("done")) {
                    return; // exits entire method
                }

                try {
                    severity = Integer.parseInt(severityInput);

                    if (severity >= 1 && severity <= 5) {
                        break;
                    } else {
                        System.out.println("Severity must be between 1 and 5.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or 'done'.");
                }
            }

            System.out.println("Request Received");
            MaintenanceRequest request = new MaintenanceRequest(name, aptnum, issue, severity);
            requests.add(request);

        }
    }
}