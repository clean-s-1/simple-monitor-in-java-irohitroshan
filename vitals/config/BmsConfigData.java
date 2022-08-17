package vitals.config;

import vitals.LEVEL;

import java.util.Map;

public class BmsConfigData {

    private float min;
    private float max;
    private float tolerance;

    private Map<LEVEL,String> propertyLevelText;

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public float getTolerance() {
        return tolerance;
    }

    public Map<LEVEL, String> getPropertyLevelText() {
        return propertyLevelText;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public void setTolerance(float tolerance) {
        this.tolerance = tolerance;
    }

    public void setPropertyLevelText(Map<LEVEL, String> propertyLevelText) {
        this.propertyLevelText = propertyLevelText;
    }

    @Override
    public String toString() {
        return "BmsConfigData{" +
                "min=" + min +
                ", max=" + max +
                ", tolerance=" + tolerance +
                ", propertyLevelText=" + propertyLevelText +
                '}';
    }
}
