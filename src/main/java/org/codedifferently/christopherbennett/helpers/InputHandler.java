package org.codedifferently.christopherbennett.helpers;

import org.codedifferently.christopherbennett.enums.EIssueType;

import java.util.Scanner;

public class InputHandler {

    public static int handleIntegerInput() {
        Scanner scan = new Scanner(System.in);
        int scanInput = 0;
        boolean validScanInput = false;
        //While loop to make sure user puts in the correct input
        while(!validScanInput) {
            //Call Scanner methods
            try {
                //Scanner method to collect input
                scanInput = scan.nextInt();
                validScanInput = true;
            }
            catch (Exception e) {
                //If user enters invalid input, the catch block will prevent errors.
                System.out.println("Invalid input! Try typing a number instead of a String!");
                scan.next();
            }
        }
        return scanInput;
    }

    public static String handleStringInput() {
        Scanner scan = new Scanner(System.in);
        String scanInput = "";
        boolean validScanInput = false;
        //While loop to make sure user puts in the correct input
        while(!validScanInput) {
            //Call Scanner methods
            try {
                //Scanner method to collect input
                scanInput = scan.nextLine();
                validScanInput = true;
            }
            catch (Exception e) {
                //If user enters invalid input, the catch block will prevent errors.
                System.out.println("Invalid input! Try typing a valid String!");
                scan.next();
            }
        }
        return scanInput;
    }

    public static EIssueType handleEnumInput(EIssueType[] validOptions) {
        Scanner scan = new Scanner(System.in);
        EIssueType result = null;

        while (result == null) {
            String scanInput = scan.nextLine().trim();

            for (int i = 0; i < validOptions.length; i++) {
                if (scanInput.equalsIgnoreCase(validOptions[i].name())) {
                    result = validOptions[i];
                    break;
                }
            }

            if (result == null) {
                System.out.println("Invalid input! Valid options are:");
                for (EIssueType option : validOptions) {
                    System.out.println("  - " + option.name());
                }
            }
        }

        return result;
    }

}
