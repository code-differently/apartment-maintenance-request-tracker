package org.codedifferently;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaintenanceOffice {

    private final ArrayList<MaintenanceRequest> activeRequests = new ArrayList<>();
    private final ArrayList<MaintenanceRequest> closedRequests = new ArrayList<>();

    public void addRequest(MaintenanceRequest request) {
        if (request != null) activeRequests.add(request);
    }

    public MaintenanceRequest findActiveRequest(String tenantName, String apartmentNumber) {
        if (tenantName == null || apartmentNumber == null) return null;

        for (MaintenanceRequest r : activeRequests) {
            if (r.getTenantName().equalsIgnoreCase(tenantName)
                    && r.getApartmentNumber().equalsIgnoreCase(apartmentNumber)) {
                return r;
            }
        }
        return null;
    }

    public String assignTech(MaintenanceRequest request) {
        int s = request.getSeverity();

        if (s >= 5) return "Tech A (Emergency)";
        if (s >= 4) return "Tech B (Priority)";
        if (s >= 2) return "Tech C (Standard)";
        return "Tech D (Low)";
    }

    // Special actions for case 1
    public void handleSpecialCases(MaintenanceRequest request) {
        if (request == null) return;

        int severity = request.getSeverity();
        String issue = request.getIssueType();

        if (severity == 5) {
            System.out.println("DISPATCH IMMEDIATELY (Severity 5)");
        }

        if (severity >= 4 && issue != null && issue.equalsIgnoreCase("Electrical")) {
            System.out.println("WARNING: High severity ELECTRICAL issue.");
        }
    }

    public boolean updateStatus(MaintenanceRequest request, String newStatus) {
        if (request == null || newStatus == null) return false;

        String format = newStatus.trim().toUpperCase();

        if (!format.equals("NEW") && !format.equals("IN_PROGRESS") && !format.equals("DONE")) {
            System.out.println("Invalid status. Allowed: NEW, IN_PROGRESS, DONE");
            return false;
        }

        request.setStatus(format);
        return true;
    }

    public boolean closeRequest(MaintenanceRequest request) {
        if (request == null) return false;

        if (!"DONE".equals(request.getStatus())) {
            System.out.println("Cannot close request unless status is DONE.");
            return false;
        }

        // Move from active -> closed
        boolean removed = activeRequests.remove(request);
        if (!removed) return false;

        request.setStatus("CLOSED");
        closedRequests.add(request);

        System.out.println("Request closed: " + request.getTenantName()
                + " (Apt " + request.getApartmentNumber() + ")");
        return true;
    }

    public void dailyReport() {
        int total = activeRequests.size() + closedRequests.size();
        int open = activeRequests.size();
        int closed = closedRequests.size();

        int low = 0;    // 1-2
        int medium = 0; // 3
        int high = 0;   // 4-5

        Map<String, Integer> issueCounts = new HashMap<>();

        // Count everything (active + closed)
        for (MaintenanceRequest r : activeRequests) {
            int sev = r.getSeverity();
            if (sev <= 2) low++;
            else if (sev == 3) medium++;
            else high++;

            //ternary, issue set to either "UNKNOWN" or issue type
            String issue = (r.getIssueType() == null) ? "UNKNOWN" : r.getIssueType().trim().toUpperCase();
            issueCounts.put(issue, issueCounts.getOrDefault(issue, 0) + 1);
        }

        for (MaintenanceRequest r : closedRequests) {
            int sev = r.getSeverity();
            if (sev <= 2) low++;
            else if (sev == 3) medium++;
            else high++;
            //ternary, issue set to either "UNKNOWN" or issue type
            String issue = (r.getIssueType() == null) ? "UNKNOWN" : r.getIssueType().trim().toUpperCase();
            issueCounts.put(issue, issueCounts.getOrDefault(issue, 0) + 1);
        }

        String mostCommonIssue = "N/A";
        int bestCount = 0;
        for (Map.Entry<String, Integer> entry : issueCounts.entrySet()) {
            if (entry.getValue() > bestCount) {
                bestCount = entry.getValue();
                mostCommonIssue = entry.getKey();
            }
        }

        int highPriorityActive = 0;
        for (MaintenanceRequest r : activeRequests) {
            if (r.getSeverity() >= 4) highPriorityActive++;
        }

        System.out.println("\n--- DAILY REPORT ---");
        System.out.println("All time Requests): " + total);
        System.out.println("Active: " + open);
        System.out.println("Closed: " + closed);
        System.out.println("Severity frequency:");
        System.out.println("  Low (1-2): " + low);
        System.out.println("  Medium (3): " + medium);
        System.out.println("  High (4-5): " + high);
        System.out.println("Most common issue type: " + mostCommonIssue + " (" + bestCount + ")");

        if (highPriorityActive > 3) {
            System.out.println("OVERLOAD WARNING: High priority ACTIVE requests = " + highPriorityActive);
        }
    }
}