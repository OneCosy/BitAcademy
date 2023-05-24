package com.bit.conf;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

// SQL 세션 관리
// JDBC가 해주는 역할을 대신 해줌
public class SqlSessionManager {
    // SqlSession : MyBatis 객체
    public static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "com/bit/conf/configuration.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);

            // MyBatis 객체를 생성해주는 공장
            // sqlSessionFactory = MyBatis 파서
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//staticBlock

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}

