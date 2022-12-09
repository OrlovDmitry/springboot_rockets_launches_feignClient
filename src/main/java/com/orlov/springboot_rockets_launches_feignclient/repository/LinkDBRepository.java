package com.orlov.springboot_rockets_launches_feignclient.repository;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LaunchesByRocketId;
import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LinkDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkDBRepository extends JpaRepository<LinkDB, Integer> {
}
