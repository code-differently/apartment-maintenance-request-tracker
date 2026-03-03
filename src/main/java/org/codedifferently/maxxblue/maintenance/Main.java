package org.codedifferently.maxxblue.maintenance;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create office system
        MaintenanceOffice office = new MaintenanceOffice();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        // Main menu loop
        while (running) {

            System.out.println("\n===== APARTMENT MAINTENANCE SYSTEM =====");
            System.out.println("1. Add Maintenance Request");
            System.out.println("2. Print Daily Report");
            System.out.println("3. Close Request (Maintenance Only)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addRequest(scanner, office);
                    break;

                case "2":
                    office.printDailyReport();
                    break;

                case "3":
                    closeRequestMenu(scanner, office);
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    // ===============================
    // ADD REQUEST METHOD
    // ===============================
    private static void addRequest(Scanner scanner, MaintenanceOffice office) {

        System.out.print("Tenant Name: ");
        String name = scanner.nextLine();

        System.out.print("Apartment Number: ");
        String apt = scanner.nextLine();

        System.out.print("Issue Type: ");
        String issue = scanner.nextLine();

        System.out.print("Severity (1-5): ");
        int severity = readInt(scanner);

        // Create request object
        MaintenanceRequest request =
                new MaintenanceRequest(name, apt, issue, severity);

        // Electrical + high severity warning
        if (issue.equalsIgnoreCase("Electrical") && severity >= 4) {
            System.out.println("⚠ WARNING: High severity electrical issue!");
        }

        // Immediate dispatch rule
        if (severity == 5) {
            System.out.println("🚨 DISPATCH IMMEDIATELY!");
        }

        // Add request to office system
        office.addRequest(request);

        System.out.println("Assigned Tech: " + request.getAssignedTech());

        // USER can only set NEW or IN_PROGRESS
        System.out.print("Update Status (NEW/IN_PROGRESS): ");
        String status = scanner.nextLine();

        office.updateStatus(request, status);

        System.out.println("Request Saved Successfully!");
    }

    // ===============================
    // MAINTENANCE CLOSE METHOD
    // ===============================
    private static void closeRequestMenu(Scanner scanner, MaintenanceOffice office) {

        System.out.print("Enter tenant name to close request: ");
        String name = scanner.nextLine();

        // Search for matching request
        for (MaintenanceRequest r : office.getRequests()) {

            if (r.getTenantName().equalsIgnoreCase(name)) {

                // Maintenance attempts to close it
                office.closeRequest(r);
                return;
            }
        }

        System.out.println("Request not found.");
    }

    // ===============================
    // SAFE INTEGER INPUT METHOD
    // ===============================
    private static int readInt(Scanner scanner) {

        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}