package org.codedifferently;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MaintenanceOffice office = new MaintenanceOffice();

        MaintenanceRequest request1 =
                new MaintenanceRequest("Freddy", 112, "Plumbing", 3);
        MaintenanceRequest request2 =
                new MaintenanceRequest("Paul", 306, "Electrical", 4);
        MaintenanceRequest request3 =
                new MaintenanceRequest("Elana", 971, "HVAC", 5);

        office.addRequest(request1);
        office.addRequest(request2);
        office.addRequest(request3);

        System.out.println("Initial Requests:");
        for (int i = 0; i < office.getRequests().size(); i++) {
            System.out.println(office.getRequests());
            if (office.getRequests().get(i).getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }
            for (MaintenanceRequest request : office.getRequests()) {
                System.out.println(request);
                System.out.println(office.getRequests());
            }
        }


            while (true) {
                System.out.println("\nEnter tenant name (or type 'done'):");
                String name = input.nextLine();
                if (name.equalsIgnoreCase("done"))
                    break;
                System.out.println("Apartment number:");
                int aptNum = input.nextInt();
                System.out.println("Issue type:");
                String issue = input.nextLine();
                System.out.println("Severity (1-5):");
                int severity = input.nextInt();
                input.nextLine();

                MaintenanceRequest newRequest = new MaintenanceRequest(name, aptNum, issue, severity);
                office.addRequest(newRequest);

                System.out.println("Request logged successfully!");

                if (issue.equals("Electrical") && severity >= 4) {
                    System.out.println("Electrical high severity warning!");
                }

                if (severity == 5) {
                    System.out.println("Dispatching immediately!");
                    office.assignTech(newRequest);
                }
            }

            for (MaintenanceRequest request : office.getRequests()) {
                if (request.getStatus().equals("NEW")) {
                    office.assignTech(request);
                }
            }

            office.getRequests().getFirst().setStatus("DONE");

            office.dailyReport();

            input.close();
        }
    }
