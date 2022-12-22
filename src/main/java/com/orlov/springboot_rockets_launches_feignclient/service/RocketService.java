package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.RocketId;
import com.orlov.springboot_rockets_launches_feignclient.response.RocketIdResponseDto;

import java.util.List;

public interface RocketService {

    List<RocketId> addRocketsToRepo(List<RocketIdResponseDto> response);

    List<RocketIdResponseDto> getRocketIdList();

    List<RocketIdResponseDto> getRocketIdListFeign();
}
