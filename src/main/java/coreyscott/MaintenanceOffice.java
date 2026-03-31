package coreyscott;

import java.util.List;

public class MaintenanceOffice {

    private static final String IN_PROGRESS = "IN_PROGRESS";
    private static final String DONE = "DONE";
    private static final String NEW = "NEW";

    public void assignTech(MaintenanceRequest request) {
        if (request.getIssueSeverity() >= 4) {
            System.out.println("Senior tech has been assigned.");
        } else {
            System.out.println("Standard tech has been assigned.");
        }
    }

    public void updateStatus(MaintenanceRequest request, String newStatus) {
        if (newStatus.equals(NEW) || newStatus.equals(IN_PROGRESS) || newStatus.equals(DONE)) {
            request.setStatus(newStatus);
            System.out.println("Status updated to: " + newStatus);
        } else {
            System.out.println("Invalid status. Only NEW, IN_PROGRESS, or DONE allowed.");
        }
    }

    public void closeRequest(MaintenanceRequest request) {
        if (request.getStatus().equals(DONE)) {
            System.out.println("Request closed successfully.");
        } else {
            System.out.println("Request cannot be closed unless status is DONE.");
        }
    }

    public void printDailyReport(List<MaintenanceRequest> requests) {
        int open = 0, closed = 0;
        int low = 0, medium = 0, high = 0;

        String mostCommonIssue = "";
        int maxCount = 0;

        for (MaintenanceRequest request : requests) {

            if (request.getStatus().equals(DONE)) {
                closed++;
            } else {
                open++;
            }

            int severity = request.getIssueSeverity();
            if (severity <= 2) {
                low++;
            } else if (severity == 3) {
                medium++;
            } else {
                high++;
            }

            int count = 0;
            String currentIssue = request.getIssueType();

            for (MaintenanceRequest r : requests) {
                if (r.getIssueType().equalsIgnoreCase(currentIssue)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostCommonIssue = currentIssue;
            }
        }

        System.out.println("\n===== DAILY REPORT =====");
        System.out.println("Total requests: " + requests.size());
        System.out.println("Open: " + open + " | Closed: " + closed);
        System.out.println("Low: " + low + " | Medium: " + medium + " | High: " + high);
        System.out.println("Most common issue: " + mostCommonIssue);

        if (high > 3) {
            System.out.println("WARNING: Too many high priority requests!");
        }
    }
}