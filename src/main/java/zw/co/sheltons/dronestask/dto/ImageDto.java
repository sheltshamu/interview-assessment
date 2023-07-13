package zw.co.sheltons.dronestask.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.sheltons.dronestask.utils.Base64Deserializer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private String name;
    private String type;
    @JsonDeserialize(using = Base64Deserializer.class)
    private byte[] content;
}