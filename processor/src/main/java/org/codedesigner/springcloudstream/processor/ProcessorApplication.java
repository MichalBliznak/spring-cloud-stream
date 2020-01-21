package org.codedesigner.springcloudstream.processor;

import org.codedesigner.springcloudstream.processor.entities.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class ProcessorApplication {

    private Logger logger = LoggerFactory.getLogger(ProcessorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProcessorApplication.class, args);
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public LogMessage enrichLogMessage(LogMessage log) {
        logger.info("Enriching message {}", log.getMessage());
        return new LogMessage(String.format("[1]: %s", log.getMessage()));
    }

}
