package zw.co.sheltons.dronestask.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.sheltons.dronestask.model.Medication;

@Getter
@Setter
public class MedicationDTO {
    private String name;
    private int weight;
    private String code;

    public static MedicationDTO fromDTO(Medication medication){
        MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setCode(medication.getCode());
        medicationDTO.setName(medication.getName());
        medicationDTO.setWeight(medication.getWeight());
        return medicationDTO;
    }
}
