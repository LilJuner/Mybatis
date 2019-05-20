package edu.javaee.mybatis;


import edu.javaee.mybatis.dao.CustomerMapper;
import edu.javaee.mybatis.entity.Customer;
import edu.javaee.mybatis.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Junit4Test {
    @Test
    public void findCustomerByIdTest() throws IOException {
        String path = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = sqlSession.selectOne("findCustomerById",1);

        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void findCustomerByNameTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Customer customer1 = new Customer();
        customer1.setUsername("");
        customer1.setJobs("医生");
        List<Customer> customers = sqlSession.selectList("findCustomerByNameAndJobs", customer1);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void addCustomerTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Customer customer1 = new Customer();
        customer1.setUsername("赵匡胤");
        customer1.setJobs("帝王");
        customer1.setId(5);

        sqlSession.update("addCustomer",customer1);

        System.out.println(customer1.getId());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateCustomerTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Customer customer1 = new Customer();
        customer1.setUsername("赵娜");
        customer1.setJobs("医生");

        sqlSession.insert("updateCustomer",customer1);

        System.out.println(customer1.getId());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteCustomerTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(7);
        ids.add(8);
        sqlSession.delete("deleteCustomer",ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findCustomerByIdMapperTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findCustomerById(1);
        System.out.println(customer);
    }

    @Test
    public void findCustomersFullByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findCustomersFullById(1);
        System.out.println(customer);
        sqlSession.close();
    }

}
