package org.codedifferently;

public class MaintenanceRequest {

    private final String tenantName;
    private final int apartmentNumber;
    private final String issueType;
    private final int severity; // 1–5
    private String status; // NEW, IN_PROGRESS, DONE
    private String assignedTech;

    // Default Constructor
    public MaintenanceRequest() {
        this.tenantName = "";
        this.apartmentNumber = 0;
        this.issueType = "";
        this.severity = 1;
        this.status = "NEW";
        this.assignedTech = "Unassigned";
    }

    // Parameterized Constructor
    public MaintenanceRequest(String tenantName, int apartmentNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = "NEW";
        this.assignedTech = "Unassigned";
    }

    // Getters
    public String getTenantName() {
        return tenantName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public int getSeverity() {
        return severity;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedTech() {
        return assignedTech;
    }

    // Setters
    public void setStatus(String status) {
        if (status.equals("NEW") ||
                status.equals("IN_PROGRESS") ||
                status.equals("DONE") ||
                status.equals("CANCELLED")) {

            this.status = status;
        } else {
            System.out.println("Invalid status update.");
        }
    }

    public void setAssignedTech(String assignedTech) {
        this.assignedTech = assignedTech;
    }

    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Issue: " + issueType +
                " | Severity: " + severity +
                " | Status: " + status +
                " | Tech: " + assignedTech;
    }
}