package com.food.ordering.system.order.service.domain.dto.create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record OrderAddress(@NotNull @Max(50) String street, @NotNull @Max(10) String postalCode,
                          @Max(50) @NotNull String city) {
}
