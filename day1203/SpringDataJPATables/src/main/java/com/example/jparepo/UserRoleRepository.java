package com.example.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tables.UserAccount;
import com.example.tables.UserRoles;

public interface UserRoleRepository extends JpaRepository<UserRoles, String>{

}
