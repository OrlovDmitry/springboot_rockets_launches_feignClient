package com.orlov.springboot_rockets_launches_feignclient.repository;

import com.orlov.springboot_rockets_launches_feignclient.entityRepo.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<Request,Integer> {
}
