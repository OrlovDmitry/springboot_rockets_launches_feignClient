package com.orlov.springboot_rockets_launches_feignclient.repository;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.LaunchesByRocketId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaucnhesByRocketIdRepository extends JpaRepository<LaunchesByRocketId, Integer> {
}
