package com.yuri.estoquepreco.controller;

import dto.StockDTO;
import com.yuri.estoquepreco.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    private RabbitmqService rabbitmqService;

    @Autowired
    public StockController(RabbitmqService rabbitmqService) {
        this.rabbitmqService = rabbitmqService;
    }

    @PutMapping
    private ResponseEntity changeStock(@RequestBody StockDTO stockDTO) {
        this.rabbitmqService.sendMessage("stock", stockDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
