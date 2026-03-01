package maintenance;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MaintenanceOffice office = new MaintenanceOffice();


        MaintenanceRequest r1 = new MaintenanceRequest("Alex", "12A", "Plumbing", 3);

        MaintenanceRequest r2 = new MaintenanceRequest("Bri", "7C", "Electrical", 4);

        MaintenanceRequest r3 = new MaintenanceRequest("Chris", "4B", "HVAC", 5);

        office.addRequest(r1);

        office.addRequest(r2);

        office.addRequest(r3);

        System.out.println("=== LEVEL 1: INITIAL REQUESTS ===");

        for (MaintenanceRequest r : office.getRequests()) {

            System.out.println(r);

            if (r.getSeverity() >= 4) {

                System.out.println("HIGH PRIORITY");
            }
        }


        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== LEVEL 2: ENTER NEW REQUESTS (type 'done' for tenant name to stop) ===");

        while (true) {

            System.out.print("\nTenant name: ");

            String tenant = scanner.nextLine().trim();

            if (tenant.equalsIgnoreCase("done")) break;

            System.out.print("Apartment number: ");

            String apt = scanner.nextLine().trim();

            System.out.print("Issue type (Plumbing/Electrical/HVAC/etc): ");

            String issue = scanner.nextLine().trim();

            int severity = readSeverity(scanner);

            MaintenanceRequest newReq = new MaintenanceRequest(tenant, apt, issue, severity);

            office.addRequest(newReq);

            System.out.println("✅ Request logged: " + newReq);


            if (issue.equalsIgnoreCase("Electrical") && severity >= 4) {

                System.out.println("⚠ WARNING: High severity electrical issue!");
            }
            if (severity == 5) {

                System.out.println("🚨 DISPATCH IMMEDIATELY: Severity 5!");
            }
        }


        if (!office.getRequests().isEmpty()) {

            MaintenanceRequest first = office.getRequests().get(0);

            office.updateStatus(first, "IN_PROGRESS");

            office.updateStatus(first, "DONE");
            office.closeRequest(first);
        }


        office.printDailyReport();


        System.out.println("=== FINAL REQUEST LIST ===");

        for (MaintenanceRequest r : office.getRequests()) {

            System.out.println(r);
        }

        scanner.close();
    }

    private static int readSeverity(Scanner scanner) {
        while (true) {

            System.out.print("Severity (1-5): ");

            String input = scanner.nextLine().trim();

            try {

                int sev = Integer.parseInt(input);

                if (sev < 1 || sev > 5) {

                    System.out.println("Enter a number from 1 to 5.");

                    continue;
                }
                return sev;

            } catch (NumberFormatException e) {
                
                System.out.println("Enter a valid integer from 1 to 5.");
            }
        }
    }
}