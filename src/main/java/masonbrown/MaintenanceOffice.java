package masonbrown;

import java.util.ArrayList;

public class MaintenanceOffice {
    private ArrayList<MaintenanceRequest> requests = new ArrayList<>();
    ArrayList<String> techs = new ArrayList<>();

    public MaintenanceOffice(ArrayList requests, ArrayList techs){
        this.requests = requests;
        this.techs = techs;
    }
    public void report() {

        int total = requests.size();
        int open = 0;
        int closed = 0;

        int low = 0;
        int medium = 0;
        int high = 0;

        int electricalCount = 0;
        int plumbingCount = 0;
        int hvacCount = 0;
        int structuralCount = 0;

        for (MaintenanceRequest r : requests) {


            if (r.getStatus().equalsIgnoreCase("DONE")) {
                closed++;
            } else {
                open++;
            }

            // Severity counts
            if (r.getSeverity() <= 2) {
                low++;
            } else if (r.getSeverity() == 3) {
                medium++;
            } else {
                high++;
            }

            // Issue type counts
            if (r.getIssuetype().equalsIgnoreCase("Electrical")) {
                electricalCount++;
            } else if (r.getIssuetype().equalsIgnoreCase("Plumbing")) {
                plumbingCount++;
            } else if (r.getIssuetype().equalsIgnoreCase("HVAC")) {
                hvacCount++;
            } else if (r.getIssuetype().equalsIgnoreCase("Structural")) {
                structuralCount++;
            }
        }

        System.out.println("\n===== DAILY MAINTENANCE REPORT =====");
        System.out.println("Total Requests: " + total);
        System.out.println("Open Requests: " + open);
        System.out.println("Closed Requests: " + closed);

        System.out.println("\nSeverity Breakdown:");
        System.out.println("Low: " + low);
        System.out.println("Medium: " + medium);
        System.out.println("High: " + high);

        // Determine most common issue
        String mostCommon;
        int max = electricalCount;

        mostCommon = "Electrical";

        if (plumbingCount > max) {
            max = plumbingCount;
            mostCommon = "Plumbing";
        }
        if (hvacCount > max) {
            max = hvacCount;
            mostCommon = "HVAC";
        }
        if (structuralCount > max) {
            max = structuralCount;
            mostCommon = "Structural";
        }

        System.out.println("\nMost Common Issue Type: " + mostCommon);

        if (high > 3) {
            System.out.println("\n*** OVERLOAD WARNING: Too many high priority requests! ***");
        }

        System.out.println("=====================================\n");
    }

    public void assigntech(){
        for (MaintenanceRequest r : requests) {
            if (r.getSeverity() == 5) {
                r.setAssignedTech(techs.get(0));
            } else if (r.getSeverity() >= 4) {
                r.setAssignedTech(techs.get(1));
            } else {
                r.setAssignedTech(techs.get(2));
            }
        }
    }

    public void updatestatus(MaintenanceRequest request, String newstatus){
        String toUpper =  newstatus.toUpperCase();
        if(toUpper.equals("NEW") || toUpper.equals("IN_PROGRESS") || toUpper.equals("DONE")){
            request.setStatus(toUpper);
        } else {
            System.out.println("Invalid status. Only NEW, IN_PROGRESS, or DONE are allowed.");
        }
    }

    public void closeRequest(MaintenanceRequest request){
        if(request.getStatus().equals("DONE")){
            requests.remove(request);
        } else {
            System.out.println("Cannot close request unless it is DONE.");
        }
    }

    public ArrayList<String> getTechs() {
        return techs;
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<MaintenanceRequest> requests) {
        this.requests = requests;
    }

    public void setTechs(String Techs) {
        this.techs=techs;
    }
}
