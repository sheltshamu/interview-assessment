package zw.co.sheltons.dronestask.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Base64;

public class Base64Deserializer extends JsonDeserializer<byte[]> {
    @Override
    public byte[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String encodedContent = jsonParser.getText();
        String cleanedContent = encodedContent.replaceAll("-", "");
        return Base64.getDecoder().decode(cleanedContent);
    }
}