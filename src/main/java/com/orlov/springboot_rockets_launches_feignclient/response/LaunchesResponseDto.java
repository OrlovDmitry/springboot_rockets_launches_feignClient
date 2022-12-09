package com.orlov.springboot_rockets_launches_feignclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LinkDB;
import com.orlov.springboot_rockets_launches_feignclient.entityRequest.Link;
import com.orlov.springboot_rockets_launches_feignclient.entityRequest.Rocket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaunchesResponseDto {

    private Rocket rocket;

    @JsonProperty("mission_name")
    private String missionName;

    @JsonProperty("launch_year")
    private String launchYear;

    private Link links;
}
