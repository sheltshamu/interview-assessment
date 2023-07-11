package zw.co.sheltons.dronestask.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import zw.co.sheltons.dronestask.model.Model;
import zw.co.sheltons.dronestask.model.State;

@Getter
@Setter
@ToString
public class DroneRequest {
    private String serialNumber;
    private int batterLevel;
    private Model model;
    private State state;

}
