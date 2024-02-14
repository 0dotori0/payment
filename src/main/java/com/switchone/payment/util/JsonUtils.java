package com.switchone.payment.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class JsonUtils {

    private final ObjectMapper objectMapper;

    public String convertJsonString(Object object) throws Exception {
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        return objectMapper.writeValueAsString(object);
    }

    public Object convertJsonToClass(String jsonString, Class className) throws Exception {
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        return objectMapper.readValue(jsonString, className);
    }
}
