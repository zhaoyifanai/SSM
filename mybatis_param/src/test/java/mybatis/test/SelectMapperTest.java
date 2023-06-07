package mybatis.test;

import mybatis.mapper.SelectMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    /**
     * 根据id查询用户信息
     */
    public void testGetUserById(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //调用方法
        User user = mapper.getUserById(2);
        System.out.println(user);

    }

    @Test
    /**
     * 查询所有的用户信息
     */
    public void testGetAllUser(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //调用方法
        List<User> list = mapper.getAllUser();
        //循环遍历
        list.forEach(System.out::println);


    }

    @Test
    /**
     * 查询用户的总数量
     */
    public void testGetCount(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //调用方法
        Integer count = mapper.getCount();
        System.out.println(count);


    }

    @Test
    /**
     * 根据id查询用户信息为map集合
     */
    public void testGetUserByIdToMap(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //调用方法
        Map<String, Object> map = mapper.getUserByIdToMap(3);
        System.out.println(map);
    }

    @Test
    /**
     * 查询所有的用户信息为map集合
     */
    public void testGetAllUserToMap(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //调用方法
       /* List<Map<String, Object>> list = mapper.getAllUserToMap();
        //循环遍历
        list.forEach(System.out::println);*/
        Map<String, Object> map = mapper.getAllUserToMap();
        //遍历
        /*for (String key : map.keySet()) {
            Object value = map.get(key);
            System.out.println(key + ":" + value);
        }*/
        System.out.println(map);
    }
}
