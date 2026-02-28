package org.codedifferently.christopherbennett;

import org.codedifferently.christopherbennett.data.MaintenanceRequest;
import org.codedifferently.christopherbennett.data.Technician;

import java.util.ArrayList;

public class MaintenanceOffice {

    private ArrayList<MaintenanceRequest> requests = new ArrayList<>();
    private ArrayList<Technician> technicians = new ArrayList<>();

    public MaintenanceOffice(ArrayList<MaintenanceRequest> requests, ArrayList<Technician> technicians) {
        this.requests = requests;
        this.technicians = technicians;
    }

    public void assignTechs() {


    }
}
