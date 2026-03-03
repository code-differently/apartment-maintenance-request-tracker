package org.codedifferently;
//Level 3 — Assign & Update
//Create a MaintenanceOffice class.
//
//It must:
//
//Assign a tech based on severity
//Update request status
//Close completed requests
//Only allow status updates to:
//
//"NEW"
//"IN_PROGRESS"
//"DONE"
//Do not close a request unless it is "DONE".

import java.util.ArrayList;

public class MaintenanceOffice {

    private ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    // Assign tech based on severity
    public void assignTech(MaintenanceRequest request) {
        if (request.getSeverity() >= 4) {
            request.setAssignedTech("Senior Technician");
        } else {
            request.setAssignedTech("Junior Technician");
        }

        request.setStatus("IN_PROGRESS");
    }

    // Update status (only allowed values)
    public void updateStatus(MaintenanceRequest request, String newStatus) {

        if (newStatus.equals("NEW") ||
                newStatus.equals("IN_PROGRESS") ||
                newStatus.equals("DONE")) {

            request.setStatus(newStatus);

        } else {
            System.out.println("Invalid status update!");
        }
    }

    // Close request only if DONE
    public void closeRequest(MaintenanceRequest request) {

        if (request.getStatus().equals("DONE")) {
            requests.remove(request);
            System.out.println("Request closed successfully.");
        } else {
            System.out.println("Cannot close request. It is not DONE.");
        }
    }

    public void printAllRequests() {
        for (MaintenanceRequest r : requests) {
            System.out.println(r);
        }
    }
    //Level 4 — Daily Report
    //Add a report method that prints:
    //
    //Total requests
    //Open vs closed
    //Count of low / medium / high severity
    //Most common issue type
    //If high priority requests exceed 3:
    //
    //Print overload warning
    public void generateDailyReport() {

        int total = requests.size();
        int openCount = 0;
        int closedCount = 0;
        double totalCost = 0;
        int low = 0;
        int medium = 0;
        int high = 0;


        java.util.HashMap<String, Integer> issueCount = new java.util.HashMap<>();

        for (MaintenanceRequest r : requests) {
            totalCost += r.getEstimatedRepairCost();

            // Count open vs closed
            if (r.getStatus().equals("DONE")) {
                closedCount++;
            } else {
                openCount++;
            }

            // Count severity
            if (r.getSeverity() <= 2) {
                low++;
            } else if (r.getSeverity() == 3) {
                medium++;
            } else {
                high++;
            }

            // Count issue types
            String issue = r.getIssueType();

            issueCount.put(issue, issueCount.getOrDefault(issue, 0) + 1);
        }

            // existing counting logic...

        System.out.println("Total Estimated Repair Cost: $" + totalCost);
        // Find most common issue
        String mostCommonIssue = "None";
        int max = 0;

        for (String issue : issueCount.keySet()) {
            if (issueCount.get(issue) > max) {
                max = issueCount.get(issue);
                mostCommonIssue = issue;

            }
        }

        // Print Report
        System.out.println("====== DAILY REPORT ======");
        System.out.println("Total Requests: " + total);
        System.out.println("Open Requests: " + openCount);
        System.out.println("Closed Requests: " + closedCount);
        System.out.println();
        System.out.println("Low Severity: " + low);
        System.out.println("Medium Severity: " + medium);
        System.out.println("High Severity: " + high);
        System.out.println();
        System.out.println("Most Common Issue: " + mostCommonIssue);

        if (high > 3) {
            System.out.println("⚠ OVERLOAD WARNING: Too many high priority requests!");
        }

        System.out.println("==========================");
    }
}