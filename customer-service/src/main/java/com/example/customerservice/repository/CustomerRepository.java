package com.example.customerservice.repository;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNumberID(String numberID);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByRegion(Region region);
}
