package org.codedifferently;

public class MaintenanceRequest {
    String tenantName;
    int aptNumber;
    String issueType;
    int severity;
    String status;

    public MaintenanceRequest() {
        this.status = "NEW";
    }

    public MaintenanceRequest(String tenantName, int aptNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.aptNumber = aptNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = "NEW";
    }

    //getters & setters


    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public int getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(int aptNumber) {
        this.aptNumber = aptNumber;
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
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
