package Fiap.abctechservice.service.impl;

import Fiap.abctechservice.handler.exception.MaxAssistsException;
import Fiap.abctechservice.handler.exception.MinimumAssistsRequiredException;
import Fiap.abctechservice.model.Assistance;
import Fiap.abctechservice.model.Order;
import Fiap.abctechservice.repository.AssistanceRepository;
import Fiap.abctechservice.repository.OrderRepository;
import Fiap.abctechservice.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private AssistanceRepository assistanceRepository;

    public OrderServiceImpl (@Autowired OrderRepository orderRepository,
                             @Autowired AssistanceRepository assistanceRepository) {
        this.orderRepository = orderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists)  {
        ArrayList<Assistance> assistances = new ArrayList<>();

        arrayAssists.forEach( i ->{
            Assistance assistance = this.assistanceRepository.findById(i).orElseThrow();
            assistances.add(assistance);
        });

        order.setServices(assistances);

        if (!order.hasMinAssists()){
            throw new MinimumAssistsRequiredException("Array de assistências inváldio", "Por favor, envie ao menos 1 assistência" );
        } else if (order.exceedsMaxAssists()){
            throw new MaxAssistsException("Array de assistências inváldio", "O número máximo de assistências é 15");
        }

        orderRepository.save(order);
    }

    @Override
    public void saveOrder(Order order) throws Exception {

    }

    @Override
    public List<Order> listOrdersByOperator(Long operatorId) {
        return null;
    }
}
