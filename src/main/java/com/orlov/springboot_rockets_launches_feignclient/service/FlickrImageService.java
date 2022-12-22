package com.orlov.springboot_rockets_launches_feignclient.service;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.FlickrImage;
import com.orlov.springboot_rockets_launches_feignclient.response.LaunchesByRocketIdResponseDto;

import java.util.List;

public interface FlickrImageService {

    List<FlickrImage> addFlickrImagesToRepo(LaunchesByRocketIdResponseDto launch);
}
