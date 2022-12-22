package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LaunchesByRocketId;
import com.orlov.springboot_rockets_launches_feignclient.entityRepo.RocketId;

import java.util.List;

public interface RequestService {

    void addToRocketIdRequestRepo(List<RocketId> rocketIds);

    void addToLaucnesRequestRepo(List<LaunchesByRocketId> launchesByRocketId, String rocketId);
}
