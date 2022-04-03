package com.yuri.estoquepreco.controller;

import com.yuri.estoquepreco.service.RabbitmqService;
import dto.PriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {

    private RabbitmqService rabbitmqService;

    @Autowired
    public PriceController(RabbitmqService rabbitmqService) {
        this.rabbitmqService = rabbitmqService;
    }

    @PutMapping
    private ResponseEntity changePrice(@RequestBody PriceDTO priceDTO) {
        this.rabbitmqService.sendMessage("price", priceDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
