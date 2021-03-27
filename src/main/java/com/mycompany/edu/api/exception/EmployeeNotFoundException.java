package com.mycompany.edu.api.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author yosrixp
 */
public class EmployeeNotFoundException extends Exception {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final String errorMsg;

    public EmployeeNotFoundException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;

    }

    public EmployeeNotFoundException(String errorMsg, Throwable ex) {
        super(errorMsg, ex);
        this.errorMsg = errorMsg;
    }

    public Response toResponse() {
        ResponseBuilder builder = Response.status(Status.NOT_FOUND)
                .entity(defaultJSON(errorMsg, Status.NOT_FOUND))
                .type(MediaType.APPLICATION_JSON);
        return builder.build();
    }

    private String defaultJSON(final String error, Status status) {
        ErrorMessage errorInfo = new ErrorMessage(error, status.getReasonPhrase(), status.getStatusCode());

        try {
            return MAPPER.writeValueAsString(errorInfo);
        } catch (JsonProcessingException e) {
            return "{\"message\":\"An internal error occurred\"}";
        }
    }

    static class ErrorMessage {

        final String errorMessage;
        final String statusMsg;
        final int statusCode;

        public ErrorMessage(String errorMessage, String statusMsg, int statusCode) {
            this.errorMessage = errorMessage;
            this.statusMsg = statusMsg;
            this.statusCode = statusCode;
        }

        @JsonProperty(value = "errorMessage")
        public String getErrorMessage() {
            return errorMessage;
        }

        @JsonProperty(value = "statusMessage")
        public String getStatusMessage() {
            return statusMsg;
        }

        @JsonProperty(value = "statusCode")
        public int getStatusCode() {
            return statusCode;
        }
    }
}
