package org.codedesigner.springcloudstream.producer.controllers;

import org.codedesigner.springcloudstream.producer.entities.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;


@RestController
public class MessageController {
    Logger logger = LoggerFactory.getLogger(MessageController.class);

    final Source processor;

    public MessageController(Source processor) {
        this.processor = processor;
    }

    @PostMapping(path = "/message")
    public @ResponseBody String send(@RequestParam String msg) {
        logger.info("Processing 'send' request with data '{}'", msg);
        processor.output().send(message(new LogMessage(msg)));
        return "Message " + msg + " was sent to the message broker.";
    }

    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }

}
