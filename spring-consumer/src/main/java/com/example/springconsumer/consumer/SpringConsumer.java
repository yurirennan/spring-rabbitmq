package com.example.springconsumer.consumer;

import dto.StockDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringConsumer {
    @RabbitListener(queues = "stock")
    private void consumer(StockDTO stockDTO) {
        System.out.println("Código do Produto: " + stockDTO.getProductCode());
        System.out.println("Quantidade: " + stockDTO.getQuantity());
    }
}
