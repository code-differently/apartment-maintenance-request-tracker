package coreyscott;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<MaintenanceRequest> requests = new ArrayList<>();
        MaintenanceOffice office = new MaintenanceOffice();

        requests.add(new MaintenanceRequest("Greg Brady", "102A", "Electrical", 5));
        requests.add(new MaintenanceRequest("Walter White", "203B", "HVAC", 4));
        requests.add(new MaintenanceRequest("Franklin Saint", "302C", "Plumbing", 3));

        System.out.println("=== INITIAL REQUESTS ===");
        for (MaintenanceRequest request : requests) {
            System.out.println(request);
            System.out.println(request.getEstimatedCostBreakdown());

            if (request.getIssueSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }

            office.assignTech(request);
            office.updateStatus(request, "DONE");
            office.closeRequest(request);

            System.out.println("---------------------");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter tenant name (or type 'done' to stop): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Apartment number: ");
            String apt = scanner.nextLine();

            System.out.print("Issue type: ");
            String issue = scanner.nextLine();

            System.out.print("Severity (1-5): ");
            int severity = Integer.parseInt(scanner.nextLine());

            MaintenanceRequest newRequest = new MaintenanceRequest(name, apt, issue, severity);
            requests.add(newRequest);

            System.out.println("Request logged successfully!");
            System.out.println(newRequest);
            System.out.println(newRequest.getEstimatedCostBreakdown());

            if (issue.equalsIgnoreCase("Electrical") && severity >= 4) {
                System.out.println("WARNING: High severity electrical issue!");
            }

            if (severity == 5) {
                System.out.println("Dispatch immediately!");
            }

            office.assignTech(newRequest);
            office.updateStatus(newRequest, "DONE");
            office.closeRequest(newRequest);

            System.out.println("---------------------");
        }

        office.printDailyReport(requests);

        scanner.close();
    }
}