package zw.co.sheltons.dronestask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.sheltons.dronestask.dto.BatteryLevelDTO;
import zw.co.sheltons.dronestask.dto.DroneDTO;
import zw.co.sheltons.dronestask.dto.MedicationDTO;
import zw.co.sheltons.dronestask.request.DroneRequest;
import zw.co.sheltons.dronestask.request.MedicationRequest;
import zw.co.sheltons.dronestask.service.DroneService;
import zw.co.sheltons.dronestask.service.MedicationService;
import zw.co.sheltons.dronestask.service.impl.drone.DroneResponse;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DispatchController {
    private final DroneService droneService;
    private final MedicationService medicationService;

    public DispatchController(DroneService droneService, MedicationService medicationService) {
        this.droneService = droneService;
        this.medicationService = medicationService;
    }

    @PostMapping("/drone/register")
    public ResponseEntity<DroneDTO> register(@RequestBody DroneRequest droneRequest){
        DroneResponse response = droneService.register(droneRequest);
        DroneDTO droneDTO = DroneDTO.fromDTO(response.drone());
        return ResponseEntity.ok(droneDTO);
    }

    @GetMapping("/find-all-available")
    public ResponseEntity<List<DroneDTO>> findAvailable(){
        List<DroneDTO> responses = droneService.findAvailableDrones()
                .stream().map(droneResponse -> DroneDTO.fromDTO(droneResponse.drone())).toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{droneId}/battery")
    public ResponseEntity<BatteryLevelDTO> checkBatteryLevel(@PathVariable Long droneId){
        BatteryLevelDTO response = droneService.checkBatteryLevel(droneId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/drone/load")
    public ResponseEntity<DroneDTO> loadDrone(@RequestBody MedicationRequest medicationRequest){
        DroneResponse droneResponse = droneService.loadDrone(medicationRequest);
        DroneDTO droneDTO = DroneDTO.fromDTO(droneResponse.drone());
        return ResponseEntity.ok(droneDTO);
    }

    @GetMapping("/loaded-items/{droneId}")
    public ResponseEntity<List<MedicationDTO>> checkLoadedMedicationItems(@PathVariable Long droneId){
        List<MedicationDTO> medications = medicationService.checkLoadedMedicationItems(droneId);
        return ResponseEntity.ok(medications);

    }
}
