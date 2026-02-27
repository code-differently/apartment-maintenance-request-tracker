package student.amanidrummond;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class MaintenanceOffice {
    private ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    public void logRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    public void assignTech(MaintenanceRequest request) {
        int sev = request.getSeverity();

        if (sev >= 5) {
            request.setAssignedTech("Emergency Tech");
        } else if (sev >= 4) {
            request.setAssignedTech("Senior Tech");
        } else if (sev >= 2) {
            request.setAssignedTech("General Tech");
        } else {
            request.setAssignedTech("Junior Tech");
        }

    }

    public void updateRequestStatus(MaintenanceRequest request, String newStatus) {
        request.setStatus(newStatus);
    }

    public boolean closeRequest(MaintenanceRequest request) {
        if (request.getStatus().equals("DONE")) {

            return requests.remove(request);
        }
        return false;
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }

    public void printDailyReport() {
        int total = requests.size();
        int open = 0;
        int closed = 0;
        int low = 0, medium = 0, high = 0;

        HashMap<String, Integer> issueCounts = new HashMap<>();
        int highPriorityCount = 0;

        for (MaintenanceRequest r : requests) {

            if (r.getStatus().equals("DONE")) {
                closed++;
            } else {
                open++;
            }

            int sev = r.getSeverity();
            if (sev <= 2) low++;
            else if (sev == 3) medium++;
            else high++;

            if (sev >= 4) highPriorityCount++;

            String key = r.getIssueType().toLowerCase().trim();
            issueCounts.put(key, issueCounts.getOrDefault(key, 0) + 1);
        }

        String mostCommon = "N/A";
        int bestCount = 0;
        for (String k : issueCounts.keySet()) {
            int count = issueCounts.get(k);
            if (count > bestCount) {
                bestCount = count;
                mostCommon = k;
            }
        }

        System.out.println("\n=== DAILY REPORT ===");
        System.out.println("Total requests: " + total);
        System.out.println("Open vs Closed: " + open + "open, " + closed + " closed");
        System.out.println("Severity counts: low=" + low + ", medium=" + medium + ", high" + high);
        System.out.println("Most common issue type: " + mostCommon);

        if (highPriorityCount > 3) {
            System.out.println("WARNING: Overload! High priority requests exceed 3");
        }

        System.out.println("===============\n");
    }
}
