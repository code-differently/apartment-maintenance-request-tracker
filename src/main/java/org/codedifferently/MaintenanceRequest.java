package org.codedifferently;

public class MaintenanceRequest {
    //fields of a maintenance request
    private String tenantName;
    private int apartmentNumber;
    private String issueType;
    private int severity;
    private String status;
    private Technician assignedTechnician;

    //constructor
    public MaintenanceRequest(String tenantName, int apartmentNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = "NEW";
    }

    //getters and setters to access private instance variables
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        //checks to see if the severity is valid or not
        if (severity >= 1 && severity <= 5) {
            this.severity = severity;
        } else {
            System.out.println("Invalid severity.");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Technician getAssignedTechnician() {
        return assignedTechnician;
    }

    public void setAssignedTechnician(Technician assignedTechnician) {
        this.assignedTechnician = assignedTechnician;
    }

    //displays the info of the request
    @Override
    public String toString() {
        String techName = (assignedTechnician != null) ? assignedTechnician.getName() : "None";
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Issue: " + issueType +
                " | Severity: " + severity +
                " | Status: " + status +
                " | Assigned Technician: " + techName;
    }
}
