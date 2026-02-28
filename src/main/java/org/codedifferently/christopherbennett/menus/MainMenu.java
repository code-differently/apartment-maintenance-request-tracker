package org.codedifferently.christopherbennett.menus;

import org.codedifferently.christopherbennett.data.MaintenanceRequest;
import org.codedifferently.christopherbennett.data.Technician;
import org.codedifferently.christopherbennett.enums.EActivity;
import org.codedifferently.christopherbennett.enums.EProfessionLevel;
import org.codedifferently.christopherbennett.helpers.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private ArrayList<Technician> technicians;
    private  ArrayList<MaintenanceRequest> requests;

    public void promptMainMenu() {

        //Initialization
        initializeFields();
        boolean inMainMenu = true;

        //Initialize Menus
        RequestMenu requestMenu = new RequestMenu();
        TechMenu techMenu = new TechMenu();
        ReportMenu reportMenu = new ReportMenu();

        //Main Loop
        while(inMainMenu) {
            System.out.println("===== MAINTENANCE REQUEST TRACKER =====\n");
            System.out.println("1. Add New Request");
            System.out.println("2. Monitor Technicians");
            System.out.println("3. Daily Report");
            System.out.println("4. Exit");

            int inputCode = InputHandler.handleIntegerInput();

            switch(inputCode) {
                case 1:
                    //Add all new requests once finished
                    List<MaintenanceRequest> newRequests = requestMenu.promptRequestMenu();
                    requests.addAll(newRequests);
                    break;
                case 2:
                    techMenu.promptTechMenu(technicians);
                    break;
                case 3:
                    reportMenu.promptReportMenu();
                    break;
                case 4:
                    System.out.println("Have a nice day!");
                    inMainMenu = false;
                    break;
                default:
                    System.out.println("Not a valid Integer Input!");
                    break;
            }
        }
    }


    public void initializeFields() {
        Technician tech1 = new Technician("Jordan", 34, EProfessionLevel.Senior, EActivity.Idle);
        Technician tech2 = new Technician("Coreye'", 25, EProfessionLevel.MidLevel, EActivity.OnBreak);
        Technician tech3 = new Technician("Glenn", 27, EProfessionLevel.Junior, EActivity.Working);
        Technician tech4 = new Technician("Bryant", 24, EProfessionLevel.Junior, EActivity.Idle);

        technicians = new ArrayList<>();
        technicians.add(tech1);
        technicians.add(tech2);
        technicians.add(tech3);
        technicians.add(tech4);

        requests = new ArrayList<>();
    }
}
