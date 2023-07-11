package zw.co.sheltons.dronestask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.sheltons.dronestask.dto.DroneDTO;
import zw.co.sheltons.dronestask.request.DroneRequest;
import zw.co.sheltons.dronestask.service.DroneService;
import zw.co.sheltons.dronestask.service.impl.DroneResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class DispatchController {
    private final DroneService droneService;

    public DispatchController(DroneService droneService) {
        this.droneService = droneService;
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
}
