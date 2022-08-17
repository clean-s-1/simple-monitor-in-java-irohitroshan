package vitals;

import vitals.config.ChargeRateConfig;
import vitals.config.SOCConfig;
import vitals.config.TempConfig;
import vitals.language.AlertLanguage;

public class BatteryManagementSystem {

    static boolean isBatteryOk(float value, BatteryFactors batteryFactor, AlertLanguage alertLanguage) {
        if(batteryFactor==BatteryFactors.TEMPERATURE){
            return new TempConfig().isBatteryOk(value, alertLanguage);
        }else if(batteryFactor==BatteryFactors.CHARGE_STATE){
            return new SOCConfig().isBatteryOk(value,alertLanguage );
        }else {
            return new ChargeRateConfig().isBatteryOk(value,alertLanguage );
        }
    }

    public static void main(String[] args) {
        assert (isBatteryOk(25,  BatteryFactors.TEMPERATURE,AlertLanguage.ENGLISH) == true);
        assert (isBatteryOk(50,  BatteryFactors.TEMPERATURE,AlertLanguage.GERMAN) == false);
        assert (isBatteryOk(70,  BatteryFactors.CHARGE_STATE,AlertLanguage.GERMAN) == true);
        assert (isBatteryOk(85,  BatteryFactors.CHARGE_STATE,AlertLanguage.NONE) == false);
        assert (isBatteryOk(0.9f, BatteryFactors.CHARGE_RATE,AlertLanguage.ENGLISH) == false);


        System.out.println("Battery Condition tested");
    }
}
