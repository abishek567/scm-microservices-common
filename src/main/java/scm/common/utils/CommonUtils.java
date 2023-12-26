package scm.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.Serializable;
import java.util.List;

public class CommonUtils {

    private final static ObjectMapper mapper = new ObjectMapper();

    public static <T> T getModelFromJsonObject(String jsonObjectString, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(jsonObjectString, tClass);
    }

    public static <T> List<T> getListFromJsonArray(String jsonArrayString, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(jsonArrayString, TypeFactory.defaultInstance().constructCollectionType(List.class, tClass));
    }

    public static String getJsonArrayStringFromList(List<?> list) throws JsonProcessingException {
        return mapper.writeValueAsString(list);
    }

    public static String getJsonObjectStringFromModel(Serializable model) throws JsonProcessingException {
        return mapper.writeValueAsString(model);
    }

}
