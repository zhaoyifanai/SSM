package mybatis.test;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {

    @Test
    /**
     * mapper接口中的方法参数为单个的字面量类型
     */
    public void testGetUserByUsername(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    /**
     * mapper接口中的方法参数为多个时
     */
    public void testCheckLogin(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    /**
     * mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合
     */
    public void testCheckLoginByMap(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //创建map集合
        Map<String ,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        //调用方法
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    /**
     * mapper接口中的方法参数为实体类对象时
     */
    public void testInsertUser(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //新建一个user对象
        User user = new User(null,"root","123456",34,"女","123@qq.com");
        //调用方法
        mapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    /**
     * 通过@Param注解标识mapper接口中的方法参数
     */
    public void testCheckLoginByParam(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }




}
