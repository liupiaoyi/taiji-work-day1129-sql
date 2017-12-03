package com.example.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tables.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String>{

}
