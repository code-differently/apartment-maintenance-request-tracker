package mesheikbrown;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        MaintenanceOffice office = new MaintenanceOffice();

        // LEVEL 1 — Create 3 requests and print with loop
        MaintenanceRequest r1 = new MaintenanceRequest("Jordan", "2B", "Plumbing", 3);
        MaintenanceRequest r2 = new MaintenanceRequest("Coreye", "4A", "Electrical", 5);
        MaintenanceRequest r3 = new MaintenanceRequest("Mesheik", "1C", "Heating", 4);

        // Instead of storing requests directly in Main,
        // we send them to the MaintenanceOffice.
        // This keeps business logic OUT of Main.
        office.logRequest(r1);
        office.logRequest(r2);
        office.logRequest(r3);

        System.out.println("\n--- LEVEL 1: REQUESTS ---");
        // We loop through ALL stored requests using a for-each loop.
        // This demonstrates loop usage.
        for (MaintenanceRequest r : office.getRequests()) {

            System.out.println(r);

            // If severity is 4 or 5, mark as HIGH PRIORITY
            if (r.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }
        }

        // LEVEL 2 — User intake loop (stop when "done")
        System.out.println("\n--- LEVEL 2: ENTER REQUESTS ---");

        // This loop continues until user types "done"
        while (true) {

            System.out.print("Tenant name (or type 'done'): ");
            String tenantName = scan.nextLine();

            // If user types "done", stop the loop
            if (tenantName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Apartment number: ");
            String apt = scan.nextLine();

            System.out.print("Issue type: ");
            String issueType = scan.nextLine();

            System.out.print("Severity (1-5): ");
            int severity = Integer.parseInt(scan.nextLine());

            MaintenanceRequest newReq = new MaintenanceRequest(tenantName,apt, issueType, severity);

            // LEVEL 2 RULES
            // If issue is Electrical AND severity >= 4
            // Print warning message
            if (issueType.equalsIgnoreCase("Electrical") && severity >= 4) {
                System.out.println(" WARNING: High severity ELECTRICAL issue!");
            }
            // If severity is 5 → dispatch immediately
            if (severity == 5) {
                System.out.println(" DISPATCH IMMEDIATELY: Severity 5 request!");
            }

            // Send request to MaintenanceOffice to store and assign tech
            office.logRequest(newReq);
            System.out.println("Request logged: " + newReq);
            System.out.println();
        }

        // We grab all stored requests from the office.
        ArrayList<MaintenanceRequest> all = office.getRequests();

        // If at least one request exists,
        // demonstrate updating and closing.
        if (all.size() > 0) {
            MaintenanceRequest first = all.get(0);

            System.out.println("\n--- LEVEL 3: STATUS UPDATE DEMO ---");
            System.out.println("Before: " + first);

            // Update status to IN_PROGRESS
            office.updateStatus(first, "IN_PROGRESS");

            // Update status to DONE
            office.updateStatus(first, "DONE");

            // Attempt to close (only works if status is DONE)
            office.closeRequest(first);

            System.out.println("After:  " + first);
        }

        // LEVEL 4 — Daily report
        // Generate full system report
        // This demonstrates loops + conditionals inside the office class.
        office.printDailyReport();

        // Close scanner to prevent memory leak warning
        scan.close();
    }
}