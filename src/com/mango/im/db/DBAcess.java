package com.mango.im.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Author：Mango Cheng
 * Date：2020/5/26
 * Time：7:45
 * Description：数据库访问
 */
public class DBAcess {

    public SqlSession getSqlSession() throws IOException {
        // 1.通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("com/mango/im/config/Configuration.xml");
        // 2.构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 3.通过SqlSessionFactory打开数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

}
