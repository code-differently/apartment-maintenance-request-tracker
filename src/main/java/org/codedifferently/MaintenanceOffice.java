package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class MaintenanceOffice {
    private static ArrayList<MaintenanceRequest> requests;
    private static int closures = 0;
    private int lowSeverity = 0;
    private int medSeverity = 0;
    private int highSeverity = 0;

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    public void assignTechnician(MaintenanceRequest request) {
        if (request.getSeverity() == Severity.HIGH) {
            request.setAssignedTechnician("Senior Technician");
        } else {
            request.setAssignedTechnician("Junior Technician");
        }
        request.setStatus(Status.IN_PROGRESS);
    }

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
        if (request.getSeverity() == Severity.LOW) {
            lowSeverity++;
        } else if (request.getSeverity() == Severity.MEDIUM) {
            medSeverity++;
        } else {
            highSeverity++;
        }
    }

    public void getProgressUpdate() {
        for (MaintenanceRequest request : requests) {
            if (request.getStatus() == Status.IN_PROGRESS) {
                request.setStatus(Status.DONE);
            }
        }
    }

    public MaintenanceRequest searchRequest(int aptNum, Scanner sc) {
        ArrayList<MaintenanceRequest> requestsFound = new ArrayList<>();
        for (MaintenanceRequest request : requests) {
            if (request.getApartmentNumber() == aptNum) {
                requestsFound.add(request);
            }
        }
        // Returns null if the customer is not found.
        if (requestsFound.isEmpty()) {
            return null;
            // Returns the customer if there are no duplicate phone numbers.
        } else if (requestsFound.size() == 1) {
            return requestsFound.getFirst();
            // Prompts the user to select by customer id since more than one customer used the same phone number.
        } else {
            System.out.println("\nMultiple requests found: " + requestsFound + "\n");
            while(true) {
                System.out.print("Enter request id: ");
                int requestId = sc.nextInt();
                for (MaintenanceRequest request : requests) {
                    if (request.getRequestId() == requestId) {
                        return request;
                    }
                }
                System.out.println("Invalid tenant name. Try again.\n");
            }
        }
    }

    public void printDailyReport() {
        System.out.println("=== DAILY REPORT ===");
        System.out.println("Total Requests: " + MaintenanceRequest.getCount());
        System.out.println("Number of Open Requests Currently Open: " + requests.size());
        System.out.println("Number of Closed Requests: " + closures);

        System.out.println("\nNumber of Low Severity Cases: " + lowSeverity);
        System.out.println("Number of Medium Severity Cases: " + medSeverity);
        System.out.println("Number of High Severity Cases: " + highSeverity);
    }

    public void closeRequest(MaintenanceRequest request) {
        if (request.getStatus() == Status.DONE) {
            requests.remove(request);
            System.out.println("Request closed successfully.");
            closures++;
        } else {
            System.out.println("Cannot close request unless it is DONE.");
        }
    }

    public void viewRequests() {
        System.out.println(requests);
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }
}
