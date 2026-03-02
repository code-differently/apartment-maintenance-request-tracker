package org.codedifferently;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceOffice {

    private List<MaintenanceRequest> requests;

    public MaintenanceOffice() {
        this.requests = new ArrayList<>();
    }

    public void addRequest(MaintenanceRequest request){
        this.requests.add(request);
    }

    public void assignTechnician(MaintenanceRequest request) {

        int severity = request.getSeverity();

        if (severity == 5) {
            request.setAssignedTech("Senior Tech");
        } else if (severity >= 3) {
            request.setAssignedTech("Standard Tech");
        } else {
            request.setAssignedTech("Junior Tech");
        }

        request.setStatus("IN_PROGRESS");
    }

    public void updateStatus(MaintenanceRequest request, String status) {
        request.setStatus(status);
    }

    public void generateDailyReport() {

        int total = requests.size();
        int open = 0;
        int closed = 0;

        for (MaintenanceRequest request : requests) {
            if (request.getStatus().equals("DONE")) {
                closed++;
            } else {
                open++;
            }
        }

        System.out.println("Total Requests: " + total);
        System.out.println("Open: " + open);
        System.out.println("Closed: " + closed);
    }
}