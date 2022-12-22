package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesResponseDto;

import java.util.List;

public interface LaunchService {

    void saveToDB(List<LaunchesByRocketIdResponseDto> result, String rocketId);

    List<LaunchesByRocketIdResponseDto> filterLaunchesById(List<LaunchesResponseDto> response, String rocketId);
}
