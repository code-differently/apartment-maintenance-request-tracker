package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Starter requests
        MaintenanceRequest request1 = new MaintenanceRequest("Bob", "A1", "Water Leak", 4);
        MaintenanceRequest request2 = new MaintenanceRequest("Sam", "B1", "Broken Spring", 1, "NEW");
        MaintenanceRequest request3 = new MaintenanceRequest("Larry", "C1", "Window Repair", 2);

        MaintenanceOffice office = new MaintenanceOffice();
        office.addRequest(request1);
        office.addRequest(request2);
        office.addRequest(request3);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MAINTENANCE MENU ---");
            System.out.println("1) Create a request");
            System.out.println("2) Assign a tech to an existing request");
            System.out.println("3) Update request status (NEW / IN_PROGRESS / DONE)");
            System.out.println("4) Daily report");
            System.out.println("5) Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": {
                    // CREATE REQUEST
                    System.out.print("Enter tenant name (or type 'done' to cancel): ");
                    String name = scanner.nextLine().trim();
                    if (name.equalsIgnoreCase("done")) break;

                    System.out.print("Enter apartment number (or type 'done' to cancel): ");
                    String apt = scanner.nextLine().trim();
                    if (apt.equalsIgnoreCase("done")) break;

                    System.out.print("Enter issue type (or type 'done' to cancel): ");
                    String issue = scanner.nextLine().trim();
                    if (issue.equalsIgnoreCase("done")) break;

                    int severity;
                    while (true) {
                        System.out.print("Enter severity (1-5) (or type 'done' to cancel): ");
                        String sevInput = scanner.nextLine().trim();
                        if (sevInput.equalsIgnoreCase("done")) {
                            severity = -1;
                            break;
                        }
                        try {
                            severity = Integer.parseInt(sevInput);
                            if (severity >= 1 && severity <= 5) break;
                            System.out.println("Severity must be 1-5.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number.");
                        }
                    }
                    if (severity == -1) break;

                    MaintenanceRequest newReq = new MaintenanceRequest(name, apt, issue, severity);
                    office.addRequest(newReq);

                    // Special actions + assign tech
                    office.handleSpecialCases(newReq);
                    String tech = office.assignTech(newReq);
                    System.out.println("Request received and saved.");
                    System.out.println("Assigned tech: " + tech);
                    break;
                }

                case "2": {
                    // ASSIGN TECH TO EXISTING
                    System.out.print("Enter tenant name (or type 'done' to cancel): ");
                    String name = scanner.nextLine().trim();
                    if (name.equalsIgnoreCase("done")) break;

                    System.out.print("Enter apartment number (or type 'done' to cancel): ");
                    String apt = scanner.nextLine().trim();
                    if (apt.equalsIgnoreCase("done")) break;

                    MaintenanceRequest found = office.findActiveRequest(name, apt);
                    if (found == null) {
                        System.out.println("No ACTIVE request found for " + name + " (Apt " + apt + ").");
                    } else {
                        System.out.println("Found: " + found);
                        System.out.println("Assigned tech: " + office.assignTech(found));
                    }
                    break;
                }

                case "3": {
                    // UPDATE STATUS
                    System.out.print("Enter tenant name (or type 'done' to cancel): ");
                    String name = scanner.nextLine().trim();
                    if (name.equalsIgnoreCase("done")) break;

                    System.out.print("Enter apartment number (or type 'done' to cancel): ");
                    String apt = scanner.nextLine().trim();
                    if (apt.equalsIgnoreCase("done")) break;

                    MaintenanceRequest found = office.findActiveRequest(name, apt);
                    if (found == null) {
                        System.out.println("No ACTIVE request found for " + name + " (Apt " + apt + ").");
                        break;
                    }

                    System.out.print("Enter new status (NEW / IN_PROGRESS / DONE): ");
                    String newStatus = scanner.nextLine().trim();

                    boolean updated = office.updateStatus(found, newStatus);
                    if (!updated) break;

                    System.out.println("Updated: " + found);

                    // If DONE -> close and move to closed list
                    if ("DONE".equals(found.getStatus())) {
                        boolean closed = office.closeRequest(found);
                        if (closed) {
                            System.out.println("Request moved to CLOSED list.");
                        }
                    }
                    break;
                }

                case "4": {
                    // DAILY REPORT
                    office.dailyReport();
                    break;
                }

                case "5": {
                    running = false;
                    System.out.println("Goodbye.");
                    break;
                }

                default:
                    System.out.println("Invalid choice. Pick 1-5.");
            }
        }

        scanner.close();
    }
}