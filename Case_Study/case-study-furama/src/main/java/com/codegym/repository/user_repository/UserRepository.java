package com.codegym.repository.user_repository;

import com.codegym.entities.user_entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUserName(String userName);
}
