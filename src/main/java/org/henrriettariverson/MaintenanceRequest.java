package org.henrriettariverson;

public class MaintenanceRequest {

    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int severity;
    private String status;

    public MaintenanceRequest() {
        this.tenantName = "";
        this.apartmentNumber = "";
        this.issueType = "";
        this.severity = 1;
        this.status = "NEW";
    }

    public MaintenanceRequest(String tenantName, String apartmentNumber,
                              String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = "NEW";
    }

    // Getters
    public String getTenantName() {
        return tenantName; }
    public String getApartmentNumber() {
        return apartmentNumber; }
    public String getIssueType() {
        return issueType; }
    public int getSeverity() {
        return severity; }
    public String getStatus() {
        return status; }

    // Setters
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName; }
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber; }
    public void setIssueType(String issueType) {
        this.issueType = issueType; }

    public void setSeverity(int severity) {
        if (severity >= 1 && severity <= 5) {
            this.severity = severity;
        }
    }

    public void setStatus(String status) {
        if (status.equals("NEW") ||
                status.equals("IN_PROGRESS") ||
                status.equals("DONE")) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Issue: " + issueType +
                " | Severity: " + severity +
                " | Status: " + status;
    }
}
