package Fiap.abctechservice.service;


import Fiap.abctechservice.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order, List<Long> arrayAssists);

    void saveOrder(Order order) throws Exception;
    List<Order> listOrdersByOperator(Long operatorId);
}
