package mesheikbrown;

public class MaintenanceRequest {

    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int severity; // 1–5
    private String status; // default NEW
    private String assignedTech;

    // Default constructor (required)
    public MaintenanceRequest() {
        this.status = "NEW";
        this.assignedTech = "UNASSIGNED";
    }

    // Parameterized constructor (required)
    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int severity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        setSeverity(severity); // validation
        this.status = "NEW";
        this.assignedTech = "UNASSIGNED";
    }

    // Getters & Setters
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
            // keep it simple: clamp invalid values to 1
            this.severity = 1;
        }
    }

    public String getStatus() {
        return status;
    }

    // Status updates must be restricted (Level 3 rule)
    public boolean setStatus(String status) {
        String s = status.toUpperCase();

        if (s.equals("NEW") || s.equals("IN_PROGRESS") || s.equals("DONE")) {
            this.status = s;
            return true;
        }
        return false;
    }

    public String getAssignedTech() {
        return assignedTech;
    }

    public void setAssignedTech(String assignedTech) {
        this.assignedTech = assignedTech;
    }

    // toString() (required)
    @Override
    public String toString() {
        return issueType + " | Apt " + apartmentNumber +
                " | Tenant: " + tenantName +
                " | Severity: " + severity +
                " | Status: " + status +
                " | Tech: " + assignedTech;
    }
}