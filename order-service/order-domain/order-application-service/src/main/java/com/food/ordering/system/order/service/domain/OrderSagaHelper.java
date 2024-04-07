package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.exception.OrderNotFoundException;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderSagaHelper {

    private final OrderRepository orderRepository;

    public OrderSagaHelper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    Order findOrder(UUID uuid) {
        Optional<Order> orderResponse = orderRepository.findById(new OrderId(uuid));
        if (orderResponse.isEmpty()) {
            log.error("Order with id: {} could not be found", uuid);
            throw new OrderNotFoundException("Order with id " + uuid + " could not be found");
        }
        return orderResponse.get();
    }
    void saveOrder(Order order){
        orderRepository.save(order);
    }
}
