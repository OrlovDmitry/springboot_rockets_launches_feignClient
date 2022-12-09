package com.orlov.springboot_rockets_launches_feignclient.entityRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rocket {

    @JsonProperty("rocket_id")
    private String rocketId;
}
