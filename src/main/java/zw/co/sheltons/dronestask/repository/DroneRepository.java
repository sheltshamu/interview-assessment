package zw.co.sheltons.dronestask.repository;

import org.springframework.stereotype.Repository;
import zw.co.sheltons.dronestask.model.Drone;
import zw.co.sheltons.dronestask.model.State;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends BaseRepository<Drone>{
    boolean existsBySerialNumber(String serialNumber);
    List<Drone> findDronesByState(State state);
}
