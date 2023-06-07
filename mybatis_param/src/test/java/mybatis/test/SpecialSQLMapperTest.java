package mybatis.test;

import mybatis.mapper.SelectMapper;
import mybatis.mapper.SpecialSQLMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class SpecialSQLMapperTest {

    @Test
    /**
     * 通过用户名模糊查询用户信息
     */
    public void testGetUserByLike(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        //调用方法
        List<User> list = mapper.getUserByLike("a");
        //循环遍历
        list.forEach(System.out::println);
    }

    @Test
    public void testJDBC(){

        try {
            //注册驱动
            Class.forName("");
            //获取连接
            Connection connection = DriverManager.getConnection("","","");
            /*//定义sql语句
            String sql = "select * from t_user where username like '%?%'";
            //预编译对象
            PreparedStatement ps = connection.prepareStatement(sql);
            //set方法为占位符赋值
            //ps.setString(1,"a");*/

            String sql = "insert into t_user values()";
            //Statement.RETURN_GENERATED_KEYS = 1 默认获取自增的主键
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            //获取自增的主键
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 批量删除
     */
    public void testDeleteMoreUser(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        //调用方法
        mapper.deleteMoreUser("9,10");
    }
    @Test
    /**
     * 动态设置表名，查询用户信息
     */
    public void testGetUserList(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        //调用方法
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }

    @Test
    /**
     * 动态设置表名，查询用户信息
     */
    public void testInsertUser(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper代理实现类对象
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null,"xaioming","121322",23,"男","1234@qq.com");
        //调用方法
        mapper.insertUser(user);
        //输出结果
        System.out.println(user);
    }


}
