package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class MaintenanceRequest {
    private static int count = 0;

    private String tenantName;
    private int apartmentNumber;
    private String issueType;
    private Severity severity;
    private Status status;
    private String assignedTechnician;
    private int requestId;

    public MaintenanceRequest(String tenantName, int apartmentNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        if (severity == 1 || severity == 2) {
            this.severity = Severity.LOW;
        } else if (severity == 3) {
            this.severity = Severity.MEDIUM;
        } else {
            this.severity = Severity.HIGH;
        }
        this.status = Status.NEW;
        this.requestId = count + 1;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MaintenanceRequest.count = count;
    }

    public static MaintenanceRequest createRequest(Scanner sc) {
        String name = validateName(sc);

        System.out.print("Enter an apartment number: ");
        int apt = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter issue type: ");
        String type = sc.nextLine();

        System.out.print("Rate it's severity on a scale from 1-5");
        int severity = validateSeverity(sc);

        MaintenanceRequest ticket = new MaintenanceRequest(name, apt, type, severity);

        System.out.print("Maintenance request created.\n");
        ticket.toString();

        if (severity >= 4 && type.equalsIgnoreCase("Electrical")) {
            System.out.println("WARNING! THIS REQUEST REQUIRES URGENT ATTENTION");
        }

        setCount(count + 1);
        return ticket;
    }


    @Override
    public String toString() {
        System.out.println("Maintenance Ticket");
        System.out.println("Name: " + this.tenantName);
        System.out.println("Apartment Number: " + this.apartmentNumber);
        System.out.println("Issue Type: " + this.issueType);
        System.out.println("Severity: " + this.severity);
        return null;
    }

    // Validates that the user's name input contains only permitted characters.
    public static String validateName(Scanner sc) {
        // Repeats continuously until valid input is provided.
        while (true) {
            // Prompts the user to enter their name.
            System.out.print("\nEnter a name: ");
            String name = sc.nextLine();

            // Checks whether the input matches the required name pattern.
            // Allows letters and optionally single spaces, hyphens, or apostrophes between words.
            if (name.matches("^[a-zA-Z]+([ '-][a-zA-Z]+)*$")) {
                // Returns the validated name if it meets the pattern requirements.
                return name;
            } else {
                // Displays an error message if validation fails.
                System.out.println("\nInvalid name. Please use letters only.");
            }
        }
    }

    public static int validateSeverity(Scanner sc) {
        // Repeats continuously until valid input is provided.
        while (true) {
            // Prompts the user to enter their name.
            System.out.print("\nRate it's severity on a scale from 1-5: ");
            int severity = sc.nextInt();

            if (severity >= 1 && severity <= 5) {
                return severity;
            } else {
                System.out.println("\nInvalid severity level. Please provide a number on a 1-5 scale.");
            }
        }
    }

    public String getAssignedTechnician() {
        return assignedTechnician;
    }

    public void setAssignedTechnician(String assignedTechnician) {
        this.assignedTechnician = assignedTechnician;
    }
}
