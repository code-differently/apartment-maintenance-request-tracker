package maintenance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaintenanceOffice {

    private final ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice() {

        this.requests = new ArrayList<>();
    }

    public void addRequest(MaintenanceRequest request) {

        assignTech(request);

        requests.add(request);
    }

    public ArrayList<MaintenanceRequest> getRequests() {

        return requests;
    }


    public void assignTech(MaintenanceRequest request) {

        int sev = request.getSeverity();

        if (sev <= 2) {

            request.setAssignedTech("Tech A (General)");

        } else if (sev <= 4) {

            request.setAssignedTech("Tech B (Senior)");

        } else {

            request.setAssignedTech("Tech C (Emergency)");
        }
    }


    public boolean updateStatus(MaintenanceRequest request, String newStatus) {

        if (!isValidStatus(newStatus)) {

            System.out.println("Invalid status. Allowed: NEW, IN_PROGRESS, DONE");

            return false;
        }
        request.setStatus(newStatus);
        return true;
    }

    public boolean closeRequest(MaintenanceRequest request) {

        if (!"DONE".equalsIgnoreCase(request.getStatus())) {

            System.out.println("Cannot close unless status is DONE.");

            return false;
        }

        request.setStatus("CLOSED");

        return true;
    }

    private boolean isValidStatus(String status) {

        if (status == null) return false;

        String s = status.trim().toUpperCase();

        return s.equals("NEW") || s.equals("IN_PROGRESS") || s.equals("DONE");
    }


    public void printDailyReport() {

        int total = requests.size();

        int open = 0;

        int closed = 0;

        int low = 0;

        int medium = 0;

        int high = 0;

        Map<String, Integer> issueCounts = new HashMap<>();

        int highPriorityCount = 0;

        for (MaintenanceRequest r : requests) {

            String status = r.getStatus() == null ? "" : r.getStatus().toUpperCase();


            if (status.equals("CLOSED")) closed++;

            else open++;

            int sev = r.getSeverity();

            if (sev <= 2) low++;

            else if (sev == 3) medium++;

            else high++;

            if (sev >= 4) highPriorityCount++;

            String issue = r.getIssueType() == null ? "UNKNOWN" : r.getIssueType().trim();

            issueCounts.put(issue, issueCounts.getOrDefault(issue, 0) + 1);
        }

        String mostCommonIssue = "NONE";

        int maxCount = 0;

        for (String issue : issueCounts.keySet()) {

            int count = issueCounts.get(issue);

            if (count > maxCount) {

                maxCount = count;

                mostCommonIssue = issue;
            }
        }

        System.out.println("\n=== DAILY MAINTENANCE REPORT ===");

        System.out.println("Total requests: " + total);

        System.out.println("Open: " + open + " | Closed: " + closed);

        System.out.println("Severity counts -> Low(1-2): " + low + " | Medium(3): " + medium + " | High(4-5): " + high);

        System.out.println("Most common issue type: " + mostCommonIssue + " (" + maxCount + ")");

        if (highPriorityCount > 3) {

            System.out.println("⚠ OVERLOAD WARNING: High priority requests exceed 3!");
        }
        System.out.println("================================\n");
    }
}