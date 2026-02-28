package org.codedifferently.christopherbennett.data;

import org.codedifferently.christopherbennett.enums.EActivity;
import org.codedifferently.christopherbennett.enums.EProfessionLevel;

public class Technician {
    private String name;
    private int age;
    private EProfessionLevel professionLevel;
    private EActivity activity;


    public Technician(String name, int age, EProfessionLevel professionLevel, EActivity activity) {
        this.name = name;
        this.age = age;
        this.professionLevel = professionLevel;
        this.activity = activity;
    }
}
