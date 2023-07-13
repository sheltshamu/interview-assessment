package zw.co.sheltons.dronestask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medication")
public class Medication extends BaseEntity{
    @Pattern(regexp = "^[a-zA-Z0-9-_]+$")
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false)
    private int weight;
    @Column(nullable = true, length = 20)
    private String code;
    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;
    @OneToOne
    @JoinColumn(name = "image",referencedColumnName = "id")
    private Image image;
}
