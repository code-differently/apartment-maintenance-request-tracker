package org.codedifferently.christopherbennett.data;

import org.codedifferently.christopherbennett.enums.EIssueType;
import org.codedifferently.christopherbennett.enums.EStatusUpdate;

public class MaintenanceRequest {
    private String tenantName;
    private String apartmentNumber;
    private EIssueType issueType;
    private int severity;
    private EStatusUpdate status = EStatusUpdate.NEW;


    public MaintenanceRequest(String tenantName, String apartmentNumber, EIssueType issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public EIssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(EIssueType issueType) {
        this.issueType = issueType;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        if(severity > 5) {
            System.out.println("Max severity is 5!!");
            severity = 5;
        }
        this.severity = severity;
    }

    public EStatusUpdate getStatus() {
        return status;
    }

    public void setStatus(EStatusUpdate status) {
        this.status = status;
    }
}
