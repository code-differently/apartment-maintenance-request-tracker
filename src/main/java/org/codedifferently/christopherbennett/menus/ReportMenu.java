package org.codedifferently.christopherbennett.menus;

import org.codedifferently.christopherbennett.data.MaintenanceRequest;
import org.codedifferently.christopherbennett.enums.EIssueType;
import org.codedifferently.christopherbennett.enums.EStatusUpdate;
import org.codedifferently.christopherbennett.helpers.InputHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ReportMenu {
    public void promptReportMenu(List<MaintenanceRequest> requests) {
        System.out.println("===== DAILY REPORT =====\n");

        System.out.println("Total Requests: " + requests.size());
        int openCounter = 0;
        int closedCounter = 0;
        int lowSeverityCount = 0;
        int highSeverityCount = 0;

        HashMap<EIssueType, Integer> commonCountMap = new HashMap<EIssueType, Integer>();

        for(int i = 0; i < requests.size(); i++) {
            MaintenanceRequest request = requests.get(i);

            if(request.getStatus() == EStatusUpdate.DONE) {
                closedCounter++;
            }
            else {
                openCounter++;
            }

            if(request.getSeverity() >= 4) {
                highSeverityCount++;
            }
            else {
                lowSeverityCount++;
            }

            //update hashMap
            if(commonCountMap.containsKey(request.getIssueType())) {
                commonCountMap.put(request.getIssueType(), commonCountMap.get(request.getIssueType()) + 1);
            }
            else {
                commonCountMap.put(request.getIssueType(), 1);
            }
        }

        int maxIssueCount = 0;
        EIssueType mostCommonIssue = EIssueType.Other;

        //max pattern for EIssueType
        for(EIssueType eIssueType : commonCountMap.keySet()) {

            if(commonCountMap.get(eIssueType) > maxIssueCount) {
                maxIssueCount = commonCountMap.get(eIssueType);
                mostCommonIssue = eIssueType;
            }

        }

        System.out.println("Requests open: " + openCounter);
        System.out.println("Requests closed: " + closedCounter);
        System.out.println("Low Severity Requests (1-3): " + lowSeverityCount);
        System.out.println("High Severity Requests (4-5): " + highSeverityCount);

        if(highSeverityCount > 3)
        {
            System.out.println("OVERLOAD DETECTED!! MANY HIGH SEVERITY REQUESTS WERE FOUND TODAY!");
        }
        System.out.println("Most Common Issue: " + mostCommonIssue);
        System.out.println();

        System.out.println("Type anything to continue:");
        InputHandler.handleStringInput();
    }
}
