package com.example.customerservice.service;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.entity.Region;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerAll();
    List<Customer> findCustomersByRegion(Region region);

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
    Customer getCustomer(Long id);
}
