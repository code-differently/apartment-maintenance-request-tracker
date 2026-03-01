package jamesbarclayApartmentMaintenance;


/*It must contain:

tenantName
        apartmentNumber
issueType
severity (1–5)
status (default = "NEW")
Requirements:

Include both constructors
Include getters and setters
Include a toString() method*/


public class MaintenanceRequest {
    //Declared the variables and made them private (Encapsulation) **needs Getter and Setters
    private String tenantName;
    private int apartmentNumber;
    private String issueType;
    private int severity;
    private String status;

    //I have to create the Constructor
   // public MaintenanceRequest (){
    //status (default = "NEW")
      //  status = "NEW";
   // }

    public MaintenanceRequest (String tenantName, int apartmentNumber, String issueType, int severity, String status){
        //Parameterized the Constructor
        //Called the fields (this.) and set the values
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.status = status;
    }
        //Create the Getters
    public String getTenantName() {
        return tenantName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public int getSeverity() {
        return severity;
    }

    public String getStatus() {
        return status;
    }
        //Create the Setter

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tenant: " + tenantName + "Apt: " + apartmentNumber + "Issue: " + issueType + "Severity: " + severity + "Status: " + status;
    }



}
