package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class MaintenanceTracker {
    private static MaintenanceOffice office = new MaintenanceOffice();

    public static void displayMenu(Scanner sc) {
        String input;
        do {
            // Displays the main menu options to the user.
            System.out.println("\n=== Maintenance Management Menu ===");
            System.out.println("Type \"Enter\" to make a new request.");
            System.out.println("Type \"Assign\" to assign a technician.");
            System.out.println("Type \"Update\" to get a status update on all requests.");
            System.out.println("Type \"Report\" to print a daily report.");
            System.out.println("Type \"Done\" to exit out.");
            System.out.print("Selection: ");

            // Validates numeric input before processing.
            input = sc.nextLine();

            switch (input) {
                case "Enter":
                    MaintenanceRequest request = MaintenanceRequest.createRequest(sc);
                    office.addRequest(request);
                    if (request.getSeverity() == 5) {
                        office.assignTechnician(request);
                    }
                    break;
                case "Assign":
                    System.out.print("Enter an apt number: ");
                    int aptNum = sc.nextInt();
                    sc.nextLine();
                    MaintenanceRequest toAssign = office.searchRequest(aptNum, sc);
                    office.assignTechnician(toAssign);
                case "Done":
                    break;
                default:
                    System.out.println("\nPlease select a valid option.");
            }
            // Stopping condition. Program will exit when the user inputs 0.
        } while (!(input.equals("Done")));
        sc.close();
    }
}
