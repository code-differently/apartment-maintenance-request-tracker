package masonbrown;

public class MaintenanceRequest {
    private String tenantFirstName;
    private String tenantLastName;
    private int apartmentNumber;
    private String issuetype;
    private int severity;
    private String status;
    private String assignedTech;

    public MaintenanceRequest(String tenantFirstName, String tenantLastName, int apartmentNumber,
                              String issuetype, int severity, String status) {
        this.tenantFirstName = tenantFirstName;
        this.tenantLastName = tenantLastName;
        this.apartmentNumber = apartmentNumber;
        this.issuetype = issuetype;
        this.severity = severity;
        this.status = "NEW";
    }

    public void severitycheck() {
        if (severity == 5) {
            status = "DISPATCH IMMEDIATELY";
        } else if (issuetype.equalsIgnoreCase("electrical") && severity >= 4) {
            status = "WARNING";
        } else if (severity >= 4) {
            status = "HIGH PRIORITY";
        } else {
            status = "NEW";
        }
    }

    @Override
    public String toString() {
        return "Tenant:" + " " + tenantFirstName + " " + tenantLastName +
                "\n" + "Apartment number:" + " " + apartmentNumber + "\n"
                + "Issue Type:" + " " + issuetype + "\n" +
                "Severity:" + " " + severity + "\n" +
                "Status:" + " " + status + "\n" +
                "Assigned Tech:" + " " + (assignedTech == null ? "None" : assignedTech) + "\n";
    }

    public void setTenantLastName(String tenantLastName) {
        this.tenantLastName = tenantLastName;
    }

    public void setTenantFirstName(String tenantFirstName) {
        this.tenantFirstName = tenantFirstName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getTenantLastName() {
        return tenantLastName;
    }

    public String getTenantFirstName() {
        return tenantFirstName;
    }

    public String getStatus() {
        return status;
    }

    public String getIssuetype() {
        return issuetype;
    }

    public int getSeverity() {
        return severity;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }


    public void setAssignedTech(String techName) {
        this.assignedTech = techName;
    }

    public String getAssignedTech() {
        return assignedTech;
    }
}

