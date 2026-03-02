package org.codedifferently.christopherbennett.menus;

import org.codedifferently.christopherbennett.data.MaintenanceRequest;
import org.codedifferently.christopherbennett.enums.EIssueType;
import org.codedifferently.christopherbennett.helpers.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class RequestMenu {

    public List<MaintenanceRequest> promptRequestMenu() {

        ArrayList<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest>();

        boolean inRequestMenu = true;
        while(inRequestMenu) {
            System.out.println("===== NEW REQUEST TRACKER =====\n");
            System.out.println("Enter tenant name (or 'done' to stop):");
            String inputStr = InputHandler.handleStringInput();

            if(inputStr.equals("done"))
            {
                System.out.println("Exiting out of Request Tracker.");
                inRequestMenu = false;
                break;
            }

            System.out.println("Enter apartment number:");
            String apartmentStr = InputHandler.handleStringInput();

            System.out.println("Enter issue type: (Electrical/Plumbing/HVAC/Other)");

            EIssueType[] issueOptions = {EIssueType.Electrical, EIssueType.HVAC, EIssueType.Plumbing, EIssueType.Other};
            EIssueType issueStr = InputHandler.handleEnumInput(issueOptions);

            System.out.println("Enter severity (1-5):");
            int severityCode = InputHandler.handleIntegerInput();

            System.out.println("✔ Request logged.");

            if(severityCode >= 4 && issueStr == EIssueType.Electrical) {
                System.out.println("⚠ WARNING: High-severity electrical issue. Safety risk — inspect immediately.");
            }

            if(severityCode >= 5) {
                System.out.println("\uD83D\uDEA8 SEVERITY 5 DETECTED — Dispatching technician immediately!");
            }

            MaintenanceRequest request = new MaintenanceRequest(inputStr, apartmentStr, issueStr, severityCode);

            requests.add(request);
        }

        return requests;
    }
}
