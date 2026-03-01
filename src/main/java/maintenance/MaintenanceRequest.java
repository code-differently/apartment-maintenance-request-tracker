package maintenance;

public class MaintenanceRequest {

    private String tenantName;

    private String apartmentNumber;

    private String issueType;

    private int severity;

    private String status;

    private String assignedTech;   // assigned at Level 3


    public MaintenanceRequest() {

        this.status = "NEW";

        this.assignedTech = "UNASSIGNED";
    }


    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int severity) {

        this.tenantName = tenantName;

        this.apartmentNumber = apartmentNumber;

        this.issueType = issueType;

        setSeverity(severity);

        this.status = "NEW";

        this.assignedTech = "UNASSIGNED";
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

        if (severity < 1) severity = 1;

        if (severity > 5) severity = 5;

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

    public boolean isHighPriority() {

        return severity >= 4;
    }

    @Override
    public String toString() {

        return "Request{" +
                "tenant='" + tenantName + '\'' +
                ", apt='" + apartmentNumber + '\'' +
                ", issue='" + issueType + '\'' +
                ", severity=" + severity +
                ", status='" + status + '\'' +
                ", tech='" + assignedTech + '\'' +
                '}';
    }
}