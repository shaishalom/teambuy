package com.teambuy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teambuy.demo.model.BuyerEntity;
import com.teambuy.demo.model.EmployeeEntity;
 
@Repository
public interface BuyerRepository
        extends JpaRepository<BuyerEntity, Long> {
 
}
