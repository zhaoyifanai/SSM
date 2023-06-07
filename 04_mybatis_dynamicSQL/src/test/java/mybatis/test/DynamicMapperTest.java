package mybatis.test;

import mybatis.mapper.DynamicSQLMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DynamicMapperTest {

    @Test
    /**
     * 根据条件查询员工信息
     */
    public void testGetEmpByCondition(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper实现代理类对象
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //创建emp对象
        Emp emp = new Emp(null,"",20,"");
        //调用方法
        List<Emp> list = mapper.getEmpByCondition(emp);
        //遍历循环
        list.forEach(System.out::println);
    }

    @Test
    /**
     * 使用Choose查询员工信息
     */
    public void testGetEmpByChoose(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper实现代理类对象
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //创建emp对象
        Emp emp = new Emp(null,"张三",20,"");
        //调用方法
        List<Emp> list = mapper.getEmpByChoose(emp);
        //遍历循环
        list.forEach(System.out::println);
    }

    @Test
    /**
     * 批量添加员工信息
     */
    public void testInsertMoreEmp(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper实现代理类对象
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //创建emp对象
        Emp emp1 = new Emp(null,"小玉",24,"女");
        Emp emp2 = new Emp(null,"小王",22,"男");
        Emp emp3 = new Emp(null,"小明",23,"男");
        //创建list集合添加Emp
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        //调用方法
        mapper.insertMoreEmp(list
        );
    }

    @Test
    /**
     * 批量删除员工信息
     */
    public void testDeleteMoreEmp(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper实现代理类对象
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //创建Integer数组
        Integer[] empIds = new Integer[]{5};
        //调用方法
        mapper.deleteMoreEmp(empIds);
    }
}
