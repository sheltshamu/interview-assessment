package zw.co.sheltons.dronestask.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medication")
public class Medication extends BaseEntity{
    @Column(nullable = false,length = 80)
    private String name;
    @Column(nullable = false)
    private int weight;
    @Column(nullable = true, length = 20)
    private String code;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "drone_id",nullable = false)
    private Drone drone;

}
