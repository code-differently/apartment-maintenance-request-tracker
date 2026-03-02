package org.codedifferently;

import java.util.ArrayList;

public class MaintenanceRequest {

    private String tenantName;

    private int apartmentNumber;

    private String issueType;

    private int severity;

    private String status = "NEW";

    private final ArrayList<MaintenanceRequest> maintenanceRequests = new ArrayList<>();


    public MaintenanceRequest(){

    }

    public MaintenanceRequest(String tenantName, int apartmentNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;

    }

    public void maintenanceReq(MaintenanceRequest mR){
        maintenanceRequests.add(mR);
    }


    public void requestList() {

        // Sort requests by severity

        maintenanceRequests.sort((r1, r2) ->
                Integer.compare(r2.getSeverity(), r1.getSeverity())
        );

        System.out.println("\n--- MAINTENANCE REQUESTS ---");

        for (int i = 0; i < maintenanceRequests.size(); i++) {
            System.out.println(i + ") " + maintenanceRequests.get(i));
        }
    }

    public void dailyReport() {

        int total = maintenanceRequests.size();

        int open = 0;
        int closed = 0;

        int low = 0;     // severity 1-2
        int medium = 0;  // severity 3
        int high = 0;    // severity 4-5 , "HIGH PRIORITY"
        int highPriority = 0;

        // Track most common issue type
        String mostCommonIssue = "N/A";
        int mostCommonCount = 0;

        // Simple frequency tracking with two ArrayLists
        ArrayList<String> issueNames = new ArrayList<>();
        ArrayList<Integer> issueCounts = new ArrayList<>();

        for (MaintenanceRequest r : maintenanceRequests) {

            // Open vs Closed
            // DONE = closed
            if (r.getStatus().equals("DONE")) {
                closed++;
            } else {
                open++;
            }

            // Severity buckets
            if (r.getSeverity() <= 2) {
                low++;
            } else if (r.getSeverity() == 3) {
                medium++;
            } else {
                high++;
                highPriority++; // severity 4-5
            }

            // Count issue types
            String issue = r.getIssueType();

            int foundIndex = -1;
            for (int i = 0; i < issueNames.size(); i++) {
                if (issueNames.get(i).equalsIgnoreCase(issue)) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex == -1) {
                issueNames.add(issue);
                issueCounts.add(1);
            } else {
                issueCounts.set(foundIndex, issueCounts.get(foundIndex) + 1);
            }
        }

        // Find most common issue type
        for (int i = 0; i < issueNames.size(); i++) {
            if (issueCounts.get(i) > mostCommonCount) {
                mostCommonCount = issueCounts.get(i);
                mostCommonIssue = issueNames.get(i);
            }
        }

        // Print report
        System.out.println("\n--- DAILY MAINTENANCE REPORT ---");
        System.out.println("Total Requests: " + total);
        System.out.println("Open Requests: " + open);
        System.out.println("Closed Requests: " + closed);

        System.out.println("\nLow Severity (1-2): " + low);
        System.out.println("Medium Severity (3): " + medium);
        System.out.println("High Severity (4-5): " + high);

        System.out.println("\nMost Common Issue: " + mostCommonIssue);

        // Overload warning
        if (highPriority > 3) {
            System.out.println("\nWARNING: Maintenance team overloaded with high priority requests!");
        }
    }

    public String getTenantName() {
        return tenantName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public int getSeverity() {
        return severity;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<MaintenanceRequest> getMaintenanceRequests() {
        return maintenanceRequests;
    }

    public String toString() {

        String priority = "";

        if (severity >= 4) {
            priority = " HIGH_PRIORITY";
        }

        return "Tenant: " + tenantName
                + " | Apt: " + apartmentNumber
                + " | Issue: " + issueType
                + " | Severity: " + severity
                + " | Status: " + status
                + priority;
    }
}
