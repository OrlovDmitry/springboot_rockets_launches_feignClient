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
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String request;

    @OneToMany
    @JoinColumn(name="request_rocket_id")
    private List<RocketId> rocketIdList;

    @OneToMany
    @JoinColumn(name="request_launches_rocket_id")
    private List<LaunchesByRocketId> launchesByRocketId;

    public Request(String request) {
        this.request = request;
    }
}
