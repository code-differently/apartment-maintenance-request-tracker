package org.codedifferently;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MaintenanceOffice office = new MaintenanceOffice();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter tenant name (or type 'done' to exit): ");
            String tenantName = scanner.nextLine();

            if (tenantName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter apartment number: ");
            int apartmentNumber = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter issue type: ");
            String issueType = scanner.nextLine();

            System.out.println("Enter severity (1-5): ");
            int severity = Integer.parseInt(scanner.nextLine());

            MaintenanceRequest request =
                    new MaintenanceRequest(tenantName, apartmentNumber, issueType, severity);

            office.addRequest(request);

            if (issueType.equalsIgnoreCase("Electrical") && severity >= 4) {
                System.out.println("⚠ Electrical high severity — handle urgently!");
            }

            if (severity == 5) {
                office.assignTechnician(request);
                System.out.println("Dispatching immediately.");
            }

            System.out.println("Request logged successfully.");
        }

        office.generateDailyReport();
        scanner.close();
    }
}