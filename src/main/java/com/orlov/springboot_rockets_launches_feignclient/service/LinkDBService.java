package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LinkDB;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;

public interface LinkDBService {

    LinkDB createLinkDB(LaunchesByRocketIdResponseDto launch);
}
