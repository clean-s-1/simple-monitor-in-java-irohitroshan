package vitals.config;

import vitals.language.AlertLanguage;

public interface BmsConfig {

    BmsConfigData getConfigData();

    boolean isBatteryOk(float value, AlertLanguage alertLanguage);

}
