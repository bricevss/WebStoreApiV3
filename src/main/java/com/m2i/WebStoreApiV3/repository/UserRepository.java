package com.m2i.WebStoreApiV3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreApiV3.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{}