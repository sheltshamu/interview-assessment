package zw.co.sheltons.dronestask.service.impl.medication;

import org.springframework.stereotype.Service;
import zw.co.sheltons.dronestask.dto.MedicationDTO;
import zw.co.sheltons.dronestask.exceptions.ItemNotFoundException;
import zw.co.sheltons.dronestask.repository.DroneRepository;
import zw.co.sheltons.dronestask.repository.MedicationRepository;
import zw.co.sheltons.dronestask.service.MedicationService;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {
    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;


    public MedicationServiceImpl(DroneRepository droneRepository, MedicationRepository medicationRepository) {
        this.droneRepository = droneRepository;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public List<MedicationDTO> checkLoadedMedicationItems(Long droneId) {
        if (!droneRepository.existsById(droneId)){
            throw new ItemNotFoundException("Drone with id {0} not found !",droneId);
        }
        return medicationRepository.findAllByDrone_Id(droneId)
                .stream().map(MedicationDTO::fromDTO)
                .toList();
    }


}
