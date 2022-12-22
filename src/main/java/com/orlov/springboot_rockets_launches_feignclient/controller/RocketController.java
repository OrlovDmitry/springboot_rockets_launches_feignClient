package com.orlov.springboot_rockets_launches_feignclient.controller;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.*;
import com.orlov.springboot_rockets_launches_feignclient.exceptions.NoSuchRocketException;
import com.orlov.springboot_rockets_launches_feignclient.proxy.RocketLaunchProxy;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesResponseDto;
import com.orlov.springboot_rockets_launches_feignclient.response.RocketIdResponseDto;
import com.orlov.springboot_rockets_launches_feignclient.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/rockets")
public class RocketController {

    @Autowired
    private RocketServiceImpl rocketServiceImpl;

    @Autowired
    private RocketService rocketService;

    private Logger logger = LoggerFactory.getLogger (this.getClass ());

    // получение списка ID ракет
    @GetMapping("")
    public List<RocketIdResponseDto> getRocketIdList(){
        return rocketService.getRocketIdList();
    }
    @GetMapping("/Feign")
    public List<RocketIdResponseDto> getRocketIdListFeign(){
        return rocketService.getRocketIdListFeign();
    }

    // получение полей по конкретному ID ракеты


//    @GetMapping("/launches")
//    public LaunchesResponseDto[] getLaunchesList(){
//        ResponseEntity<LaunchesResponseDto[]> responseEntity = new RestTemplate ().getForEntity (
//                "https://api.spacexdata.com/v3/launches", LaunchesResponseDto[].class);
//        LaunchesResponseDto[] response = responseEntity.getBody ();
//        return response;
//    }
//
//    @GetMapping("/launches/rocketId/{rocketId}")
//    public List<LaunchesByRocketIdResponseDto> getLauncheByRocketIdList(@PathVariable String rocketId){
//        ResponseEntity<LaunchesResponseDto[]> responseEntity = new RestTemplate ().getForEntity (
//                "https://api.spacexdata.com/v3/launches", LaunchesResponseDto[].class);
//        List<LaunchesResponseDto> response = Arrays.asList(responseEntity.getBody ());
//        Iterator<LaunchesResponseDto> iterator = response.iterator ();      // чтобы можно было удалять элементы
//        while (iterator.hasNext ()){
//            LaunchesResponseDto res = iterator.next ();
//            if (!res.getRocket ().getRocketId ().equals (rocketId)){        // если rocketId отличается от нужного нам
//                iterator.remove ();                                      // элемент удаляется
//            }
//        }
//        return response;
//        List<LaunchesResponseDto> responseFiltered = new ArrayList<> ();
//        for (LaunchesResponseDto res:response) {
//            if (res.getRocket ().getRocketId ().equals (rocketId)) {
//                responseFiltered.add (res);
//            }
//        }
//        return responseFiltered;

//    @GetMapping("/infoAPI")
//    public InfoAPI getInfo() {
//        ResponseEntity<InfoAPI> responseEntity = new RestTemplate ().getForEntity (
//                "https://api.spacexdata.com/v3", InfoAPI.class);
//        InfoAPI response = responseEntity.getBody ();
//        return response;
//    }

//    @Autowired
//    RocketLaunchProxy proxy;
//
//    @GetMapping ("/rockets-feign")
//    public List<Long> getRocketIdList(){
//        RocketBean response =
//
//
//        return null;
//    }

}
