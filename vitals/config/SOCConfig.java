package vitals.config;

import vitals.LEVEL;
import vitals.language.AlertLanguage;
import vitals.util.BmsUtil;

import java.util.HashMap;
import java.util.Map;

public class SOCConfig implements BmsConfig {

    static BmsConfigData bmsConfigData;
    static {
        bmsConfigData = new BmsConfigData();
        bmsConfigData.setMin(20);
        bmsConfigData.setMax(80);
        bmsConfigData.setTolerance(5);
        Map<LEVEL, String> propertyLevelText = new HashMap<>();
        propertyLevelText.put(LEVEL.LOW_BREACH,"LOW_BREACH_SOC");
        propertyLevelText.put(LEVEL.HIGH_BREACH,"HIGH_BREACH_SOC");
        propertyLevelText.put(LEVEL.LOW_WARNING,"LOW_WARNING_SOC");
        propertyLevelText.put(LEVEL.HIGH_WARNING,"HIGH_WARNING_SOC");
        propertyLevelText.put(LEVEL.NORMAL,"NORMAL_SOC");
        bmsConfigData.setPropertyLevelText(propertyLevelText);
    }

    @Override
    public BmsConfigData getConfigData(){
        return bmsConfigData;
    }

    @Override
    public boolean isBatteryOk(float value, AlertLanguage alertLanguage) {
        return BmsUtil.findBatteryCondition(value,new SOCConfig(),alertLanguage);
    }
}
