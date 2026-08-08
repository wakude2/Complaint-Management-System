package com.society.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.society.exception.CustomException;
import com.society.exception.ErrorResponse;
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
