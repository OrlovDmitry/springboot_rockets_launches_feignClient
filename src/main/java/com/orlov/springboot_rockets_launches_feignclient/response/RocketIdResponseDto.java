package com.orlov.springboot_rockets_launches_feignclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RocketIdResponseDto {

    @JsonProperty("rocket_id")
    private String rocketId;
}
