package Fiap.abctechservice.application;

import Fiap.abctechservice.application.dto.OrderDto;

public interface OrderApplication {

    void createOrder(OrderDto orderDto);
}