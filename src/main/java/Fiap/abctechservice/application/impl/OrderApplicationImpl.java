package Fiap.abctechservice.application.impl;

import Fiap.abctechservice.application.OrderApplication;
import Fiap.abctechservice.application.dto.OrderDto;
import Fiap.abctechservice.application.dto.OrderLocationDto;
import Fiap.abctechservice.model.Order;
import Fiap.abctechservice.model.OrderLocation;
import Fiap.abctechservice.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApplicationImpl implements OrderApplication {

    private final OrderService orderService;

    public OrderApplicationImpl(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public void createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOperatorId(orderDto.getOperatorId());
        order.setStartOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getStart()));
        order.setEndOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getEnd()));

        this.orderService.saveOrder(order, orderDto.getServices());
    }


    private OrderLocation getOrderLocationFromOrderLocationDto(OrderLocationDto orderLocationDto) {
        OrderLocation location = new OrderLocation();
        location.setLatitude(orderLocationDto.getLatitude());
        location.setLongitude(orderLocationDto.getLatitude());
        location.setDate(orderLocationDto.getDateTime());
        return location;
    }
}
