package vitals.util;

import vitals.config.BmsConfig;
import vitals.config.BmsConfigData;
import vitals.language.AlertLanguage;

public class BmsUtil {

    public static boolean findBatteryCondition(float value, BmsConfig bmsConfig,AlertLanguage alertLanguage){
        boolean batteryHealthState = true;
        BmsConfigData bmsConfigData = bmsConfig.getConfigData();
        batteryHealthState = isBatteryHealthState(value, batteryHealthState, bmsConfigData);
        printMessage(value, bmsConfig, alertLanguage);
        return batteryHealthState;
    }

    private static boolean isBatteryHealthState(float value, boolean batteryHealthState, BmsConfigData bmsConfigData) {
        if (value < bmsConfigData.getMin() || value > bmsConfigData.getMax()) {
            batteryHealthState = false;
        }
        return batteryHealthState;
    }

    private static void printMessage(float value, BmsConfig bmsConfig, AlertLanguage alertLanguage) {
        if(!AlertLanguage.NONE.equals(alertLanguage)){
            AlertMessageUtil.printStatusMessage(LevelFinderUtil.getPropertyStatus(value, bmsConfig), alertLanguage);
        }
    }
}
