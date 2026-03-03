package org.codedifferently;
//Create a MaintenanceRequest class.
//
//It must contain:
//
//tenantName
//apartmentNumber
//issueType
//severity (1–5)
//status (default = "NEW")
//Requirements:
//
//Include both constructors
//Include getters and setters
//Include a toString() method
//In Main:
//
//Create at least 3 requests
//Use a loop to print them
//Print "HIGH PRIORITY" if severity ≥ 4

public class MaintenanceRequest {
   private String tenantName;
  private  int apartmentNumber;
  private String issueType;
  private int severity ; // (1-5)
   String status = "new";
    private String assignedTech;
    private double estimatedRepairCost;


    public MaintenanceRequest(int apartmentNumber, String tenantName, String issueType, int severity, double estimatedRepairCost) {
        this.apartmentNumber = apartmentNumber;
        this.tenantName = tenantName;
        this.issueType = issueType;
        this.severity = severity;
        this.estimatedRepairCost = estimatedRepairCost;
        this.status = "NEW";


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



    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setAssignedTech(String tech) {
        this.assignedTech = tech;
    }

    public MaintenanceRequest(String assignedTech) {
        this.assignedTech = assignedTech;
    }

    public int getSeverity() {
        return severity;
    }

    public double getEstimatedRepairCost() {
        return estimatedRepairCost;
    }

    @Override
    public String toString() {
        return "Apartment #: " + apartmentNumber +
                " | Tenant: " + tenantName +
                " | Issue: " + issueType +
                " | Severity: " + severity +
                " | Cost: $" + estimatedRepairCost +
                " | Status: " + status +
                " | Tech: " + assignedTech;

    }
}
