package vitals.util;

import vitals.LEVEL;
import vitals.config.BmsConfig;

public class LevelFinderUtil {

     static LEVEL getLevel(float value, float min, float max) {
        if (value < min) {
            return LEVEL.LOW_BREACH;
        } else if (value < max) {
            return LEVEL.NORMAL;
        }
        return LEVEL.HIGH_BREACH;
    }


      static float getTolerance(float max, float tolerance)  {
        return (max * tolerance) / 100;
    }

   public static boolean isNormalLevel(LEVEL level){
        return level == LEVEL.NORMAL;
    }

     static LEVEL checkWarningLevel(float value, float minTolerance, float maxTolerance){
        if (value <= minTolerance) {
            return LEVEL.LOW_WARNING;
        } else if (value >= maxTolerance) {
            return LEVEL.HIGH_WARNING;
        }
        return LEVEL.NORMAL;
    }

    public static String getPropertyStatus (float value, BmsConfig bmsConfig){

  float toleranceVal = getTolerance(bmsConfig.getConfigData().getMax(),  bmsConfig.getConfigData().getTolerance());
        LEVEL level = getLevel(value, bmsConfig.getConfigData().getMin(), bmsConfig.getConfigData().getMax());
     boolean isInRange = isNormalLevel(level);
        if (isInRange) {
            level = checkWarningLevel(value, bmsConfig.getConfigData().getMin() + toleranceVal,bmsConfig.getConfigData().getMax() - toleranceVal);
        }
        return bmsConfig.getConfigData().getPropertyLevelText().get(level);
    }





}
