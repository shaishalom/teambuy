package com.teambuy.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teambuy.demo.exception.RecordNotFoundException;
import com.teambuy.demo.model.BuyerEntity;
import com.teambuy.demo.service.BuyerService;
 
@RestController
@RequestMapping("/buyers")
public class BuyerController
{
    @Autowired
    BuyerService service;
 
    @GetMapping
    public ResponseEntity<List<BuyerEntity>> getAllEmployees() {
        List<BuyerEntity> list = service.getAllBuyers();
 
        return new ResponseEntity<List<BuyerEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<BuyerEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        BuyerEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<BuyerEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<BuyerEntity> createOrUpdateEmployee(BuyerEntity buyer)
                                                    throws RecordNotFoundException {
        BuyerEntity updated = service.createOrUpdateEmployee(buyer);
        return new ResponseEntity<BuyerEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteBuyerById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteBuyerById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}