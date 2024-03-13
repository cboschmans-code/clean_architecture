package com.food.ordering.system.order.service.domain.dto.message;

import com.food.ordering.system.domain.valueobject.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record PaymentResponse(UUID id, UUID sagaId, UUID orderId,
                              UUID paymentId, UUID customerId, BigDecimal price,
                              Instant createdAt, PaymentStatus paymentStatus,
                              List<String> failureMessages) {
}
