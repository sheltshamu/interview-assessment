package zw.co.sheltons.dronestask.service.impl;

public class BatteryLevelResponse {
    private int batteryLevel;

    public BatteryLevelResponse(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
