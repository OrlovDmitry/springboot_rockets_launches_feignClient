package com.orlov.springboot_rockets_launches_feignclient.serviceImpl;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.FlickrImage;
import com.orlov.springboot_rockets_launches_feignclient.repository.FlickrImagesRepository;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlickrImageServiceImpl {

    @Autowired
    FlickrImagesRepository flickrImagesRepository;

    // создание списка FlickrImage для каждого объекта LinkDB, назначение полей, сохранение в БД
    public List<FlickrImage> addFlickrImagesToRepo(LaunchesByRocketIdResponseDto launch){
        List<FlickrImage> flickrImageList = new ArrayList<FlickrImage> ();
        if (launch.getLinks ().getFlickr_images ()!=null) {   // если объекты FlickrImage имеются...
            for (String image : launch.getLinks ().getFlickr_images ()) {
                FlickrImage flickrImage = new FlickrImage ();
                flickrImage.setFlickr_image (image);
                flickrImageList.add (flickrImage);
                flickrImagesRepository.save (flickrImage);  // ...сохраняем их в БД
            }
//        } else {
//            flickrImagesRepository.save (null);  // если нет, сохраняем пустой объект
        }
        return flickrImageList;
    }


}
