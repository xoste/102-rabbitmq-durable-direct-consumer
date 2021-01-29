package com.xoste.rabbitmqdurabledirectconsumer.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * error消息接收者
 * @author Leon
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.DIRECT),
        key = "${rabbitmq.config.queue.error.routing.key}",
        value = @Queue(value = "${rabbitmq.config.queue.error}", autoDelete = "false")
))
public class ErrorReceiver {

    @RabbitHandler
    public void errorReceive(String msg) {
        System.out.println("error......receive: " +msg);
    }
}
