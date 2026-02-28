package org.codedifferently;

import java.util.Scanner;

public class MaintenanceTracker {
    public static void displayMenu(Scanner sc) {
        String input;
        do {
            // Displays the main menu options to the user.
            System.out.println("\n=== Maintenance Management Menu ===");
            System.out.println("Type \"Enter\" to make a new request");
            System.out.println("Type \"Done\" to exit out");
            System.out.print("Selection: ");

            // Validates numeric input before processing.
            input = sc.nextLine();

            switch (input) {
                case "Enter":
                    break;
                case "Done":
                    break;
                default:
                    System.out.println("\nPlease select a valid option.");
            }
            // Stopping condition. Program will exit when the user inputs 0.
        } while (!(input.equals("Done")));
    }
}
