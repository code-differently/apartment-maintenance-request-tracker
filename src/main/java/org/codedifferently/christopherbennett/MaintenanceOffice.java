package org.codedifferently.christopherbennett;

import org.codedifferently.christopherbennett.data.MaintenanceRequest;
import org.codedifferently.christopherbennett.data.Technician;
import org.codedifferently.christopherbennett.enums.EActivity;
import org.codedifferently.christopherbennett.enums.EStatusUpdate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaintenanceOffice {

    public void assignTechs(List<MaintenanceRequest> requests, List<Technician> techs) {

        //Sort requests by severity
        requests.sort(Comparator.comparing(MaintenanceRequest::getSeverity).reversed());

        //Sort techs by highest level of seniority.
        techs.sort(Comparator.comparing(Technician::getProfessionLevel).reversed());

        int techCounter = 0;
        int requestCounter = 0;
        while(techCounter < techs.size() && requestCounter < requests.size()) {

            //ignore already done requests
            if(requests.get(techCounter).getStatus() == EStatusUpdate.DONE) {
                requestCounter++;
                continue;
            }

            //print statement
            System.out.println("[" + requests.get(requestCounter).getApartmentNumber()
                    + "] Severity "
                    + requests.get(requestCounter).getSeverity()
                    + " -> Assigned to " + techs.get(techCounter).getName());

            //update statuses
            requests.get(requestCounter).setStatus(EStatusUpdate.INPROGRESS);
            techs.get(techCounter).setActivity(EActivity.Working);

            techs.get(techCounter).setRequest(requests.get(requestCounter));

            //Increment request and tech counters;
            requestCounter++;
            techCounter++;
        }
        System.out.println();
    }

    public void techCompleteTasks(List<Technician> techs) {
        for(int i = 0; i < techs.size(); i++) {
            techs.get(i).setActivity(EActivity.Idle);

            if(techs.get(i).getRequest() != null) {
                techs.get(i).getRequest().setStatus(EStatusUpdate.DONE);
            }

        }
    }
}
