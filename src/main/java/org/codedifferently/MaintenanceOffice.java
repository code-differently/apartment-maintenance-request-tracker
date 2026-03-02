package org.codedifferently;

import javax.sql.StatementEvent;
import java.util.ArrayList;

public class MaintenanceOffice {
    private ArrayList<Technician> technicians;
    private ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice(ArrayList<Technician> technicians, ArrayList<MaintenanceRequest> requests) {
        this.technicians = technicians;
        this.requests = requests;
    }

    public ArrayList<Technician> getTechnicians() {
        return technicians;
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }

    public void addRequest(MaintenanceRequest request){
        requests.add(request);
    }

    public void addTechnician(Technician technician){
        technicians.add(technician);
    }

    public void assignTechnician(MaintenanceRequest request){
        //electrical high severity warning
        if (request.getIssueType().equals("ELECTRICAL")
                && request.getSeverity() >= 4) {

            System.out.println("WARNING: High severity electrical issue!");
        }

        // immediate dispatch for severity 5
        if (request.getSeverity() == 5) {
            System.out.println("DISPATCH IMMEDIATELY!");
        }

        for (Technician technician : technicians){
            if(technician.getType().equals(request.getIssueType())) {
                request.setAssignedTechnician(technician);
                updateRequestStatus(request,"IN_PROGRESS");
                return;
            }
        }
        System.out.println("No technician available for this issue.");
    }

    public void updateRequestStatus(MaintenanceRequest request, String newStatus) {
        request.setStatus(newStatus);
    }

    public void closeRequest(MaintenanceRequest request){
        System.out.println("Request closed successfully.");
    }

    public void generateDailyReport() {
        int open = countOpenRequests();
        int closed = countClosedRequests();
        int[] severityCounts = countSeverity(); // [low, medium, high]
        int low = severityCounts[0];
        int medium = severityCounts[1];
        int high = severityCounts[2];

        String mostCommonIssueType = getMostCommonIssueType();
        int highPriorityCount = high; // high severity = severity 4-5

        // Print report
        System.out.println("\n***** DAILY MAINTENANCE REPORT *****");
        System.out.println("Total Requests: " + requests.size());
        System.out.println("Open Requests: " + open);
        System.out.println("Closed Requests: " + closed);

        System.out.println("Severity Breakdown:");
        System.out.println("Low (1-2): " + low);
        System.out.println("Medium (3): " + medium);
        System.out.println("High (4-5): " + high);

        System.out.println("Most Common Issue Type: " + mostCommonIssueType);

        if (highPriorityCount > 3) {
            System.out.println("OVERLOAD WARNING: Too many high priority requests!");
        }
    }

// helper methods for the daily report method

    private int countOpenRequests() {
        int count = 0;
        for (MaintenanceRequest request : requests) {
            if (!request.getStatus().equals("DONE")) {
                count++;
            }
        }
        return count;
    }

    private int countClosedRequests() {
        int count = 0;
        for (MaintenanceRequest r : requests) {
            if (r.getStatus().equals("DONE")) {
                count++;
            }
        }
        return count;
    }

    private int[] countSeverity() {
        int low = 0, medium = 0, high = 0;
        for (MaintenanceRequest request : requests) {
            if (request.getSeverity()<= 2) {
                low++;
            } else if (request.getSeverity() == 3) {
                medium++;
            } else {
                high++;
            }
        }
        return new int[]{low, medium, high};
    }

    private String getMostCommonIssueType() {
        String mostCommonType = "";
        int highestCount = 0;
        ArrayList<String> checked = new ArrayList<>();

        for (MaintenanceRequest request : requests) {
            String type = request.getIssueType();

            // only count this issue type if we haven’t already processed it
            if (!checked.contains(type)) {
                int count = 0;
                for (MaintenanceRequest r : requests) {
                    if (r.getIssueType().equals(type)) {
                        count++;
                    }
                }
                //max pattern
                if (count > highestCount) {
                    highestCount = count;
                    mostCommonType = type;
                }
                checked.add(type);
            }
        }
        return mostCommonType;
    }
}
