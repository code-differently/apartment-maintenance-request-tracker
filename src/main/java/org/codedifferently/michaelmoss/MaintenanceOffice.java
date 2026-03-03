package org.codedifferently.michaelmoss;

import java.util.ArrayList;

public class MaintenanceOffice {

        private ArrayList<MaintenanceRequest> requests;

        public MaintenanceOffice() {
            requests = new ArrayList<>();
        }

        public void addRequest(MaintenanceRequest request) {
            requests.add(request);
        }

        // Assign tech based on severity
        public void assignTech(MaintenanceRequest request) {
            if (request.getSeverity() >= 4) {
                System.out.println("Assigned Senior Technician to Apt " + request.getApartmentNumber());
            } else {
                System.out.println("Assigned General Technician to Apt " + request.getApartmentNumber());
            }
            request.setStatus("IN_PROGRESS");
        }

        // Close request only if DONE
        public void closeRequest(MaintenanceRequest request) {
            if (request.getStatus().equals("DONE")) {
                System.out.println("Request for Apt " + request.getApartmentNumber() + " is now CLOSED.");
            } else {
                System.out.println("Cannot close. Request is not marked DONE.");
            }
        }

        // Daily Report (Level 4)
        public void printDailyReport() {
            int total = requests.size();
            int open = 0;
            int closed = 0;
            int low = 0, medium = 0, high = 0;

            java.util.HashMap<String, Integer> issueCount = new java.util.HashMap<>();

            for (MaintenanceRequest r : requests) {

                if (r.getStatus().equals("DONE"))
                    closed++;
                else
                    open++;

                if (r.getSeverity() <= 2)
                    low++;
                else if (r.getSeverity() == 3)
                    medium++;
                else
                    high++;

                issueCount.put(r.getIssueType(),
                        issueCount.getOrDefault(r.getIssueType(), 0) + 1);
            }

            // Find most common issue
            String commonIssue = "None";
            int max = 0;
            for (String issue : issueCount.keySet()) {
                if (issueCount.get(issue) > max) {
                    max = issueCount.get(issue);
                    commonIssue = issue;
                }
            }

            System.out.println("\n--- Daily Maintenance Report ---");
            System.out.println("Total Requests: " + total);
            System.out.println("Open: " + open + " | Closed: " + closed);
            System.out.println("Low: " + low + " | Medium: " + medium + " | High: " + high);
            System.out.println("Most Common Issue: " + commonIssue);

            if (high > 3) {
                System.out.println("WARNING: High priority overload!");
            }
        }

        public ArrayList<MaintenanceRequest> getRequests() {
            return requests;
        }
    }

