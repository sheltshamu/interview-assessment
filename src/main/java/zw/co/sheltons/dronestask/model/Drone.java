package zw.co.sheltons.dronestask.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drone")
public class Drone extends BaseEntity {
    @Column(name = "serial_number", nullable = false, unique = true, length = 80)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    @Column(name = "battery_level", nullable = false)
    private int batteryLevel;
    @Enumerated(EnumType.STRING)
    private State state;

}
