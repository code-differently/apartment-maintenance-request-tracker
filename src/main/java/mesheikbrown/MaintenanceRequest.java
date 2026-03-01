package mesheikbrown;

public class MaintenanceRequest {

    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int severity;
    private String status;
    private String assignedTech;

    // Default Constructor
    public MaintenanceRequest() {
        this.status = "NEW";
        this.assignedTech = "UNASSIGNED";
    }

    //Parameterized Constructor
    public MaintenanceRequest(String tenantName,String apartmentNumber,String issueType,int severity,String status,String assignedTech){
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = "NEW";
        this.assignedTech = "UNASSIGNED";
    }

    //Getters and Setters
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
            System.out.println("Severity must be between 1 and 5.");
        }
    }
    public String getStatus() {
        return status;
    }
    public boolean setStatus(String status) {
        if (status.equals("NEW") ||
                status.equals("IN_PROGRESS") ||
                status.equals("DONE")) {
            this.status = status;
            return true;
    }
        System.out.println("Invalid status.");
        return false;
    }

    public String getAssignedTech() {
        return assignedTech;
    }
    public void setAssignedTech(String assignedTech) {
        this.assignedTech = assignedTech;
    }





    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Issue: " + issueType +
                " | Severity: " + severity +
                " | Status: " + status +
                " | Tech: " + assignedTech;
    }
}//ends Class
