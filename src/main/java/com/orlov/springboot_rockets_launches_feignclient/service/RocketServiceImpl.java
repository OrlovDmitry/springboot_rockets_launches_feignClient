package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.RocketId;
import com.orlov.springboot_rockets_launches_feignclient.proxy.RocketLaunchProxy;
import com.orlov.springboot_rockets_launches_feignclient.repository.RocketIdRepository;
import com.orlov.springboot_rockets_launches_feignclient.response.RocketIdResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RocketServiceImpl implements RocketService{

    @Autowired
    RocketIdRepository rocketIdRepository;

    @Autowired
    private RequestServiceImpl requestServiceImpl;

    @Autowired
    private RocketLaunchProxy proxy;
    @Override
    public List<RocketIdResponseDto> getRocketIdList() {
        ResponseEntity<RocketIdResponseDto[]> responseEntity = new RestTemplate ().getForEntity (
                "https://api.spacexdata.com/v3/rockets", RocketIdResponseDto[].class);
        List<RocketIdResponseDto> response = Arrays.asList (responseEntity.getBody ());
        List<RocketId> rocketIds = addRocketsToRepo (response);   // сохранение списка ID ракет в БД
        return response;
    }

    @Override
    public List<RocketIdResponseDto> getRocketIdListFeign() {
        List<RocketIdResponseDto> response = proxy.getRocketIdList ();
        List<RocketId> rocketIds = addRocketsToRepo (response);   // сохранение списка ID ракет в БД
        return response;
    }

    // получение списка ID ракет, назначение RocketId полей, сохранение в БД
    public List<RocketId> addRocketsToRepo(List<RocketIdResponseDto> response){
        List<RocketId> rocketIds = new ArrayList<> ();
        for (RocketIdResponseDto res:response){
            RocketId rocketId = new RocketId ();    // Пришлось создавать класс RocketId, чтобы включить в него id запроса
            rocketId.setRocketId (res.getRocketId ());
            rocketIdRepository.save (rocketId);
            rocketIds.add (rocketId);
        }
        requestServiceImpl.addToRocketIdRequestRepo (rocketIds);    // вызов метода на сохранение запроса в БД
        return rocketIds;
    }

}
