package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.EnumMap;

public class MaintenanceOffice {
    private static ArrayList<MaintenanceRequest> requests;
    EnumMap<Severity, Integer> severityCounts;
    EnumMap<IssueType, Integer> issueCounts;
    private static int closures = 0;

    public MaintenanceOffice() {
        requests = new ArrayList<>();

        severityCounts = new EnumMap<>(Severity.class);
        issueCounts = new EnumMap<>(IssueType.class);

        // Initialize all enum values to 0
        for (Severity s : Severity.values()) {
            severityCounts.put(s, 0);
        }

        for (IssueType type : IssueType.values()) {
            issueCounts.put(type, 0);
        }
    }

    public void assignTechnician(MaintenanceRequest request) {
        if (request.getAssignedTechnician().equals("None")) {
            if (request.getSeverity() == Severity.HIGH) {
                request.setAssignedTechnician("Senior Technician");
                System.out.println("\nSenior Technician assigned to request #" + request.getRequestId());
            } else {
                request.setAssignedTechnician("Junior Technician");
                System.out.println("\nJunior Technician to request #" + request.getRequestId());
            }
            request.setStatus(Status.IN_PROGRESS);
        } else {
            System.out.println("\nA technician has already been assigned to this request.");
        }
    }

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);

        // Update severity count
        Severity severity = request.getSeverity();
        severityCounts.put(severity, severityCounts.get(severity) + 1);

        // Update issue type count
        IssueType type = request.getIssueType();
        issueCounts.put(type, issueCounts.get(type) + 1);
    }

    public void getProgressUpdate() {
        System.out.println("\nReceiving progress report. Type \"View\" to see updates.");
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
                sc.nextLine();
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
        System.out.println("Number of Open Requests: " + requests.size());
        System.out.println("Number of Closed Requests: " + closures);

        System.out.println("\nSeverity Breakdown:");
        for (Severity s : severityCounts.keySet()) {
            System.out.println(s + " CASES: " + severityCounts.get(s));
        }

        System.out.println("\nMost Common Issue Type: " + getMostCommonIssueType());

        if (severityCounts.get(Severity.HIGH) > 3) {
            System.out.println("WARNING: SYSTEM OVERLOADED.");
        }
    }

    private IssueType getMostCommonIssueType() {
        IssueType mostCommon = null;
        int max = 0;

        for (IssueType type : issueCounts.keySet()) {
            int count = issueCounts.get(type);

            if (count > max) {
                max = count;
                mostCommon = type;
            }
        }
        return mostCommon;
    }

    public void closeRequest(MaintenanceRequest request) {
        if (request.getStatus() == Status.DONE) {
            requests.remove(request);
            System.out.println("\nRequest closed successfully.");
            closures++;
        } else {
            System.out.println("\nCannot close request unless it is DONE.");
        }
    }

    public void viewRequests() {
        System.out.println("\nActive Requests");
        System.out.println(requests);
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }
}
