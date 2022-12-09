package com.orlov.springboot_rockets_launches_feignclient.entityRepo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlickrImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="flickr_image_id")
    private Integer flickrImageId;

    private String flickr_image;
}
