package org.codedifferently.maxxblue.maintenance;


public class MaintenanceRequest {

    // Stores the tenant's name
    private String tenantName;

    // Stores the apartment number
    private String apartmentNumber;

    // Stores the type of issue (Plumbing, Electrical, etc.)
    private String issueType;

    // Stores severity level from 1–5
    private int severity;

    // Stores request status (NEW, IN_PROGRESS, DONE)
    private String status;

    // Stores the assigned technician
    private String assignedTech;

    // Default constructor (no parameters)
    public MaintenanceRequest() {
        // Default status is NEW
        this.status = "NEW";

        // Default tech is UNASSIGNED
        this.assignedTech = "UNASSIGNED";
    }

    // Parameterized constructor (sets all main values)
    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int severity) {

        // Assign tenant name
        this.tenantName = tenantName;

        // Assign apartment number
        this.apartmentNumber = apartmentNumber;

        // Assign issue type
        this.issueType = issueType;

        // Call setter to validate severity
        setSeverity(severity);

        // Default status is NEW
        this.status = "NEW";

        // Default tech is UNASSIGNED
        this.assignedTech = "UNASSIGNED";
    }

    // Getter for tenantName
    public String getTenantName() {
        return tenantName;
    }

    // Setter for tenantName
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    // Getter for apartmentNumber
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    // Setter for apartmentNumber
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    // Getter for issueType
    public String getIssueType() {
        return issueType;
    }

    // Setter for issueType
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    // Getter for severity
    public int getSeverity() {
        return severity;
    }

    // Setter with validation (keeps severity between 1 and 5)
    public void setSeverity(int severity) {

        // If less than 1, force to 1
        if (severity < 1) {
            this.severity = 1;

            // If greater than 5, force to 5
        } else if (severity > 5) {
            this.severity = 5;

            // Otherwise assign normally
        } else {
            this.severity = severity;
        }
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for assignedTech
    public String getAssignedTech() {
        return assignedTech;
    }

    // Setter for assignedTech
    public void setAssignedTech(String assignedTech) {
        this.assignedTech = assignedTech;
    }

    // toString method to print request details
    @Override
    public String toString() {
        return "Request{" +
                "tenant='" + tenantName + '\'' +
                ", apt='" + apartmentNumber + '\'' +
                ", issueType='" + issueType + '\'' +
                ", severity=" + severity +
                ", status='" + status + '\'' +
                ", tech='" + assignedTech + '\'' +
                '}';
    }
}
