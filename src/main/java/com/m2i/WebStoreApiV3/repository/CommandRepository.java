package com.m2i.WebStoreApiV3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreApiV3.entity.Command;

public interface CommandRepository extends JpaRepository<Command, Integer>{

}
