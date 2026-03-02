package org.codedifferently;

public class Technician {
    //private fields of a technician
    private String type;
    private  String name;

    //constructor
    public Technician(String type, String name){
        this.type = type;
        this.name = name;
    }

    //getters and setters for the private fields
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
