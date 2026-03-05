package jamesbarclayApartmentMaintenance;
import java.util.ArrayList;
/*Create a MaintenanceOffice class.

It must:

Assign a tech based on severity
Update request status
Close completed requests
Only allow status updates to:

        "NEW"
        "IN_PROGRESS"
        "DONE"
Do not close a request unless it is "DONE".*/

public class MaintenanceOffice {

    private ArrayList<MaintenanceRequest> requests = new ArrayList<>();

    // --- Add request ---
    public void addRequest(MaintenanceRequest r) {
        requests.add(r);
    }

    // --- Display all requests ---
    public void displayAllRequests() {
        if (requests.isEmpty()) { System.out.println("No maintenance requests."); return; }
        int idx = 1;
        for (MaintenanceRequest r : requests) {
            System.out.println(idx++ + ". " + r);
            if (r.getSeverity() >= 4) System.out.println("HIGH PRIORITY\n");
        }
    }

    // --- Assign technician based on issue type ---
    public void assignTechnician(int num) {
        if (!validIndex(num)) return;
        MaintenanceRequest r = requests.get(num - 1);
        String tech;

        switch (r.getIssueType().toLowerCase()) {
            case "water":
            case "electrical": tech = "Jordan"; break;
            case "sewage": tech = "Coreye"; break;
            default: tech = "Standard Technician";
        }

        System.out.println("Technician assigned: " + tech);
        updateStatus(num, "IN_PROGRESS");
    }

    // --- Update request status ---
    public void updateStatus(int num, String status) {
        if (!validIndex(num) || (!status.equals("NEW") && !status.equals("IN_PROGRESS") && !status.equals("DONE"))) {
            System.out.println("Invalid status."); return;
        }
        requests.get(num - 1).setStatus(status);
        System.out.println("Status updated to " + status);
    }

    // --- Close request only if DONE ---
    public void closeRequest(int num) {
        if (!validIndex(num)) return;
        MaintenanceRequest r = requests.get(num - 1);
        if (!r.getStatus().equals("DONE")) System.out.println("Cannot close unless status is DONE.");
        else System.out.println("Request officially closed.");
    }

    // --- Daily report ---
    public void report() {
        if (requests.isEmpty()) { System.out.println("No data for report."); return; }

        int total = requests.size(), open = 0, closed = 0, low = 0, med = 0, high = 0;
        String commonIssue = ""; int maxCount = 0;

        for (MaintenanceRequest r : requests) {
            // Open vs Closed
            if (r.getStatus().equals("DONE")) closed++; else open++;

            // Severity
            int s = r.getSeverity();
            if (s <= 2) low++;
            else if (s == 3) med++;
            else high++;

            // Most common issue
            int count = 0;
            for (MaintenanceRequest r2 : requests)
                if (r2.getIssueType().equalsIgnoreCase(r.getIssueType())) count++;
            if (count > maxCount) { maxCount = count; commonIssue = r.getIssueType(); }
        }

        System.out.println("\n===== DAILY MAINTENANCE REPORT =====");
        System.out.println("Total Requests: " + total + " | Open: " + open + " | Closed: " + closed);
        System.out.println("Severity - Low: " + low + " | Medium: " + med + " | High: " + high);
        System.out.println("Most Common Issue: " + commonIssue);
        if (high > 3) System.out.println("⚠ OVERLOAD WARNING: Too many high priority requests!");
        System.out.println("====================================\n");
    }

    // --- Helper methods ---
    private boolean validIndex(int num) {
        if (num < 1 || num > requests.size()) { System.out.println("Invalid request number."); return false; }
        return true;
    }

    public int getRequestCount() { return requests.size(); }
}