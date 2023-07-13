package zw.co.sheltons.dronestask.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "image")
@Builder
public class Image extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "content")
    private byte[] content;
}