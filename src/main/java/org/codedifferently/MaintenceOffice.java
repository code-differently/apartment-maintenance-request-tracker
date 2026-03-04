package org.codedifferently;

import java.util.ArrayList;

public class MaintenanceOffice {

    private ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice() {
        this.requests = new ArrayList<>();
    }

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    // LEVEL 3 — Assign Tech Based on Severity
    public void assignTechnician(MaintenanceRequest request) {

        if (request.getSeverity().equalsIgnoreCase("HIGH")) {
            request.setTechnician("Senior Tech");
        } else if (request.getSeverity().equalsIgnoreCase("MEDIUM")) {
            request.setTechnician("Regular Tech");
        } else {
            request.setTechnician("Junior Tech");
        }

        request.setStatus("IN_PROGRESS");
    }

    // Update Status (only allowed values)
    public void updateStatus(MaintenanceRequest request, String newStatus) {

        if (newStatus.equals("NEW") ||
                newStatus.equals("IN_PROGRESS") ||
                newStatus.equals("DONE")) {

            request.setStatus(newStatus);
        } else {
            System.out.println("Invalid status update.");
        }
    }

    // Close request ONLY if DONE
    public void closeRequest(MaintenanceRequest request) {

        if (request.getStatus().equals("DONE")) {
            System.out.println("Request closed.");
        } else {
            System.out.println("Cannot close request unless status is DONE.");
        }
    }

    // LEVEL 4 — Daily Report
    public void printDailyReport() {

        int total = requests.size();
        int open = 0;
        int closed = 0;

        int low = 0;
        int medium = 0;
        int high = 0;

        for (MaintenanceRequest r : requests) {

            if (!r.getStatus().equals("DONE")) {
                open++;
            } else {
                closed++;
            }

            if (r.getSeverity().equalsIgnoreCase("LOW")) {
                low++;
            } else if (r.getSeverity().equalsIgnoreCase("MEDIUM")) {
                medium++;
            } else if (r.getSeverity().equalsIgnoreCase("HIGH")) {
                high++;
            }
        }

        System.out.println("===== DAILY REPORT =====");
        System.out.println("Total Requests: " + total);
        System.out.println("Open: " + open);
        System.out.println("Closed: " + closed);
        System.out.println("Low Severity: " + low);
        System.out.println("Medium Severity: " + medium);
        System.out.println("High Severity: " + high);

        if (high > 3) {
            System.out.println("⚠ OVERLOAD WARNING: Too many high priority requests!");
        }
    }
}