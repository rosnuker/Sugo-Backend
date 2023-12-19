package com.csit321g3.sugo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csit321g3.sugo.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByEmail(String email);

    long count();
}
