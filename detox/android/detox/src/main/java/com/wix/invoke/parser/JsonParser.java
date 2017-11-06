package com.wix.invoke.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.json.JSONException;

/**
 * Created by rotemm on 13/10/2016.
 */
public class JsonParser {

    ObjectMapper objectMapper;
    public JsonParser() {
        objectMapper = new ObjectMapper();
    }

    public void addMixInAnnotations(Class<?> target, Class<?> mixinSource) {
        objectMapper.addMixInAnnotations(target, mixinSource);
    }

    public <T> T parse(Object object, Class<T> valueType) {

        try {
            return objectMapper.convertValue(object, valueType);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> JSONObject parse(String jsonData, Class<T> valueType) {
        try {
            JSONObject obj = new JSONObject(jsonData);
            return obj;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
