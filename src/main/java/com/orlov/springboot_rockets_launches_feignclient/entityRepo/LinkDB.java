package com.orlov.springboot_rockets_launches_feignclient.entityRepo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LinkDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mission_patch;
    private String mission_patch_small;
    private String reddit_campaign;
    private String reddit_launch;
    private String reddit_recovery;
    private String reddit_media;
    private String presskit;
    private String article_link;
    private String wikipedia;
    private String video_link;
    private String youtube_id;

    @OneToMany
    @JoinColumn(name="link_id")
    private List<FlickrImage> flickrImageList;
}
