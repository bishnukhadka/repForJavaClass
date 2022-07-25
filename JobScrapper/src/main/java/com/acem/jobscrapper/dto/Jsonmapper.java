package com.acem.jobscrapper.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonmapper {
    public String mapToJSON(Object object ) {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = null;
        try{
            str = objectMapper.writeValueAsString(object);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return str;
    }
}
