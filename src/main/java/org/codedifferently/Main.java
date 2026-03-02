package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize office and technicians
        ArrayList<Technician> techs = new ArrayList<>();
        techs.add(new Technician("ELECTRICAL", "Wilson Fisk"));
        techs.add(new Technician("PLUMBING", "Steve Rogers"));
        techs.add(new Technician("HVAC", "Frank Castle"));
        techs.add(new Technician("APPLIANCE", "Luke Cage"));

        ArrayList<MaintenanceRequest> requests = new ArrayList<>();
        MaintenanceOffice office = new MaintenanceOffice(techs, requests);

        // Level 1: create at least 3 requests
        MaintenanceRequest r1 = new MaintenanceRequest("Alice", 101, "ELECTRICAL", 3);
        MaintenanceRequest r2 = new MaintenanceRequest("Bob", 202, "PLUMBING", 2);
        MaintenanceRequest r3 = new MaintenanceRequest("Charlie", 303, "HVAC", 4);

        office.addRequest(r1);
        office.addRequest(r2);
        office.assignTechnician(r2);
        //mark a request as done
        r2.setStatus("DONE");
        office.addRequest(r3);
        office.assignTechnician(r3);

        System.out.println("*** Initial Requests ***");
        for (MaintenanceRequest request : office.getRequests()) {
            System.out.println(request);
            if (request.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }
        }
        System.out.println();
        System.out.println("************************************");

        // level 2 and 3: intake from user and assign and update
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter tenant name (or 'done' to finish):");
            String tenantName = scanner.nextLine();
            if (tenantName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter apartment number:");
            String aptNum = scanner.nextLine().toUpperCase();

            System.out.println("Enter issue type (Electrical, Plumbing, HVAC, Appliance):");
            String issueType = scanner.nextLine().toUpperCase();

            System.out.println("Enter severity (1-5):");
            int severity;
            try {
                severity = Integer.parseInt(scanner.nextLine());
                if (severity < 1 || severity > 5) {
                    System.out.println("Invalid severity. Must be 1-5. Defaulting to 3.");
                    severity = 3;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Defaulting to 3.");
                severity = 3;
            }

            MaintenanceRequest newRequest = new MaintenanceRequest(tenantName, Integer.parseInt(aptNum), issueType, severity);
            office.addRequest(newRequest);
            // Print confirmation
            office.assignTechnician(newRequest);
            System.out.println("Request added: " + newRequest);
        }

        //level 4: daily report
        office.generateDailyReport();

        scanner.close();
    }
}