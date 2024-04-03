package com.food.ordering.system.restaurant.service.domain.mapper;

import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.domain.valueobject.OrderStatus;
import com.food.ordering.system.domain.valueobject.RestaurantId;
import com.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.food.ordering.system.restaurant.service.domain.entity.OrderDetail;
import com.food.ordering.system.restaurant.service.domain.entity.Product;
import com.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RestaurantDataMapper {
    public Restaurant restaurantApprovalRequestToRestaurant(RestaurantApprovalRequest restaurantApprovalRequest) {
    return Restaurant.Builder.builder()
            .restaurantId(new RestaurantId(UUID.fromString(restaurantApprovalRequest.restaurantId())))
            .orderDetail(OrderDetail.Builder.builder()
                    .orderId(new OrderId(UUID.fromString(restaurantApprovalRequest.orderId())))
                    .products(restaurantApprovalRequest.products().stream().map(
                            product -> Product.Builder.builder()
                                    .productId(product.getId())
                                    .quantity(product.getQuantity())
                                    .build()
                    ).toList())
                    .totalAmount(new Money(restaurantApprovalRequest.price()))
                    .orderStatus(OrderStatus.valueOf(restaurantApprovalRequest.restaurantOrderStatus().name()))
                    .build())
            .build();
    }
}
