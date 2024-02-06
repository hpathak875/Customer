package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CustomerEntity;

public interface CustomerDAO extends JpaRepository<CustomerEntity,Integer>{

}
