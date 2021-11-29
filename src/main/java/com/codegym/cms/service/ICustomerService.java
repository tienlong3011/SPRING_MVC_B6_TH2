package com.codegym.cms.service;

import com.codegym.cms.model.Customer;

public interface ICustomerService {
    void insertWithStoredProcedure(Customer customer);
}
