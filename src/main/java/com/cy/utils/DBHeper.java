package com.cy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class DBHeper {
    private  static DBHeper dbHeper=null;
    private SqlSession sqlSession=null;
    private DBHeper(){

    }
    public static DBHeper getInstance(){

        if(dbHeper==null){
            dbHeper = new DBHeper();
        }
        return dbHeper;
    }

    public SqlSession getSqlSession(){

        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            String fpath= "mybatis-config.xml";
            SqlSessionFactory sqlSessionFactory = null;
            try {
                sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream(fpath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSession =sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }



}
