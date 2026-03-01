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

        office.logRequest(r1);
        office.logRequest(r2);
        office.logRequest(r3);

        System.out.println("\n--- LEVEL 1: REQUESTS ---");
        for (MaintenanceRequest r : office.getRequests()) {
            System.out.println(r);
            if (r.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }
        }

        // LEVEL 2 — User intake loop (stop when "done")
        System.out.println("\n--- LEVEL 2: ENTER REQUESTS ---");

        while (true) {

            System.out.print("Tenant name (or type 'done'): ");
            String tenantName = scan.nextLine();
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

            // Level 2 rules (prints only)
            if (issueType.equalsIgnoreCase("Electrical") && severity >= 4) {
                System.out.println(" WARNING: High severity ELECTRICAL issue!");
            }
            if (severity == 5) {
                System.out.println(" DISPATCH IMMEDIATELY: Severity 5 request!");
            }

            office.logRequest(newReq);
            System.out.println("Request logged: " + newReq);
            System.out.println();
        }

        ArrayList<MaintenanceRequest> all = office.getRequests();

        if (all.size() > 0) {
            MaintenanceRequest first = all.get(0);

            System.out.println("\n--- LEVEL 3: STATUS UPDATE DEMO ---");
            System.out.println("Before: " + first);

            office.updateStatus(first, "IN_PROGRESS");
            office.updateStatus(first, "DONE");

            // close only allowed if DONE
            office.closeRequest(first);

            System.out.println("After:  " + first);
        }

        // LEVEL 4 — Daily report
        office.printDailyReport();

        scan.close();
    }
}