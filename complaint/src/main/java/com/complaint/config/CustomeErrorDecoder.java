package com.complaint.config;

import com.complaint.exception.CustomException;
import com.complaint.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;


import java.io.IOException;
import java.io.InputStream;

public class CustomeErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try(InputStream is = response.body().asInputStream()) {
            ErrorResponse errorResponse = objectMapper.readValue(is, ErrorResponse.class);
            return new CustomException(errorResponse.getMessage(), errorResponse.getStatus());
        } catch (IOException e) {
            throw new CustomException("INTERNAL_SERVER_ERROR");
        }
    }
}
