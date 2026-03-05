package org.codedifferently;

public class MaintenanceRequest {
    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int severity;
    private String status; // NEW, IN_PROGRESS, DONE, CLOSED

    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = "NEW";
    }

    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int severity, String status) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = (status == null || status.trim().isEmpty()) ? "NEW" : status.trim().toUpperCase();
    }

    public String getTenantName() { return tenantName; }
    public String getApartmentNumber() { return apartmentNumber; }
    public String getIssueType() { return issueType; }
    public int getSeverity() { return severity; }
    public String getStatus() { return status; }

    public void setTenantName(String tenantName) { this.tenantName = tenantName; }
    public void setApartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; }
    public void setIssueType(String issueType) { this.issueType = issueType; }
    public void setSeverity(int severity) { this.severity = severity; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return tenantName + " | Apt " + apartmentNumber + " | " + issueType +
                " | Sev " + severity + " | " + status;
    }
}