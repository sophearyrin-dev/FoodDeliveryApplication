package com.food.restaurant.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {

    @NotBlank(message = "Restaurant name must not be empty")
    @Size(min = 5, max = 20, message = "Restaurant name must be between 5 and 20 characters")
    private String name;
    private String address;
    private String city;
    private String description;

}
