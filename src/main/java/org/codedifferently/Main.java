package org.codedifferently;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        MaintenanceRequest main = new MaintenanceRequest();
        MaintenanceRequest mR1 = new MaintenanceRequest("Derwin", 101, "Plumbing", 2);
        MaintenanceRequest mR2 = new MaintenanceRequest("Dill", 121, "Electric", 5);
        MaintenanceRequest mR3 = new MaintenanceRequest("James", 134, "HVAC", 1);


        main.maintenanceReq(mR1);
        main.maintenanceReq(mR2);
        main.maintenanceReq(mR3);

        main.requestList();

        maintenanceApp(main);


    }

    public static void maintenanceApp(MaintenanceRequest maintenanceRequest) {
        Scanner scan = new Scanner(System.in);
        String playAgain;

        do {

            System.out.println("Welcome to Maintenance");
            System.out.println("""
                     1. Add New Customer
                     2. Add New Technician
                     3. Daily Report
                    """);
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Tenant's Name: ");
                    String TenantName = scan.next();
                    System.out.println("Enter Apt #: ");
                    int apt = scan.nextInt();
                    System.out.println("Enter Issue Type: ");
                    String issueType = scan.next();
                    System.out.println("Enter Severity #: ");
                    int severity = scan.nextInt();
                    MaintenanceRequest maintenance = new MaintenanceRequest(TenantName, apt, issueType, severity);
                    maintenanceRequest.maintenanceReq(maintenance);
                    maintenanceRequest.requestList();

                    break;
                case 2:

                        System.out.println("WE NEED TECHNICIANS, WHAT YOUR NAME? YOU'RE A TECHNICIAN NOW");
                        String TechnicianName = scan.next();
                        MaintenanceOffice technician = new MaintenanceOffice(TechnicianName);
                        techWork(technician, maintenanceRequest);


                case 3:
                    maintenanceRequest.dailyReport();
                    break;


                default:

                    System.out.println("Invalid Input.");
                    break;
            }





        while (true) {
            System.out.print("Done? (say Done/No): ");
            playAgain = scan.next().toLowerCase();

            if (playAgain.equals("no") || playAgain.equals("done")) {
                break;
            } else {
                System.out.println("Invalid input!");

            }
        }


    }while(playAgain.equals("no"));
}



    public static void techWork(MaintenanceOffice technician, MaintenanceRequest mR){

        Scanner scan = new Scanner(System.in);

        while (true) {

            // If list is empty, stop
            if (mR.getMaintenanceRequests().isEmpty()) {
                System.out.println("\nNo more requests. All caught up!");
                break;
            }

            System.out.println("\n--- CURRENT REQUESTS ---");

            //  Print starting from 1 for the user
            for (int i = 0; i < mR.getMaintenanceRequests().size(); i++) {
                System.out.println((i + 1) + ") " + mR.getMaintenanceRequests().get(i));
            }

            System.out.println("\nChoose a request number to work on (or type -1 to stop): ");
            int option = scan.nextInt();

            if (option == -1) {
                System.out.println("Stopping work session.");
                break;
            }

            //  Convert user input to 0-based index
            int index = option - 1;

            // Validate choice
            if (index < 0 || index >= mR.getMaintenanceRequests().size()) {
                System.out.println("Invalid choice.");
                continue;
            }

            // Work on it ONE time (NEW->IN_PROGRESS or IN_PROGRESS->DONE)
            technician.workOneRequest(mR.getMaintenanceRequests(), index);

            // After working, check if it is DONE, then remove it
            if (mR.getMaintenanceRequests().get(index).getStatus().equals("DONE")) {

                System.out.println("\nRequest is DONE. Removing it from the list...");
                mR.getMaintenanceRequests().remove(index);

                System.out.println("Removed.");
            }
        }
    }
}


