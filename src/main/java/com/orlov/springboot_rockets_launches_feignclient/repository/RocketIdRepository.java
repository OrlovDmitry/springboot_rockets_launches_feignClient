package com.orlov.springboot_rockets_launches_feignclient.repository;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.RocketId;
import com.orlov.springboot_rockets_launches_feignclient.response.RocketIdResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RocketIdRepository extends JpaRepository<RocketId, Integer> {
}
