package zw.co.sheltons.dronestask.service.impl.drone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatteryLevelResponse {
    private int batteryLevel;
    private String serialNumber;

    public BatteryLevelResponse(int batteryLevel, String serialNumber) {
        this.batteryLevel = batteryLevel;
        this.serialNumber = serialNumber;
    }
}
