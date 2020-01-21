package org.codedesigner.springcloudstream.consumer.entities;

import java.io.Serializable;

public class LogMessage implements Serializable {

    private String message;

    public LogMessage() {

    }

    public LogMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}