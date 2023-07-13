package zw.co.sheltons.dronestask.model;


import jakarta.persistence.*;
import lombok.*;
import zw.co.sheltons.dronestask.model.enums.Model;
import zw.co.sheltons.dronestask.model.enums.State;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drone")
public class Drone extends BaseEntity {
    @Column(name = "serial_number", unique = true, length = 80)
    private String serialNumber;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Model model;
    @Column(name = "battery_level", nullable = false)
    private int batteryLevel;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(name = "weight_limit",nullable = false)
    private int weightLimit;
    @Column(name = "current_weight")
    private int currentWeight;

}
