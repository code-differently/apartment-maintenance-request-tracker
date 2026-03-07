package org.codedifferently;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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
            office.getRequests();

            while (true) {
                System.out.println("\nEnter tenant name (or type 'done'):");
                String name = sc.nextLine();
                if (name.equalsIgnoreCase("done"))
                    break;
                System.out.println("Apartment number:");
                int aptNum = sc.nextInt();
                System.out.println("Issue type:");
                String issue = sc.nextLine();
                System.out.println("Severity (1-5):");
                int severity = sc.nextInt();
                sc.nextLine();

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
            office.getRequests();
            office.dailyReport();
            sc.close();
        }
    }
