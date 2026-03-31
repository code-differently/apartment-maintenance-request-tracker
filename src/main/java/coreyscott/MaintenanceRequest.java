package coreyscott;

public class MaintenanceRequest {

    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int issueSeverity;
    private String status;
    private EstimatedCost estimatedCost;

    public MaintenanceRequest() {
        this.tenantName = "";
        this.apartmentNumber = "";
        this.issueType = "";
        this.issueSeverity = 1;
        this.status = "NEW";
        this.estimatedCost = new EstimatedCost(1);
    }

    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int issueSeverity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        setIssueSeverity(issueSeverity);
        this.status = "NEW";
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public int getIssueSeverity() {
        return issueSeverity;
    }

    public String getEstimatedCostBreakdown() {
        return estimatedCost.getBreakdown();
    }

    public double getEstimatedTotalCost() {
        return estimatedCost.getTotal();
    }

    public String getStatus() {
        return status;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setIssueSeverity(int issueSeverity) {
        if (issueSeverity >= 1 && issueSeverity <= 5) {
            this.issueSeverity = issueSeverity;
            this.estimatedCost = new EstimatedCost(issueSeverity);
        } else {
            System.out.println("Invalid severity. Defaulting to 1.");
            this.issueSeverity = 1;
            this.estimatedCost = new EstimatedCost(1);
        }
    }

    public void setStatus(String status) {
        if (status.equals("NEW") || status.equals("IN_PROGRESS") || status.equals("DONE")) {
            this.status = status;
        } else {
            System.out.println("INVALID STATUS UPDATE");
        }
    }

    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Issue: " + issueType +
                " | Severity: " + issueSeverity +
                " | Status: " + status +
                " | Estimated Total: $" + getEstimatedTotalCost();
    }
}