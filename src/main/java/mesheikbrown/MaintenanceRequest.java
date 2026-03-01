package mesheikbrown;

public class MaintenanceRequest {

    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int severity;
    private String status;
    private String assignedTech;

    //Default Constructor
    MaintenanceRequest(){
    }

    //Parameterized Constructor
    public MaintenanceRequest(String tenantName,String apartmentNumber,String issueType,int severity,String status,String assignedTech){
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = status;
        this.assignedTech = assignedTech;
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
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTech() {
        return assignedTech;
    }
    public void setAssignedTech(String assignedTech) {
        this.assignedTech = assignedTech;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}//ends Class
