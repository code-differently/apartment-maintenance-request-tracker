package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class MaintenanceOffice {
    private static ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    public void assignTechnician(MaintenanceRequest request) {
        if (request.getSeverity() >= 4) {
            request.setAssignedTechnician("Senior Technician");
        } else {
            request.setAssignedTechnician("Junior Technician");
        }
        request.setStatus(Status.IN_PROGRESS);
    }

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
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

    public void closeRequest(MaintenanceRequest request) {
        if (request.getStatus() == Status.DONE) {
            requests.remove(request);
            System.out.println("Request closed successfully.");
        } else {
            System.out.println("Cannot close request unless it is DONE.");
        }
    }

    public void passTime() {

    }

    public void viewRequests() {
        System.out.println(requests);
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }
}
