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

        Scanner sc = new Scanner(System.in);
        MaintenanceOffice office = new MaintenanceOffice();

        // --- Initial Requests ---
       // office.addRequest(new MaintenanceRequest("James", 808, "Water", 5, "NEW"));
        office.addRequest(new MaintenanceRequest("John", 715, "Electrical", 3, "NEW"));
        office.addRequest(new MaintenanceRequest("Carol", 368, "Sewage", 2, "NEW"));

        System.out.println("\n--- INITIAL REQUESTS ---");
        office.displayAllRequests();

        for (int i = 1; i <= office.getRequestCount(); i++) {
            office.assignTechnician(i);
        }

        // --- Menu Loop ---
        boolean running = true;
        while (running) {
            System.out.println("\n--- APARTMENT MAINTENANCE MENU ---");
            System.out.println("1. Add new request");
            System.out.println("2. View all requests");
            System.out.println("3. Assign technician");
            System.out.println("4. Update request status");
            System.out.println("5. Close request");
            System.out.println("6. Daily report");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 1-7.");
                continue;
            }

            switch (choice) {
                case 1: // Add request
                    System.out.print("Tenant name: ");
                    String name = sc.nextLine();
                    System.out.print("Apartment #: ");
                    int apt = Integer.parseInt(sc.nextLine());
                    System.out.print("Issue type: ");
                    String issue = sc.nextLine();
                    System.out.print("Severity (1-5): ");
                    int sev = Integer.parseInt(sc.nextLine());
                    if (sev < 1 || sev > 5) { System.out.println("Invalid severity."); break; }

                    MaintenanceRequest r = new MaintenanceRequest(name, apt, issue, sev, "NEW");
                    office.addRequest(r);
                    System.out.println("Request Confirmed: " + r);

                    office.assignTechnician(office.getRequestCount());

                    if (issue.equalsIgnoreCase("Electrical") && sev >= 4)
                        System.out.println("⚠ High-risk electrical issue!");
                    if (sev == 5) {
                        System.out.println(" Dispatch maintenance immediately!");
                        r.setStatus("DISPATCHED");
                    }
                    if (sev >= 4) System.out.println("HIGH PRIORITY\n");
                    break;

                case 2: office.displayAllRequests(); break;
                case 3:
                    System.out.print("Enter request number to assign technician: ");
                    office.assignTechnician(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Enter request number to update status: ");
                    int updateNum = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new status (NEW, IN_PROGRESS, DONE): ");
                    office.updateStatus(updateNum, sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter request number to close: ");
                    office.closeRequest(Integer.parseInt(sc.nextLine()));
                    break;
                case 6: office.report(); break;
                case 7: running = false; System.out.println("Exiting. Goodbye!"); break;
                default: System.out.println("Invalid option. Choose 1-7.");
            }
        }

        sc.close();
    }
}
