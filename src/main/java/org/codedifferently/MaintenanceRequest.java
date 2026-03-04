package org.codedifferently;

public class MaintenanceRequest {
    private String issueType;
    private int severity;
    private String status;

    // Default constructor
    public MaintenanceRequest() {
        this.status = "NEW";
    }

    // Parameterized constructor
    public MaintenanceRequest(String issueType, int severity) {
        this.issueType = issueType;
        this.severity = severity;
        this.status = "NEW";
    }

    // Getters and Setters
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

    // toString method
    @Override
    public String toString() {
        return "Issue: " + issueType + ", Severity: " + severity + ", Status: " + status;
    }
}