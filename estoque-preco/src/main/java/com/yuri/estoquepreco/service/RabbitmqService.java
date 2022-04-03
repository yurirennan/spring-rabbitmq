package com.yuri.estoquepreco.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitmqService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queueName, Object message){
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
