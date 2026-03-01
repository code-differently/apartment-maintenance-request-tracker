package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class MaintenanceRequest {
    private static int count = 0;

    private String tenantName;
    private int apartmentNumber;
    private IssueType issueType;
    private Severity severity;
    private Status status;
    private String assignedTechnician;
    private int requestId;

    public MaintenanceRequest(String tenantName, int apartmentNumber, IssueType issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        if (severity == 1 || severity == 2) {
            this.severity = Severity.LOW;
        } else if (severity == 3 || severity == 4) {
            this.severity = Severity.MEDIUM;
        } else {
            this.severity = Severity.HIGH;
        }
        this.status = Status.NEW;
        this.requestId = count + 1;
        this.assignedTechnician = "None";
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

    public IssueType getIssueType() {
        return issueType;
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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MaintenanceRequest.count = count;
    }

    public static MaintenanceRequest createRequest(Scanner sc) {
        String name = validateName(sc);
        int apt = validateAptNum(sc);
        IssueType type = validateIssueType(sc);
        int severity = validateSeverity(sc);

        MaintenanceRequest ticket = new MaintenanceRequest(name, apt, type, severity);

        System.out.print("\nMaintenance request created.\n");

        System.out.println("Maintenance Request");
        System.out.println("Name: " + ticket.getTenantName());
        System.out.println("Apartment Number: " + ticket.getApartmentNumber());
        System.out.println("Issue Type: " + ticket.getIssueType());
        System.out.println("Severity: " + ticket.getSeverity());

        if (severity >= 4 && type == IssueType.ELECTRICAL) {
            System.out.println("WARNING! THIS REQUEST REQUIRES URGENT ATTENTION");
        }

        setCount(count + 1);
        return ticket;
    }


    @Override
    public String toString() {
        return "[Name: " + this.tenantName +
                ", Request Id: " + this.requestId +
                ", Apartment Number: " + this.apartmentNumber +
                ", Issue Type: " + this.issueType +
                ", Severity: " + this.severity +
                ", Status: " + this.getStatus() +
                ", Technician: " + this.getAssignedTechnician() + "]\n";
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

    public static int validateAptNum(Scanner sc) {
        // Repeats continuously until valid input is provided.
        while (true) {
            // Prompts the user to enter a severity level.
            System.out.print("Enter an apartment number: ");
            // Captures the full line of user input.
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Displays an error message if the input cannot be parsed as a number.
                System.out.println("\nInvalid input. Please enter a number.\n");
            }
        }
    }

    public static int validateSeverity(Scanner sc) {
        // Repeats continuously until valid input is provided.
        while (true) {
            // Prompts the user to enter a severity level.
            System.out.print("Rate its severity on a scale from 1-5: ");
            // Captures the full line of user input.
            String input = sc.nextLine();

            try {
                // Attempts to convert the input into an integer.
                int severity = Integer.parseInt(input);
                // Checks whether the integer falls within the valid range.
                if (severity >= 1 && severity <= 5) {
                    // Returns the validated severity level.
                    return severity;
                } else {
                    // Displays an error message if the number is outside the valid range.
                    System.out.println("\nInvalid input. Please enter a number from 1-5.\n");
                }
            } catch (NumberFormatException e) {
                // Displays an error message if the input cannot be parsed as a number.
                System.out.println("\nInvalid input. Please enter a number from 1-5.\n");
            }
        }
    }

    public static IssueType validateIssueType(Scanner sc) {
        // Repeats continuously until valid input is provided.
        while (true) {
            // Prompts the user to enter their name.
            System.out.print("Enter issue type: ");
            String issueType = sc.nextLine();

            if (issueType.equalsIgnoreCase("Electrical")) {
                return IssueType.ELECTRICAL;
            } else if (issueType.equalsIgnoreCase("HVAC")) {
                return IssueType.HVAC;
            } else if (issueType.equalsIgnoreCase("PLUMBING")) {
                return IssueType.PLUMBING;
            } else if (issueType.equalsIgnoreCase("APPLIANCE")) {
                return IssueType.APPLIANCE;
            } else {
                System.out.println("""
                        
                        Invalid issue type. We only handle Electrical,\
                         HVAC, Plumbing, or Appliance related inquiries.
                        """);
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
