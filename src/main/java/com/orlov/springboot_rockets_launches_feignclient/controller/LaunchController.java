package com.orlov.springboot_rockets_launches_feignclient.controller;

import com.orlov.springboot_rockets_launches_feignclient.exceptions.NoSuchRocketException;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesResponseDto;
import com.orlov.springboot_rockets_launches_feignclient.service.LaunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/launches")
public class LaunchController {

    @Autowired
    private LaunchService launchService;

    @GetMapping("/{rocketId}")
    public List<LaunchesByRocketIdResponseDto> getLaunchesByRocketIdList(@PathVariable String rocketId) throws NoSuchRocketException {
        return launchService.getLaunchesByRocketIdList (rocketId);
    }
}
