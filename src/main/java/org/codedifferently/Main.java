package org.codedifferently;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// level1:
//Create at least 3 requests
//Use a loop to print them
//Print "HIGH PRIORITY" if severity ≥ 4
//Level 2:
//Now allow the user to enter requests.
//
//Requirements:
//
//Use a loop to continue entering requests
//
//Stop when user types "done"
//
//After each request:
//
//Print confirmation
//Apply rules:
//Rules:
//
//If issueType is "Electrical" and severity ≥ 4 → print warning
//If severity is 5 → dispatch immediately
public class Main {
    public static void main(String[] args) {
        MaintenanceRequest mtr = new MaintenanceRequest(630, "Leanna", "leaking", 4,150);
        MaintenanceRequest mt = new MaintenanceRequest(63, "Levon", "fridge not working", 2,700);
        MaintenanceRequest m = new MaintenanceRequest(6, "Tianna", "stove not working", 3,650);
        ArrayList<MaintenanceRequest> outPutReport = new ArrayList<>();
        outPutReport.add(mtr);
        outPutReport.add(mt);
        outPutReport.add(m);

        for (MaintenanceRequest rem : outPutReport) {

            System.out.println(rem);
            if (rem.getSeverity() >= 4) {

                System.out.println(" HIGH PRIORITY ");


                Scanner sc = new Scanner(System.in);
                ArrayList<MaintenanceRequest> enterRequest = new ArrayList<>();

                while (true) {

                    System.out.println("Enter apartment # or type 'done' to quit:");
                    String aptInput = sc.nextLine();

                    if (aptInput.equalsIgnoreCase("done")) {
                        break;
                    }

                    int apartmentNumber = Integer.parseInt(aptInput);

                    System.out.println("Enter Tenant Name:");
                    String tenantName = sc.nextLine();

                    System.out.println("What is the issue:");
                    String issue = sc.nextLine();

                    System.out.println("Enter severity (1-5):");
                    int severity = Integer.parseInt(sc.nextLine());

                    System.out.println("Request submitted!");

                    if (issue.toLowerCase().contains("electrical") && severity >= 4) {
                        System.out.println(" WARNING: High-risk electrical issue!");
                    }

                    if (severity == 5) {
                        System.out.println(" Dispatch immediately!");
                    }

                    System.out.println("----------------------------");
                    System.out.print("Enter estimated repair cost: ");
                    double estimatedRepairCost = sc.nextDouble();
                    sc.nextLine();
                    MaintenanceRequest request =
                            new MaintenanceRequest(apartmentNumber, tenantName, issue, severity, estimatedRepairCost);

                    System.out.println("Request submitted successfully!");
                   // System.out.println(request);
                    System.out.println(request.toString());

                }

                sc.close();
            }
            MaintenanceOffice office = new MaintenanceOffice();

            MaintenanceRequest request1 =
                    new MaintenanceRequest(101, "Leanna",
                            "Electrical wiring", 5,750);

            office.addRequest(request1);

            office.assignTech(request1);

            office.updateStatus(request1, "DONE");

            office.closeRequest(request1);

            office.printAllRequests();
        }
        MaintenanceOffice office = new MaintenanceOffice();

        office.addRequest(new MaintenanceRequest(101, "Leanna", "Electrical", 5, 500));
        office.addRequest(new MaintenanceRequest(102, "Mark", "Plumbing", 2, 250));
        office.addRequest(new MaintenanceRequest(103, "Anna", "Electrical", 4, 650));
        office.addRequest(new MaintenanceRequest(104, "John", "Heating", 3, 500));

        office.generateDailyReport();
    }
}


