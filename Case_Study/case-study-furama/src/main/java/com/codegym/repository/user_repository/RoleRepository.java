package com.codegym.repository.user_repository;

import com.codegym.entities.user_entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select role_name from role\n" +
            "join user_role on role.role_id = user_role.role_id\n" +
            "join user on user_role.username = user.username\n" +
            "where user.username = ?1", nativeQuery = true)
     List<String> findAllRoleByUser(String username);
}
