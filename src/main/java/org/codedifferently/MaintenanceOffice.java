package org.codedifferently;

import java.util.ArrayList;

public class MaintenanceOffice {
    private ArrayList<MaintenanceRequest> requests;

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    public void assignTechnician(MaintenanceRequest request) {
        if (request.getSeverity() >= 4) {
            request.setAssignedTechnician("Senior Technician");
        } else {
            request.setAssignedTechnician("Junior Technician");
        }
        request.setStatus(Status.IN_PROGRESS);
    }

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    public void updateStatus(MaintenanceRequest request, Status newStatus) {
        if (newStatus == Status.NEW ||
                newStatus == Status.IN_PROGRESS ||
                newStatus == Status.DONE) {

            request.setStatus(newStatus);
        }
    }

    public void closeRequest(MaintenanceRequest request) {
        if (request.getStatus() == Status.DONE) {
            requests.remove(request);
            System.out.println("Request closed successfully.");
        } else {
            System.out.println("Cannot close request unless it is DONE.");
        }
    }

    public ArrayList<MaintenanceRequest> getRequests() {
        return requests;
    }
}
