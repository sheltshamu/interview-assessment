package zw.co.sheltons.dronestask.request;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import zw.co.sheltons.dronestask.dto.ImageDto;

@Setter
@Getter
public class MedicationRequest {
    @Pattern(regexp = "^[A-Za-z0-9_-]+$", message = "Invalid name format")
    private String name;
    private int weight;
    private String code;
    private Long droneId;
    private ImageDto image;
}
