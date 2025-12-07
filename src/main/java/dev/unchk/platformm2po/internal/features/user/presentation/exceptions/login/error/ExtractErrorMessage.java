package dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ExtractErrorMessage  {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static String ErrorHandle(String error) {
        try {
            JsonNode nodeError = objectMapper.readTree(error);
            if (nodeError.has("error")) {
                JsonNode errorNode = nodeError.get("error");
                if (errorNode.has("message")) {
                    return errorNode.get("message").asText().replace("\"", "");
                }
            }
            return error.replace("\"", "");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
