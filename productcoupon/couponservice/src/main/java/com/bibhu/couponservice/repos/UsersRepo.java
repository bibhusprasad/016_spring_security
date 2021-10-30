package com.bibhu.couponservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibhu.couponservice.model.Users;

public interface UsersRepo extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
