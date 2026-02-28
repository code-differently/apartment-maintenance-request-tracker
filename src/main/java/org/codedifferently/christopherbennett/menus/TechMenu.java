package org.codedifferently.christopherbennett.menus;

import org.codedifferently.christopherbennett.data.Technician;
import org.codedifferently.christopherbennett.helpers.InputHandler;

import java.util.List;

public class TechMenu {
    public void promptTechMenu(List<Technician> technicianList) {
        System.out.println("===== TECHNICIAN WATCH =====\n");

        for(int i = 0; i < technicianList.size(); i++) {
            Technician tech = technicianList.get(i);
            System.out.print((i+1) + ". " + tech.getName());
            System.out.print(" | " + tech.getAge() + " | ");
            System.out.print(tech.getProfessionLevel() + " | " + tech.getActivity());
            System.out.println();
        }

        System.out.println();
        System.out.println("Type anything to continue:");
        InputHandler.handleStringInput();
    }
}
