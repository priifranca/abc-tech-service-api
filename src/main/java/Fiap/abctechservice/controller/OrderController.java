package Fiap.abctechservice.controller;

import Fiap.abctechservice.application.OrderApplication;
import Fiap.abctechservice.application.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderApplication orderApplication;


    public OrderController(@Autowired OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    @PostMapping()
    public ResponseEntity createOrder(
            @Valid
            @RequestBody
                    OrderDto orderDto
    ){
        orderApplication.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }

}