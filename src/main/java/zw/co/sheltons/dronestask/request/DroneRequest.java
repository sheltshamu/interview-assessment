package zw.co.sheltons.dronestask.request;

import lombok.Getter;
import lombok.Setter;
import zw.co.sheltons.dronestask.model.enums.Model;
import zw.co.sheltons.dronestask.model.enums.State;

@Getter
@Setter
public class DroneRequest {
    private String serialNumber;
    private int batteryLevel;
    private Model model;
    private State state;
    private int weightLimit;

}
