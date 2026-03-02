package org.codedifferently;

import java.util.ArrayList;
import java.util.Iterator;

public class MaintenanceOffice {

    private String technician;



    public MaintenanceOffice(String technician) {
        this.technician = technician;

    }

    public String updateStat(String problem){
        if (problem.equals("NEW")){

            return "IN_PROGRESS";
        }
        else if (problem.equals("IN_PROGRESS")){
            return "DONE";
        }

         return problem;

    }

    //  Work on ONE request by index (one step only)
    public void workOneRequest(ArrayList<MaintenanceRequest> requests, int index) {

        if (index < 0 || index >= requests.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        MaintenanceRequest r = requests.get(index);

        String before = r.getStatus();
        String after = updateStat(before);

        // only allowed statuses
        if (!isValidStatus(after)) {
            System.out.println("Invalid status change attempted.");
            return;
        }

        r.setStatus(after);

        System.out.println("\nUpdated Request:");
        System.out.println(r); // shows NEW/IN_PROGRESS/DONE
    }

    private boolean isValidStatus(String status) {
        return status.equals("NEW") || status.equals("IN_PROGRESS") || status.equals("DONE");
    }



    public String getTechnician() {
        return technician;
    }



    public void setTechnician(String technician) {
        this.technician = technician;
    }


}
