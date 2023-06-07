package mybatis.test;


import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    /**
     * 测试添加用户功能
     */
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession(不会自动提交事务),是MyBatis提供操作数据库的对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取sql的会话对象SqlSession(会自动提交事务),是MyBatis提供操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();

        /*//通过sql语句的唯一标识找到sql并执行  唯一标识：namespace.sqlId
        int result = sqlSession.insert("mybatis.mapper.UserMapper.insertUser");*/
        System.out.println("结果：" + result);
        //提交事务
        //sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();




    }

    @Test
    /**
     * 测试修改用户功能
     */
    public void testUpdate(){
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        mapper.updateUser();
        //关闭sqlSession
        sqlSession.close();

    }

    @Test
    /**
     *
     */
    public void testDelete(){
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        mapper.deleteUser();
        //关闭sqlSession
        sqlSession.close();

    }

    @Test
    /**
     * 测试查询用户功能
     */
    public void testGetUserById(){
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    /**
     * 测试查询所有的用户功能
     */
    public void testGetAllUser(){
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<User> list = mapper.getAllUser();
        //循环遍历
        list.forEach(System.out::println);
    }

}
