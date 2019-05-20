package edu.javaee.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

public class MybatisUtils {

    public static SqlSessionFactory sqlSessionFactory = null;

    static {
        try{
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);


        }
        catch (IOException e){

        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


}
