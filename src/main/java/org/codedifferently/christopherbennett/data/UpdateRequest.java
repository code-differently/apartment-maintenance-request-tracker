package org.codedifferently.christopherbennett.data;

import java.util.List;

public class UpdateRequest {
    List<Technician> technicianList;
    List<MaintenanceRequest> maintenanceRequestList;

    public List<MaintenanceRequest> getMaintenanceRequestList() {
        return maintenanceRequestList;
    }

    public List<Technician> getTechnicianList() {
        return technicianList;
    }

    public void setTechnicianList(List<Technician> technicianList) {
        this.technicianList = technicianList;
    }

    public void setMaintenanceRequestList(List<MaintenanceRequest> maintenanceRequestList) {
        this.maintenanceRequestList = maintenanceRequestList;
    }
}
