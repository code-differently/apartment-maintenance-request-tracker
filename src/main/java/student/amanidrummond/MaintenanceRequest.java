package student.amanidrummond;

public class MaintenanceRequest {
    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int severity;
    private String status;
    private String assignedTech;

    public MaintenanceRequest() {
        this.tenantName = "";
        this.apartmentNumber = "";
        this.issueType = "";
        this.severity = 1;
        this.status = "NEW";
        this.assignedTech = "Unassigned";
    }

    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        setSeverity(severity);
        this.status = "NEW";
        this.assignedTech = "Unassigned";
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

    public String setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
        return apartmentNumber;
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

    public void  setSeverity(int severity) {
        if (severity < 1) severity = 1;
        if (severity > 5) severity = 5;
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void  setStatus(String status) {

        if (status.equals("NEW") || status.equals("IN_PROGRESS") || status.equals("DONE")) {
            this.status = status;
        }
    }

    public String getAssignedTech() {
        return assignedTech;
    }
    public void setAssignedTech(String assignedTech) {
        this.assignedTech = assignedTech;
    }
    @Override
    public String toString() {
        return "Tenant: " + tenantName + " | Apt: " + apartmentNumber + " | Issue: " + issueType
                + " | Severity: " + severity + " | Status: " + status + " | Tech: " + assignedTech;
    }


}
