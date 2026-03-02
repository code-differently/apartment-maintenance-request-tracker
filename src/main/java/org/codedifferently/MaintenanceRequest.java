package org.codedifferently;

public class MaintenanceRequest {

    private String tenantName;
    private int apartmentNumber;
    private String issueType;
    private int severity;
    private String status;
    private String assignedTech;

    // Default
    public MaintenanceRequest() {
        this.status = "NEW";
    }

    // Parameterized
    public MaintenanceRequest(String tenantName,
                              int apartmentNumber,
                              String issueType,
                              int severity) {

        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.status = "NEW";

        setSeverity(severity); // use validation
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
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setSeverity(int severity) {
        if (severity >= 1 && severity <= 5) {
            this.severity = severity;
        } else {
            throw new IllegalArgumentException("Severity must be between 1 and 5");
        }
    }

    public void setStatus(String status) {
        if (status.equals("NEW") ||
                status.equals("IN_PROGRESS") ||
                status.equals("DONE")) {

            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status");
        }
    }

    public void setAssignedTech(String assignedTech) {
        this.assignedTech = assignedTech;
    }

    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                ", Apartment: " + apartmentNumber +
                ", Issue: " + issueType +
                ", Severity: " + severity +
                ", Status: " + status +
                ", Tech: " + assignedTech;
    }
}