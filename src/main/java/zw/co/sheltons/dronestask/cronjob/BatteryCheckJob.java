package zw.co.sheltons.dronestask.cronjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import zw.co.sheltons.dronestask.exceptions.BadRequestException;
import zw.co.sheltons.dronestask.model.Drone;
import zw.co.sheltons.dronestask.repository.DroneRepository;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Configuration
@Slf4j
public class BatteryCheckJob {
    private final DroneRepository droneRepository;

    public BatteryCheckJob(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Scheduled(fixedDelay = 60000)
    public void checkBatteryLevels(){
        log.info("BatteryCheckJob::checkBatteryLevels executing check battery level job");
        List<Drone> drones = droneRepository.findAll();
        if (!drones.isEmpty()) {
            drones.forEach(this::auditLogging);
            log.info("BatteryCheckJob::checkBatteryLevels logging audit information for the drone(s)");
        }else{
            log.info("BatteryCheckJob::checkBatteryLevels no drones to log audit information");
        }
    }

    public void auditLogging(Drone drone) {
        log.info("BatteryCheckJob::auditLogging  writing in a csv file");
        JsonObject logEntry = Json.createObjectBuilder()
                .add("serialNumber",drone.getSerialNumber())
                .add("batteryLevel",drone.getBatteryLevel())
                .add("date",Instant.now().toString())
                .build();
        try {
            FileWriter csvWriter = new FileWriter("audit_log.csv", true);
            csvWriter.write(logEntry.toString() + "\n");
            csvWriter.flush();
            csvWriter.close();
            log.info("BatteryCheckJob::auditLogging  finished writing in a csv file");
        } catch (IOException e) {
            log.info("BatteryCheckJob::auditLogging  failed writing in a csv file");
            throw new BadRequestException(e.getMessage());
        }
    }

}
