package org.codedifferently;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MaintenanceTracker {
    private static MaintenanceOffice office = new MaintenanceOffice();

    public static void displayMenu(Scanner sc) {
        String input;
        int aptNum;
        do {
            // Displays the main menu options to the user.
            System.out.println("\n=== Maintenance Management Menu ===");
            System.out.println("Type \"Enter\" to make a new request.");
            System.out.println("Type \"View\" to view all current requests.");
            System.out.println("Type \"Assign\" to assign a technician.");
            System.out.println("Type \"Status\" to get a status update on all requests.");
            System.out.println("Type \"Close\" to close a request.");
            System.out.println("Type \"Report\" to print a daily report.");
            System.out.println("Type \"Done\" to exit out.");
            System.out.print("Selection: ");

            // Validates numeric input before processing.
            input = sc.nextLine().toLowerCase();
            switch (input) {
                case "enter":
                    MaintenanceRequest request = MaintenanceRequest.createRequest(sc);
                    office.addRequest(request);
                    if (request.getSeverity() == Severity.HIGH) {
                        office.assignTechnician(request);
                    }
                    break;
                case "view":
                    office.viewRequests();
                    break;
                case "assign":
                    System.out.print("Enter an apt number: ");
                    aptNum = sc.nextInt();
                    sc.nextLine();
                    MaintenanceRequest toAssign = office.searchRequest(aptNum, sc);
                    if (toAssign != null) {
                        office.assignTechnician(toAssign);
                    } else {
                        System.out.println("Apartment Number not found. Please try again.");
                    }
                    break;
                case "status":
                    office.getProgressUpdate();
                    break;
                case "close":
                    System.out.print("Enter an apt number: ");
                    aptNum = sc.nextInt();
                    sc.nextLine();
                    MaintenanceRequest toClose = office.searchRequest(aptNum, sc);
                    if (toClose != null) {
                        office.closeRequest(toClose);
                    } else {
                        System.out.println("Apartment Number not found. Please try again");
                    }
                    break;
                case "report":
                    office.printDailyReport();
                    break;
                case "done":
                    break;
                default:
                    System.out.println("\nPlease select a valid option.");
            }
            // Stopping condition. Program will exit when the user inputs 0.
        } while (!(input.equalsIgnoreCase("Done")));
        System.out.println("\nGoodbye.");
        sc.close();
    }
}
