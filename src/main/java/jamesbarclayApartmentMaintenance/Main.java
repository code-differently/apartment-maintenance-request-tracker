package jamesbarclayApartmentMaintenance;
import java.util.ArrayList;
import java.util.Scanner;

/*Requirements:

Use a loop to continue entering requests

Stop when user types "done"

After each request:

Print confirmation
Apply rules:
Rules:

If issueType is "Electrical" and severity ≥ 4 → print warning
If severity is 5 → dispatch immediately*/



public class Main {
    public static void main(String[] args) {
        // create the 3 required request
        MaintenanceRequest r1 = new MaintenanceRequest("James", 808, "Water", 5, "NEW");
        MaintenanceRequest r2 = new MaintenanceRequest("John", 715, "Electrical", 3, "NEW");
        MaintenanceRequest r3 = new MaintenanceRequest("Carol", 368, "Sewage", 2, "NEW");

        //since it is list for request we will store it in an Array
        MaintenanceRequest[] requests = {r1,r2,r3};

        for (MaintenanceRequest req :requests){
            System.out.println(req);
            if (req.getSeverity() >= 4){
                System.out.println("HIGH PRIORITY");
            }
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        ArrayList<MaintenanceRequest> requestList = new ArrayList<>();

        while (true) {

            System.out.print("Enter tenant name (or type done): ");
            String name = scanner.nextLine();

            // stop condition
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Apartment number: ");
            int apt = Integer.parseInt(scanner.nextLine());

            System.out.print("Issue type: ");
            String issue = scanner.nextLine();

            System.out.print("Severity (1-5): ");
            int severity = Integer.parseInt(scanner.nextLine());

            // create new request
            MaintenanceRequest newRequest =
                    new MaintenanceRequest(name, apt, issue, severity, "NEW");

            requestList.add(newRequest);

            // confirmation
            System.out.println("Request Confirmed");


            if (issue.equalsIgnoreCase("Electrical") && severity >= 4) {
                System.out.println(" High-risk electrical issue!!!");
            }

            if (severity == 5) {
                System.out.println(" Call Maintenance !!!");
            }

            System.out.println();
        }

        scanner.close();

    }
}
