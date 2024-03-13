package com.food.ordering.system.order.service.domain.dto.message;

import com.food.ordering.system.domain.valueobject.OrderApprovalStatus;
import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
public record RestaurantApprovalResponse(UUID id, UUID sagaId, UUID orderId,
                                         UUID restaurantId, Instant createdAT,
                                         OrderApprovalStatus orderApprovalStatus,
                                         List<String> failureMessages) {
}
