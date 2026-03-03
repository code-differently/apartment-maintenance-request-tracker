package org.codedifferently.maxxblue.maintenance;

import java.util.ArrayList;
import java.util.HashMap;

// Import Map interface
import java.util.Map;

// Defines MaintenanceOffice class
public class MaintenanceOffice {

    // List to store all maintenance requests
    private final ArrayList<MaintenanceRequest> requests = new ArrayList<>();

    // Adds a request to the system
    public void addRequest(MaintenanceRequest request) {

        // Assign tech before storing
        assignTech(request);

        // Add request to list
        requests.add(request);
    }

    // Assign tech based on severity
    public void assignTech(MaintenanceRequest request) {

        // Get severity level
        int s = request.getSeverity();

        // If highest severity
        if (s == 5) {
            request.setAssignedTech("EMERGENCY TEAM");

            // High priority
        } else if (s >= 4) {
            request.setAssignedTech("Senior Tech");

            // Medium
        } else if (s == 3) {
            request.setAssignedTech("General Tech");

            // Low
        } else {
            request.setAssignedTech("Apprentice Tech");
        }
    }

    // Update status with validation
    public boolean updateStatus(MaintenanceRequest request, String newStatus) {

        // Prevent null input
        if (newStatus == null) return false;

        // Normalize text (remove spaces, make uppercase)
        String normalized = newStatus.trim().toUpperCase();

        // Only allow specific statuses
        if (!normalized.equals("NEW") &&
                !normalized.equals("IN_PROGRESS") &&
                !normalized.equals("DONE")) {

            System.out.println("Invalid status.");
            return false;
        }

        // Update status
        request.setStatus(normalized);
        return true;
    }

    // Only allow closing if DONE
    public boolean closeRequest(MaintenanceRequest request) {

        // If not DONE, reject closing
        if (!"DONE".equalsIgnoreCase(request.getStatus())) {
            System.out.println("Cannot close unless DONE.");
            return false;
        }

        // Otherwise, allow close
        return true;
    }

    // Return all requests
    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }

    // Print daily report
    public void printDailyReport() {

        // Count totals
        int total = requests.size();
        int open = 0;
        int closed = 0;

        int low = 0;
        int medium = 0;
        int high = 0;

        Map<String, Integer> issueCounts = new HashMap<>();
        int highPriorityOpen = 0;

        // Loop through all requests
        for (MaintenanceRequest r : requests) {

            // Count open/closed
            if ("DONE".equalsIgnoreCase(r.getStatus())) {
                closed++;
            } else {
                open++;
            }

            // Count severity categories
            if (r.getSeverity() <= 2) low++;
            else if (r.getSeverity() == 3) medium++;
            else high++;

            // Count issue types
            String issue = r.getIssueType();
            issueCounts.put(issue, issueCounts.getOrDefault(issue, 0) + 1);

            // Count open high priority
            if (r.getSeverity() >= 4 && !"DONE".equalsIgnoreCase(r.getStatus())) {
                highPriorityOpen++;
            }
        }

        // Find most common issue
        String mostCommon = "N/A";
        int max = 0;

        for (Map.Entry<String, Integer> entry : issueCounts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        // Print report
        System.out.println("\n=== DAILY REPORT ===");
        System.out.println("Total: " + total);
        System.out.println("Open: " + open);
        System.out.println("Closed: " + closed);
        System.out.println("Low: " + low + " Medium: " + medium + " High: " + high);
        System.out.println("Most Common Issue: " + mostCommon);

        // Overload warning
        if (highPriorityOpen > 3) {
            System.out.println("OVERLOAD WARNING!");
        }
    }
}