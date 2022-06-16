package vitals;

public class BatteryManagementSystem {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate, String batteryHealthFactor) {
        boolean batteryState = true;
        switch (batteryHealthFactor) {
            case "temp":
                batteryState = isTempOutOfRange(temperature);
                break;
            case "soc":
                batteryState = isChargeStateOutOfRange(soc);
                break;
            case "rate":
                batteryState = isChargeRateOutOfRange(chargeRate);
                break;
        }
        return batteryState;
    }

    private static boolean isChargeRateOutOfRange(float chargeRate) {
        System.out.println("Charge Rate is out of range!");
        return !(chargeRate > 0.8);
    }

    private static boolean isChargeStateOutOfRange(float soc) {
        System.out.println("State of Charge is out of range!");
        return !(soc < 20 || soc > 80);
    }

    private static boolean isTempOutOfRange(float temperature) {
        System.out.println("Temperature is out of range!");
        return !(temperature < 0 || temperature > 45);
    }

    public static void main(String[] args) {
        assert (batteryIsOk(25, 70, 0.7f, "temp") == true);
        assert (batteryIsOk(50, 85, 0.0f, "temp") == false);
        assert (batteryIsOk(25, 70, 0.7f, "soc") == true);
        assert (batteryIsOk(25, 85, 0.0f, "soc") == false);
        assert (batteryIsOk(25, 70, 0.9f, "rate") == false);
        System.out.println("Battery Condition tested");


    }
}
