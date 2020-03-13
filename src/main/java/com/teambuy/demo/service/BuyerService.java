package com.teambuy.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teambuy.demo.exception.RecordNotFoundException;
import com.teambuy.demo.model.BuyerEntity;
import com.teambuy.demo.repository.BuyerRepository;

 
@Service
public class BuyerService {
     
    @Autowired
    BuyerRepository repository;
     
    public List<BuyerEntity> getAllBuyers()
    {
        List<BuyerEntity> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<BuyerEntity>();
        }
    }
     
    public BuyerEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<BuyerEntity> buyer = repository.findById(id);
         
        if(buyer.isPresent()) {
            return buyer.get();
        } else {
            throw new RecordNotFoundException("No buyer record exist for given id");
        }
    }
     
    public BuyerEntity createOrUpdateEmployee(BuyerEntity entity) throws RecordNotFoundException
    {
        Optional<BuyerEntity> buyer = repository.findById(entity.getId());
         
        if(buyer.isPresent())
        {
            BuyerEntity newEntity = buyer.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteBuyerById(Long id) throws RecordNotFoundException
    {
        Optional<BuyerEntity> buyer = repository.findById(id);
         
        if(buyer.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No buyer record exist for given id");
        }
    }
}