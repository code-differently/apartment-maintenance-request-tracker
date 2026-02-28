package masonbrown;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MaintenanceRequest maintenanceRequest1 = new MaintenanceRequest("larry",
                "bird", 301, "ELECTRICAL", 4, "NEW");
        MaintenanceRequest maintenanceRequest2 = new MaintenanceRequest("joanne",
                "lork", 191, "HVAC", 4, "NEW");
        MaintenanceRequest maintenanceRequest3 = new MaintenanceRequest("horace",
                "grant", 601, "PLUMBING", 5, "NEW");

        ArrayList<MaintenanceRequest> requests = new ArrayList<>();
        requests.add(maintenanceRequest1);
        requests.add(maintenanceRequest2);
        requests.add(maintenanceRequest3);
        ArrayList<String> techs = new ArrayList<>();
        techs.add("Alice");
        techs.add("Bob");
        techs.add("Charlie");


        MaintenanceOffice office = new MaintenanceOffice(requests, techs);
        office.assigntech();
        for (MaintenanceRequest i : requests) {
            if (i.getSeverity() > 3) {
                i.severitycheck();
                System.out.println(i);
            } else {
                System.out.println(i);
            }
        }

        boolean done = false;
        Scanner scanner = new Scanner(System.in);

        while (!done) {

            System.out.println("Welcome to the Maintenance Request System");

            System.out.println("Enter your first name (or type done to quit)");
            String firstna = scanner.nextLine();

            if (firstna.equalsIgnoreCase("done")) {
                done = true;
                break;
            }

            System.out.println("Enter your last name");
            String lastna = scanner.nextLine();

            System.out.println("Enter your Apartment number");
            int apartnum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter your issuetype: " + "\n" + "1. Electrical" + "\n"
                    + "2. Plumbing" + "\n" + "3. HVAC" + "\n" + "4. Structural" + "\n" + "\n"
                    + "***Please type the name of the issue you are dealing with, field is not case sensitive");

            String issuetypeselect = scanner.nextLine();

            System.out.println("On a scale of 1-5, what would you rate the severity?");
            int severityselect = scanner.nextInt();
            scanner.nextLine();

            MaintenanceRequest newrequest =
                    new MaintenanceRequest(firstna, lastna, apartnum, issuetypeselect, severityselect, "NEW");

            newrequest.severitycheck();

            requests.add(newrequest);
            office.assigntech();
            System.out.println("\n" + "=====Maintenance Request Successfully added=====");
            System.out.println(newrequest);
            System.out.println("\n" + "================================================");


        }



        for (MaintenanceRequest i : requests) {
            System.out.println(i);
        }

        office.report();
        }
    }
