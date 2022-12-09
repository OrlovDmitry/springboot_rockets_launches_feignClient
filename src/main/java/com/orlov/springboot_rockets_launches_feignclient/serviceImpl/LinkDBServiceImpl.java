package com.orlov.springboot_rockets_launches_feignclient.serviceImpl;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LinkDB;
import com.orlov.springboot_rockets_launches_feignclient.repository.LinkDBRepository;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkDBServiceImpl {

    @Autowired
    private LinkDBRepository linkDBRepository;

    // создание объекта LinkDB, назначение полей
    public LinkDB createLinkDB(LaunchesByRocketIdResponseDto launch){
        LinkDB linkDB = new LinkDB ();
        linkDB.setMission_patch (launch.getLinks ().getMission_patch ());
        linkDB.setMission_patch_small (launch.getLinks ().getMission_patch_small ());
        linkDB.setReddit_campaign (launch.getLinks ().getReddit_campaign ());
        linkDB.setReddit_launch (launch.getLinks ().getReddit_launch ());
        linkDB.setReddit_recovery (launch.getLinks ().getReddit_recovery ());
        linkDB.setReddit_media (launch.getLinks ().getReddit_media ());
        linkDB.setPresskit (launch.getLinks ().getPresskit ());
        linkDB.setArticle_link (launch.getLinks ().getArticle_link ());
        linkDB.setWikipedia (launch.getLinks ().getWikipedia ());
        linkDB.setVideo_link (launch.getLinks ().getVideo_link ());
        linkDB.setYoutube_id (launch.getLinks ().getYoutube_id ());
        return linkDB;
    }
}
