package org.codedifferently;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MaintenanceOffice office = new MaintenanceOffice();

        // Level 1 — Pre-created requests
        MaintenanceRequest r1 = new MaintenanceRequest("John Smith", 101, "Plumbing", 2);
        MaintenanceRequest r2 = new MaintenanceRequest("Lisa Ray", 204, "Electrical", 5);
        MaintenanceRequest r3 = new MaintenanceRequest("Mark Lee", 305, "Heating", 4);

        System.out.println("---- INITIAL REQUESTS ----");

        MaintenanceRequest[] initial = {r1, r2, r3};

        for (MaintenanceRequest r : initial) {
            System.out.println(r);

            if (r.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }

            office.addRequest(r);
        }

        // Level 2 — User Intake
        while (true) {

            System.out.println("\nEnter tenant name (or type 'done'):");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Apartment number:");
            int apt = Integer.parseInt(scanner.nextLine());

            System.out.println("Issue type:");
            String issue = scanner.nextLine();

            System.out.println("Severity (1-5):");
            int severity = Integer.parseInt(scanner.nextLine());

            MaintenanceRequest request = new MaintenanceRequest(name, apt, issue, severity);

            office.addRequest(request);

            System.out.println("Request logged successfully.");

            if (issue.equalsIgnoreCase("Electrical") && severity >= 4) {
                System.out.println("⚠ Electrical High Severity Warning!");
            }

            if (severity == 5) {
                System.out.println("Dispatching technician immediately!");
                office.assignTechnician(request);
            }
        }

        // ===== Cancel Option =====
        System.out.println("\nEnter tenant name to cancel (or press Enter to skip):");
        String cancelName = scanner.nextLine();

        if (!cancelName.isBlank()) {
            office.cancelRequestByTenantName(cancelName);
        }

        // ===== Daily Report =====
        office.generateDailyReport();

        scanner.close();
    }
}