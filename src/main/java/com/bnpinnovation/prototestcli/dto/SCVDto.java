package com.bnpinnovation.prototestcli.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public interface SCVDto {
    @ToString
    @Getter
    public class Request {
        String username;
        String password;
        String email;
    }

    @ToString
    @RequiredArgsConstructor
    @Getter
    public class Response {
        final String username;
        final String email;
    }
}
