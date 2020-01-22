package org.codedesigner.springcloudstream.processor.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LogMessage implements Serializable {
    private String message;
    public LogMessage(String message) {
        this.message = message;
    }
}