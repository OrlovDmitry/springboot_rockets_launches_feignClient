package com.orlov.springboot_rockets_launches_feignclient.serviceImpl;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LaunchesByRocketId;
import com.orlov.springboot_rockets_launches_feignclient.entityRepo.Request;
import com.orlov.springboot_rockets_launches_feignclient.entityRepo.RocketId;
import com.orlov.springboot_rockets_launches_feignclient.repository.RequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl {

    @Autowired
    RequestsRepository requestsRepository;

    // сохранение URI запроса на список ID ракет в БД
    public void addToRocketIdRequestRepo(List<RocketId> rocketIds){
        Request request = new Request ("/rockets");
        request.setRocketIdList (rocketIds);
        requestsRepository.save(request);
    }

    // сохранение URI запроса на получение определенных полей по конкретному ID ракеты в БД
    public void addToLaucnesRequestRepo(List<LaunchesByRocketId> launchesByRocketId, String rocketId){
        Request request = new Request (("/launches/rocketId/" + rocketId));
        request.setLaunchesByRocketId (launchesByRocketId);
        requestsRepository.save (request);
    }
}
