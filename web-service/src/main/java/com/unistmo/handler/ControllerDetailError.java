package com.unistmo.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControllerDetailError {
    private String message;
    private HttpStatus statusCode;
    private LocalDateTime date;
}
