package org.codedifferently;

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
        
    }

    public void updateRequestStatus(MaintenanceRequest request){

    }

    public void closeRequest(MaintenanceRequest request){

    }

    public void generateDailyReport(){

    }
}
