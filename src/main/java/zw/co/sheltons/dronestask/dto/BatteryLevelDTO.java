package zw.co.sheltons.dronestask.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatteryLevelDTO {
    private int batteryLevel;
    private String serialNumber;

    public BatteryLevelDTO(int batteryLevel, String serialNumber) {
        this.batteryLevel = batteryLevel;
        this.serialNumber = serialNumber;
    }
}
