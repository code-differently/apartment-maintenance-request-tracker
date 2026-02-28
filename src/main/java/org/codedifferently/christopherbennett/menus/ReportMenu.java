package org.codedifferently.christopherbennett.menus;

import org.codedifferently.christopherbennett.helpers.InputHandler;

public class ReportMenu {
    public void promptReportMenu() {
        System.out.println("===== DAILY REPORT =====\n");
        System.out.println("Type anything to continue:");
        InputHandler.handleStringInput();
    }
}
