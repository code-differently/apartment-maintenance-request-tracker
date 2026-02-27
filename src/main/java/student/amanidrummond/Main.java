package student.amanidrummond;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MaintenanceOffice office = new MaintenanceOffice();

        MaintenanceRequest r1 = new MaintenanceRequest("Jordan", "2A", "Plumbing", 3);
        MaintenanceRequest r2 = new MaintenanceRequest("Amani", "5C", "Electrical", 5);
        MaintenanceRequest r3 = new MaintenanceRequest("Chris", "1B", "HVAC",4);

        MaintenanceRequest[] starter = { r1, r2, r3 };

        System.out.println("=== LEVEL 1: STARTED REQUESTS ===");
        for (MaintenanceRequest r : starter) {
            System.out.println(r);

            if (r.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }

            office.logRequest(r);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== LEVEL 2: INTAKE FROM USER ===");
        while (true) {
            System.out.println("Enter tenant name (or type 'done' to stop): ");
            String tenantName = scanner.nextLine().trim();

            if (tenantName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter apartment number: ");
            String apt = scanner.nextLine().trim();

            System.out.println("Enter issue type: ");
            String issueType = scanner.nextLine().trim();

            System.out.println("Enter severity (1-5): ");
            int severity;
            try {
                severity = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                severity = 1;
            }

            MaintenanceRequest newReq = new MaintenanceRequest(tenantName, apt,issueType,severity);
            office.logRequest(newReq);

            System.out.println("Request logged: " + newReq);

            if (issueType.equalsIgnoreCase("Electrical") && newReq.getSeverity() <= 4) {
                System.out.println("WARNING: High severity electrical issue!");
            }

            if (newReq.getSeverity() == 5) {
                System.out.println("Dispatch immediately!");
            }
            System.out.println();
        }

        System.out.println("\n=== LEVEL 3: ASSIGN TECHS & UPDATE STATUS ===");
        for (MaintenanceRequest r : office.getRequests()) {
            office.assignTech(r);

            if (r.getStatus().equals("NEW")) {
                office.updateRequestStatus(r, "IN_PROGRESS");
            }

            System.out.println(r);
        }

        if (!office.getRequests().isEmpty()) {
            MaintenanceRequest first = office.getRequests().get(0);
            office.updateRequestStatus(first, "DONE");

            boolean closed = office.closeRequest(first);
            if (closed) {
                System.out.println("Closed rewuest (it was DONE).");
            } else {
                System.out.println("Did not close request (must be DONE). ");
            }
        }

        office.printDailyReport();

        scanner.close();

    }
}