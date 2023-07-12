package zw.co.sheltons.dronestask.service;

import zw.co.sheltons.dronestask.dto.MedicationDTO;
import zw.co.sheltons.dronestask.service.impl.medication.MedicationResponse;

import java.util.List;

public interface MedicationService {
    List<MedicationDTO> checkLoadedMedicationItems(Long droneId);


}
