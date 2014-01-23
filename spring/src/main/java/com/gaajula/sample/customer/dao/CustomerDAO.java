package com.gaajula.sample.customer.dao;

import com.gaajula.sample.customer.model.Customer;


public interface CustomerDAO {
    public void insert(Customer customer);

    public Customer findByCustomerId(int custId);
}
