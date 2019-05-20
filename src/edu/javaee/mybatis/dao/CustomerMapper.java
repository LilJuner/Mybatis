package edu.javaee.mybatis.dao;

import edu.javaee.mybatis.entity.Customer;

public interface CustomerMapper {
    //与sql语句要完全对应
    public Customer findCustomerById(Integer id);

    /**
     * 根据客户id多表查询客户信息
     * @param id 客户id
     * @return 客户信息
     */
    public Customer findCustomersFullById(Integer id);
}
