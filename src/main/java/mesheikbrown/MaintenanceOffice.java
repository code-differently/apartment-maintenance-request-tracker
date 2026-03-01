package mesheikbrown;

import java.util.ArrayList;

public class MaintenanceOffice {

    // Store all maintenance requests here
    private ArrayList<MaintenanceRequest> requests;

    // Constructor
    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }


    // LEVEL 3
    // Add request and assign tech automatically
    public void logRequest(MaintenanceRequest request) {
        assignTech(request);
        requests.add(request);
        System.out.println("Request logged successfully.");
    }

    // Assign tech based on severity
    public void assignTech(MaintenanceRequest request) {

        int severity = request.getSeverity();

        if (severity <= 2) {
            request.setAssignedTech("General Maintenance");
        }
        else if (severity <= 4) {
            request.setAssignedTech("Senior Technician");
        }
        else { // severity == 5
            request.setAssignedTech("Emergency On-Call");
        }
    }

    // Update status (ONLY allow valid statuses)
    public void updateStatus(MaintenanceRequest request, String newStatus) {

        newStatus = newStatus.toUpperCase();

        if (newStatus.equals("NEW") ||
                newStatus.equals("IN_PROGRESS") ||
                newStatus.equals("DONE")) {

            request.setStatus(newStatus);
            System.out.println("Status updated.");
        }
        else {
            System.out.println("Invalid status. Must be NEW, IN_PROGRESS, or DONE.");
        }
    }




    // Close request only if DONE
    public void closeRequest(MaintenanceRequest request) {

        if (request.getStatus().equals("DONE")) {
            System.out.println("Request is officially CLOSED.");
        } else {
            System.out.println("Cannot close request unless status is DONE.");
        }
    }

    // Print all requests
    public void printAllRequests() {
        for (MaintenanceRequest request : requests) {
            System.out.println(request);

            if (request.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }
        }
    }

    // LEVEL 4 – DAILY REPORT
    public void printDailyReport() {

        int total = requests.size();
        int open = 0;
        int closed = 0;

        int low = 0;
        int medium = 0;
        int high = 0;

        int highPriorityOpen = 0;

        // For most common issue
        String mostCommonIssue = "";
        int highestCount = 0;

        for (int i = 0; i < requests.size(); i++) {

            MaintenanceRequest current = requests.get(i);

            // Open vs Closed
            if (current.getStatus().equals("DONE")) {
                closed++;
            } else {
                open++;
            }

            // Severity categories
            int sev = current.getSeverity();

            if (sev <= 2) {
                low++;
            }
            else if (sev == 3) {
                medium++;
            }
            else {
                high++;
            }

            if (sev >= 4 && !current.getStatus().equals("DONE")) {
                highPriorityOpen++;
            }

            // Count how many times this issue appears
            int count = 0;

            for (int j = 0; j < requests.size(); j++) {
                if (requests.get(j).getIssueType()
                        .equalsIgnoreCase(current.getIssueType())) {
                    count++;
                }
            }

            if (count > highestCount) {
                highestCount = count;
                mostCommonIssue = current.getIssueType();
            }
        }

        // Print Report
        System.out.println("\n===== DAILY REPORT =====");
        System.out.println("Total Requests: " + total);
        System.out.println("Open Requests: " + open);
        System.out.println("Closed Requests: " + closed);

        System.out.println("\nSeverity Breakdown:");
        System.out.println("Low (1-2): " + low);
        System.out.println("Medium (3): " + medium);
        System.out.println("High (4-5): " + high);

        System.out.println("\nMost Common Issue: " + mostCommonIssue);

        if (highPriorityOpen > 3) {
            System.out.println(" OVERLOAD WARNING: Too many high priority open requests!");
        }

        System.out.println("========================\n");
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }
}