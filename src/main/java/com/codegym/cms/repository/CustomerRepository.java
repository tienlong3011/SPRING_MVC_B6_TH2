package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;

import javax.persistence.*;

public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertWithStoredProcedure(Customer customer) {
//        String sql = "CALL Insert_Customer(:firstName, :lastName)";
//        Query query = entityManager.createNativeQuery(sql);
//        query.setParameter("firstName", customer.getFirstName());
//        query.setParameter("lastName", customer.getLastName());
//        return query.executeUpdate() == 0;

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Insert_Customer")
                .registerStoredProcedureParameter("first_name",String.class, ParameterMode.IN)
                .setParameter("first_name",customer.getFirstName())
                .registerStoredProcedureParameter("last_name",String.class,ParameterMode.IN)
                .setParameter("last_name",customer.getLastName());
        query.execute();

    }
}
