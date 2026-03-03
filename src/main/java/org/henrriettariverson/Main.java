package org.henrriettariverson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MaintenanceOffice office = new MaintenanceOffice();

        MaintenanceRequest request1 =
                new MaintenanceRequest("Alice", "101A", "Plumbing", 3);

        MaintenanceRequest request2 =
                new MaintenanceRequest("Bob", "202B", "Electrical", 5);

        MaintenanceRequest request3 =
                new MaintenanceRequest("Cathy", "303C", "HVAC", 4);

        office.addRequest(request1);
        office.addRequest(request2);
        office.addRequest(request3);

        System.out.println("Initial Requests:");
        for (MaintenanceRequest request : office.getRequests()) {
            System.out.println(request);
            if (request.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }
        }

        while (true) {

            System.out.println("\nEnter tenant name (or type 'done'):");
            String name = input.nextLine();
            if (name.equalsIgnoreCase("done"))
                break;

            System.out.println("Apartment number:");
            String apt = input.nextLine();

            System.out.println("Issue type:");
            String issue = input.nextLine();

            System.out.println("Severity (1-5):");
            int severity = input.nextInt();
            input.nextLine();

            MaintenanceRequest newRequest =
                    new MaintenanceRequest(name, apt, issue, severity);

            office.addRequest(newRequest);

            System.out.println("Request logged successfully!");

            if (issue.equals("Electrical") && severity >= 4) {
                System.out.println("Electrical high severity warning!");
            }

            if (severity == 5) {
                System.out.println("Dispatching immediately!");
                office.assignTech(newRequest);
            }
        }

        for (MaintenanceRequest request : office.getRequests()) {
            if (request.getStatus().equals("NEW")) {
                office.assignTech(request);
            }
        }

        office.getRequests().get(0).setStatus("DONE");

        office.dailyReport();

        input.close();
    }
}
