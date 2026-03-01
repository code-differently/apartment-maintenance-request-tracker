package jamesbarclayApartmentMaintenance;
import java.util.ArrayList;
/*Create a MaintenanceOffice class.

It must:

Assign a tech based on severity
Update request status
Close completed requests
Only allow status updates to:

        "NEW"
        "IN_PROGRESS"
        "DONE"
Do not close a request unless it is "DONE".*/

public class MaintenanceOffice {
    //Created Arraylist specifically for request
    private ArrayList<MaintenanceRequest>requests;

    //builds the ArrayList
    //assigns it to the requests
   // makes the list ready to be able store requests

    public MaintenanceOffice() {
        requests = new ArrayList<>();
    }

    //Create method to add request
    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    public void displayAllRequests() {
        if (requests.isEmpty()) {
            System.out.println("No maintenance requests found.");
            return;
        }

        int index = 1;
        for (MaintenanceRequest req : requests) {
            System.out.println(index + ". " + req);

            if (req.getSeverity() >= 4) {
                System.out.println("HIGH PRIORITY");
            }

            System.out.println();
            index++;
        }
    }


    public void assignTechnician(int requestNumber) {

        if (!isValidIndex(requestNumber)) return;

        MaintenanceRequest req = requests.get(requestNumber - 1);

        // auto-assign based on severity
        if (req.getSeverity() >= 4) {
            System.out.println("Senior technician assigned.");
        } else {
            System.out.println("Standard technician assigned.");
        }

        updateStatus(requestNumber, "IN_PROGRESS");
    }



    public void updateStatus(int requestNumber, String newStatus) {

        if (!isValidIndex(requestNumber)) return;

        if (!newStatus.equals("NEW") &&
                !newStatus.equals("IN_PROGRESS") &&
                !newStatus.equals("DONE")) {

            System.out.println("Invalid status value.");
            return;
        }

        MaintenanceRequest req = requests.get(requestNumber - 1);
        req.setStatus(newStatus);

        System.out.println("Status updated to " + newStatus);
    }

    // CLOSE ONLY IF DONE
    public void closeRequest(int requestNumber) {

        if (!isValidIndex(requestNumber)) return;

        MaintenanceRequest req = requests.get(requestNumber - 1);

        if (!req.getStatus().equals("DONE")) {
            System.out.println("Cannot close request unless status is DONE.");
            return;
        }

        System.out.println("Request officially closed.");
    }

    // helper validation
    private boolean isValidIndex(int requestNumber) {
        if (requestNumber < 1 || requestNumber > requests.size()) {
            System.out.println("Invalid request number.");
            return false;
        }
        return true;
    }
}

