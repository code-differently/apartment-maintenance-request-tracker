package org.codedifferently;

public class MaintenanceRequest {
    private String tenantName;
    private int apartmentNumber;
    private String issueType;
    private int severity;
    private String status;
    private Technician assignedTechnician;

    public MaintenanceRequest(String tenantName, int apartmentNumber, String issueType, int severity, String status) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = status;
    }

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

    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Issue: " + issueType +
                " | Severity: " + severity +
                " | Status: " + status +
                " | Assigned Technician: " + assignedTechnician;
    }
}
