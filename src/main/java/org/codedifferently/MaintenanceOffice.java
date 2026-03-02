package org.codedifferently;

import java.util.ArrayList;

public class MaintenanceOffice {

    private ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    public void cancelRequest(MaintenanceRequest request) {

        if (request.getStatus().equals("DONE")) {
            System.out.println("Cannot cancel a completed request.");
            return;
        }

        if (request.getStatus().equals("CANCELLED")) {
            System.out.println("Request is already cancelled.");
            return;
        }

        request.setStatus("CANCELLED");
        request.setAssignedTech("None");
        System.out.println("Request cancelled successfully.");
    }

    public void assignTechnician(MaintenanceRequest request) {

        if (request.getSeverity() >= 4) {
            request.setAssignedTech("Senior Tech Mike");
        } else if (request.getSeverity() == 3) {
            request.setAssignedTech("Tech Sarah");
        } else {
            request.setAssignedTech("Junior Tech Alex");
        }

        request.setStatus("IN_PROGRESS");
    }

    public void closeRequest(MaintenanceRequest request) {
        if (request.getStatus().equals("DONE")) {
            System.out.println("Request closed successfully.");
        } else {
            System.out.println("Cannot close request unless status is DONE.");
        }
    }

    public void generateDailyReport() {

        int total = requests.size();
        int open = 0;
        int closed = 0;
        int low = 0;
        int medium = 0;
        int high = 0;
        int cancelled = 0;

        ArrayList<String> issueTypes = new ArrayList<>();

        for (MaintenanceRequest r : requests) {

            // Status counts
            if (r.getStatus().equals("DONE")) {
                closed++;
            } else if (r.getStatus().equals("CANCELLED")) {
                cancelled++;
                closed++;
            } else {
                open++;
            }

            // Severity counts
            if (r.getSeverity() <= 2) {
                low++;
            } else if (r.getSeverity() == 3) {
                medium++;
            } else {
                high++;
            }

            // Track issue types
            issueTypes.add(r.getIssueType());
        }

        // Find most common issue type
        String mostCommon = "";
        int maxCount = 0;

        for (String type : issueTypes) {
            int count = 0;

            for (String t : issueTypes) {
                if (t.equalsIgnoreCase(type)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostCommon = type;
            }
        }

        System.out.println("\n---- DAILY REPORT ----");
        System.out.println("Total Requests: " + total);
        System.out.println("Open: " + open);
        System.out.println("Closed: " + closed);
        System.out.println("Cancelled: " + cancelled);
        System.out.println("Low Severity: " + low);
        System.out.println("Medium Severity: " + medium);
        System.out.println("High Severity: " + high);
        System.out.println("Most Common Issue Type: " + mostCommon);

        if (high > 3) {
            System.out.println("⚠ OVERLOAD WARNING: Too many high priority requests!");
        }
    }

    public void cancelRequestByTenantName(String name) {

        for (MaintenanceRequest r : requests) {
            if (r.getTenantName().equalsIgnoreCase(name)) {
                cancelRequest(r);
                return;
            }
        }

        System.out.println("Request not found.");
    }
}

