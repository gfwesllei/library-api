package br.com.gfwesllei.library.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * @author weslleiferreira
 * @project library
 */
public class BaseEntity implements Serializable {

    public String asJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);

    }
}
