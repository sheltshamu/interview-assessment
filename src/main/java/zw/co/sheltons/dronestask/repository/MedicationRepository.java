package zw.co.sheltons.dronestask.repository;

import org.springframework.stereotype.Repository;
import zw.co.sheltons.dronestask.model.Medication;

import java.util.List;

@Repository
public interface MedicationRepository extends BaseRepository<Medication>{
    List<Medication> findAllByDrone_Id(Long droneId);
}
