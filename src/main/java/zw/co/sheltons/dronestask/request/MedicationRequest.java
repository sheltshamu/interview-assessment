package zw.co.sheltons.dronestask.request;

import lombok.Getter;
import lombok.Setter;
import zw.co.sheltons.dronestask.dto.ImageDto;

@Setter
@Getter
public class MedicationRequest {
    private String name;
    private int weight;
    private String code;
    private Long droneId;
    private ImageDto image;
}
