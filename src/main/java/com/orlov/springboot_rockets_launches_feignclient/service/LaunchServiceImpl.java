package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.FlickrImage;
import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LaunchesByRocketId;
import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LinkDB;
import com.orlov.springboot_rockets_launches_feignclient.exceptions.NoSuchRocketException;
import com.orlov.springboot_rockets_launches_feignclient.repository.FlickrImagesRepository;
import com.orlov.springboot_rockets_launches_feignclient.repository.LaucnhesByRocketIdRepository;
import com.orlov.springboot_rockets_launches_feignclient.repository.LinkDBRepository;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaunchServiceImpl implements LaunchService {

    @Autowired
    private RequestServiceImpl requestServiceImpl;

    @Autowired
    private FlickrImageServiceImpl flickrImageService;

    @Autowired
    private LinkDBServiceImpl linkDBService;

    @Autowired
    LaucnhesByRocketIdRepository laucnhesByRocketIdRepository;

    @Autowired
    LinkDBRepository linkDBRepository;

    @Autowired
    FlickrImagesRepository flickrImagesRepository;

    @Override
    public List<LaunchesByRocketIdResponseDto> getLaunchesByRocketIdList(String rocketId) throws NoSuchRocketException {
        ResponseEntity<LaunchesResponseDto[]> responseEntity = new RestTemplate ().getForEntity (
                "https://api.spacexdata.com/v3/launches", LaunchesResponseDto[].class);
        List<LaunchesResponseDto> response = Arrays.asList(responseEntity.getBody ());
        List<LaunchesByRocketIdResponseDto> result = filterLaunchesById (response,rocketId);  // фильтр для ответа
        if (result.isEmpty ()){
            throw new NoSuchRocketException ();
        }
        saveToDB(result, rocketId);   // сохранение в БД
        return result;
    }

    public void saveToDB(List<LaunchesByRocketIdResponseDto> result, String rocketId) {
        List<LaunchesByRocketId> launchesByRocketId = new ArrayList<> ();
        for (LaunchesByRocketIdResponseDto launch:result){      // проходимся по всему что получили по REST-запросу после фильтра
            // сохраняем в БД объекты, начиная с самого нижнего уровня Flickr->LinkDB->LaunchByRocketId->Request
            List<FlickrImage> flickrImageList = flickrImageService.addFlickrImagesToRepo (launch);    // добавляем картинки
            LinkDB linkDB = linkDBService.createLinkDB (launch);    // создаем LinkDB
            linkDB.setFlickrImageList (flickrImageList);    // сетаем FlickrImage в LinkDB
            linkDBRepository.save (linkDB);     // сохраняем LinkDB в БД
            var launchByRocketId = createLaunch (launch);   //создаем LaunchByRocketId
            launchByRocketId.setLinkDB (linkDB);    // сетаем LinkDB в LaunchByRocketId
            laucnhesByRocketIdRepository.save (launchByRocketId);   // сохраняем LaunchByRocketId в БД
            launchesByRocketId.add (launchByRocketId);  // сохраняем LaunchByRocketId в List<LaunchByRocketId>
        }
        requestServiceImpl.addToLaucnesRequestRepo (launchesByRocketId,rocketId);   // сохраняем Request в БД
    }
    // метод-фильтр по ID ракеты, который так мапит только нужные поля
    public List<LaunchesByRocketIdResponseDto> filterLaunchesById(List<LaunchesResponseDto> response, String rocketId){
        return response.stream ()
                .filter (x -> x.getRocket ().getRocketId ().equals (rocketId))
                .map (launchesResponseDto -> {
                    return getLaunchesByRocketIdResponseDto (launchesResponseDto);
                })
                .collect(Collectors.toList());
    }

    // создание объекта LaunchesByRocketId, назначение полей
    private LaunchesByRocketId createLaunch(LaunchesByRocketIdResponseDto launch){
        var launchesByRocketId = new LaunchesByRocketId ();
        launchesByRocketId.setLaunchYear (launch.getLaunchYear ());
        launchesByRocketId.setMissionName (launch.getMissionName ());
        return launchesByRocketId;
    }
    // логика стрима, из LaunchesResponseDto --> LaunchesByRocketIdResponseDto (мапинг только нужных полей)
    private LaunchesByRocketIdResponseDto getLaunchesByRocketIdResponseDto(LaunchesResponseDto launchesResponseDto) {
        var launchesByRocketIdResponseDto = new LaunchesByRocketIdResponseDto ();
        launchesByRocketIdResponseDto.setLaunchYear (launchesResponseDto.getLaunchYear ());
        launchesByRocketIdResponseDto.setLinks (launchesResponseDto.getLinks ());
        launchesByRocketIdResponseDto.setMissionName (launchesResponseDto.getMissionName ());
        return launchesByRocketIdResponseDto;
    }

}
