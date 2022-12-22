package com.orlov.springboot_rockets_launches_feignclient.proxy;

import com.orlov.springboot_rockets_launches_feignclient.response.RocketIdResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient (name="rocket-spy", url="https://api.spacexdata.com")
public interface RocketLaunchProxy {

    @GetMapping("/v3/rockets")
    public List<RocketIdResponseDto> getRocketIdList();
}
