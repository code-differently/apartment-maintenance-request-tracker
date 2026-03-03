package org.codedifferently.michaelmoss;

import java.util.Scanner;

public class Main {


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            MaintenanceOffice office = new MaintenanceOffice();

            // Level 1 — Preloaded Requests
            MaintenanceRequest r1 = new MaintenanceRequest("John Smith", "101", "Plumbing", 2);
            MaintenanceRequest r2 = new MaintenanceRequest("Lisa Brown", "204", "Electrical", 5);
            MaintenanceRequest r3 = new MaintenanceRequest("Mark Lee", "305", "HVAC", 4);

            office.addRequest(r1);
            office.addRequest(r2);
            office.addRequest(r3);

            System.out.println("Initial Requests:");
            for (MaintenanceRequest r : office.getRequests()) {
                System.out.println(r);
                if (r.getSeverity() >= 4) {
                    System.out.println("HIGH PRIORITY");
                }
            }

            // Level 2 — User Intake
            System.out.println("\nEnter new maintenance requests (type 'done' to stop)");

            while (true) {
                System.out.print("Tenant name: ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("done"))
                    break;

                System.out.print("Apartment number: ");
                String apt = scanner.nextLine();

                System.out.print("Issue type: ");
                String issue = scanner.nextLine();

                System.out.print("Severity (1-5): ");
                int severity = Integer.parseInt(scanner.nextLine());

                MaintenanceRequest newRequest = new MaintenanceRequest(name, apt, issue, severity);
                office.addRequest(newRequest);

                System.out.println("Request logged successfully.");

                // Rules
                if (issue.equalsIgnoreCase("Electrical") && severity >= 4) {
                    System.out.println("WARNING: High-risk electrical issue!");
                }

                if (severity == 5) {
                    System.out.println("Dispatching technician immediately.");
                    office.assignTech(newRequest);
                }
            }

            // Level 3 — Mark some requests done for demo
            if (!office.getRequests().isEmpty()) {
                MaintenanceRequest first = office.getRequests().get(0);
                first.setStatus("DONE");
                office.closeRequest(first);
            }

            // Level 4 — Report
            office.printDailyReport();

            scanner.close();
        }
    }

