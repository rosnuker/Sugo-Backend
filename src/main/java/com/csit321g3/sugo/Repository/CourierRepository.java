package com.csit321g3.sugo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csit321g3.sugo.Entity.CourierEntity;

@Repository
public interface CourierRepository extends JpaRepository<CourierEntity, Long>{
    CourierEntity findByEmail(String email);
}
