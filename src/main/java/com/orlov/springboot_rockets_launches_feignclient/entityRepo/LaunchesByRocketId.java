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
public class LaunchesByRocketId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="request_launches_rocket_id")
    private Integer requestId;

    @Column(name="mission_name")
    private String missionName;

    @Column(name="launch_year")
    private String launchYear;

    @OneToOne
    @JoinColumn(name="link_id")
    private LinkDB linkDB;
}
