package com.yuri.estoquepreco.config;


import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConfig {
    private final String EXCHANGE_NAME = "amq.direct";

    private AmqpAdmin amqpAdmin;

    public RabbitMQConfig(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue createQueue(String name) {
        return new Queue(name, true, false, false);
    }

    private DirectExchange createExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding bindQueue(Queue queue, DirectExchange exchange) {
        return new Binding(queue.getName(),
                Binding.DestinationType.QUEUE,
                exchange.getName(),
                queue.getName(),
                null
        );
    }

    @PostConstruct
    private void createRabbitMQConnection() {
        //Create Queue
        Queue stockQueue = this.createQueue("stock");
        Queue priceQueue = this.createQueue("price");

        //Declare exchange
        DirectExchange directExchange = createExchange();

        //Bind queue
        Binding stockBind = bindQueue(stockQueue, directExchange);
        Binding priceBind = bindQueue(priceQueue, directExchange);

        this.amqpAdmin.declareQueue(stockQueue);
        this.amqpAdmin.declareQueue(priceQueue);

        this.amqpAdmin.declareExchange(directExchange);

        this.amqpAdmin.declareBinding(stockBind);
        this.amqpAdmin.declareBinding(priceBind);
    }


}
