package org.codedifferently.christopherbennett.data;

import org.codedifferently.christopherbennett.enums.EActivity;
import org.codedifferently.christopherbennett.enums.EProfessionLevel;

public class Technician {
    private String name;
    private int age;
    private EProfessionLevel professionLevel;
    private EActivity activity;
    private MaintenanceRequest request;


    public Technician(String name, int age, EProfessionLevel professionLevel, EActivity activity) {
        this.name = name;
        this.age = age;
        this.professionLevel = professionLevel;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public EProfessionLevel getProfessionLevel() {
        return professionLevel;
    }

    public EActivity getActivity() {
        return activity;
    }

    public void setActivity(EActivity activity) {
        this.activity = activity;
    }

    public void setRequest(MaintenanceRequest request) {
        this.request = request;
    }

    public MaintenanceRequest getRequest() {
        return request;
    }
}
