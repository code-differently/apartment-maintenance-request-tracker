package coreyscott;

public class EstimatedCost {

    private double labor;
    private double parts;
    private double emergencyFee;

    public EstimatedCost(int severity) {
        // Example: base estimate by severity (you can tweak these numbers)
        switch (severity) {
            case 1:
                labor = 50; parts = 25; emergencyFee = 0;
                break;
            case 2:
                labor = 75; parts = 40; emergencyFee = 0;
                break;
            case 3:
                labor = 100; parts = 75; emergencyFee = 50;
                break;
            case 4:
                labor = 150; parts = 125; emergencyFee = 75;
                break;
            case 5:
                labor = 250; parts = 200; emergencyFee = 100;
                break;
            default:
                labor = 75; parts = 40; emergencyFee = 0;
        }
    }

    public double getTotal() {
        return labor + parts + emergencyFee;
    }

    public String getBreakdown() {
        return String.format("Est. Cost -> Labor: $%.2f | Parts: $%.2f | Emergency: $%.2f | Total: $%.2f",
                labor, parts, emergencyFee, getTotal());
    }
}