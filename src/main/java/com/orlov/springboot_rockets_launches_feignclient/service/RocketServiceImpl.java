package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.RocketId;
import com.orlov.springboot_rockets_launches_feignclient.repository.RocketIdRepository;
import com.orlov.springboot_rockets_launches_feignclient.response.RocketIdResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RocketServiceImpl implements RocketService{

    @Autowired
    RocketIdRepository rocketIdRepository;

    @Autowired
    private RequestServiceImpl requestServiceImpl;

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
