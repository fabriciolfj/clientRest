package br.com.client.restexpert.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Problem {

    private Integer status;
    private OffsetDateTime timestamp;
    private String detail;
    private List<Object> objects;

    @Data
    public static class Object {
        String name;
        String userMessage;
    }
}
