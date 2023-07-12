package zw.co.sheltons.dronestask.service.impl.medication;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedicationRequest {
    private String name;
    private int weight;
    private String code;
    private String imageUrl;
    private Long droneId;
}
