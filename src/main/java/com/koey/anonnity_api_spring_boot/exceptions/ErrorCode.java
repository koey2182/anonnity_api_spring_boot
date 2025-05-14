package com.koey.anonnity_api_spring_boot.exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    INVALID_LOGIN_ID(HttpStatus.BAD_REQUEST, "INVALID_LOGIN_ID"),
    INVALID_LOGIN_PW(HttpStatus.BAD_REQUEST, "INVALID_LOGIN_PW"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR"),
    INVALID_NICKNAME(HttpStatus.BAD_REQUEST, "INVALID_NICKNAME");

    private final HttpStatus httpStatus;
    private final String reason;

    ErrorCode(HttpStatus httpStatus, String reason) {
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }

    public ApiException toApiException(String message) {
        return new ApiException(this.httpStatus, this.reason, message);
    }
}
