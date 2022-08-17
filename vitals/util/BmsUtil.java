package vitals.util;

import vitals.config.BmsConfig;
import vitals.config.BmsConfigData;
import vitals.language.AlertLanguage;

public class BmsUtil {

    public static boolean findBatteryCondition(float value, BmsConfig bmsConfig,AlertLanguage alertLanguage){
        boolean batteryHealthState = true;
        BmsConfigData bmsConfigData = bmsConfig.getConfigData();
        if (value < bmsConfigData.getMin() || value > bmsConfigData.getMax()) {
            batteryHealthState = false;
        }
        if(!AlertLanguage.NONE.equals(alertLanguage)){
            AlertMessageUtil.printStatusMessage(LevelFinderUtil.getPropertyStatus(value,bmsConfig),alertLanguage);
        }
        return batteryHealthState;
    }
}
