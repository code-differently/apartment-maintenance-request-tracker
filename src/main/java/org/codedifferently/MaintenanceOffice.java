package org.codedifferently;

import java.util.ArrayList;

public class MaintenanceOffice {

    private ArrayList<MaintenanceRequest> requests = new ArrayList<>();

    MaintenanceRequest mr = new MaintenanceRequest();

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    //Creating a method to add to the array list
    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    public void assignTech(MaintenanceRequest request) {
        if (request.getSeverity() >= 4) {
            request.setStatus("IN PROGRESS");
            System.out.println("Senior tech assigned.");
        } else {
            request.setStatus("IN PROGRESS");
            System.out.println("Standard tech assigned.");
        }
    }

    public void closeRequest(MaintenanceRequest request) {
        if (request.getStatus().equals("DONE")) {
            System.out.println("Request successfully closed.");
        } else {
            System.out.println("Cannot close request unless status is DONE.");
        }
    }

    public void dailyReport() {
        int open = 0;
        int closed = 0;
        int low = 0;
        int medium = 0;
        int high = 0;

        ArrayList<String> issueTypes = new ArrayList<>();
        ArrayList<Integer> issueCounts = new ArrayList<>();

        for (MaintenanceRequest request : requests) {
            if (request.getStatus().equals("DONE")){
                closed++;}
            else
                open++;
            if (request.getSeverity() <= 2){
                low++;}
            else if (request.getSeverity() == 3){
                medium++;}
            else
                high++;

            String currentIssue = request.getIssueType();

            if (issueTypes.contains(currentIssue)) {
                int index = issueTypes.indexOf(currentIssue);
                issueCounts.set(index, issueCounts.get(index) + 1);
            } else {
                issueTypes.add(currentIssue);
                issueCounts.add(1);
            }
        }

        String mostCommon = "";
        int max = 0;

        for (int i = 0; i < issueCounts.size(); i++) {
            if (issueCounts.get(i) > max) {
                max = issueCounts.get(i);
                mostCommon = issueTypes.get(i);
            }
        }

        System.out.println("==== DAILY REPORT ====");
        System.out.println("Total Requests: " + requests.size());
        System.out.println("Open: " + open);
        System.out.println("Closed: " + closed);
        System.out.println("Low Severity: " + low);
        System.out.println("Medium Severity: " + medium);
        System.out.println("High Severity: " + high);
        System.out.println("Most Common Issue: " + mostCommon);

        if (high > 3) {
            System.out.println("OVERLOAD WARNING: Too many high priority requests!");
        }
    }

    public void getRequests() {
        for (MaintenanceRequest r : requests) {
            System.out.println("Tenant Name: "+r.getTenantName()+"\nApt # "+ r.getAptNumber()+"\nIssue Type: "+r.getIssueType()+"\nSeverity level: "+r.getSeverity());
            System.out.println("===============================");
        }
    }
}

