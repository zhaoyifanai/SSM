package mybatis.test;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.pojo.EmpExample;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    /**
     * 测试功能
     */
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据id查询数据库
        //selectByPrimaryKey
        /*Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);*/
        //查询所有数据
        //selectByExample
        /*List<Emp> list = mapper.selectByExample(null);
        list.forEach(System.out::println);*/
        //根据条件来查询
        //example.createCriteria().andEmpNameEqualTo
        /*EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        example.or().andGenderEqualTo("男");
        List<Emp> list = mapper.selectByExample(example);
        list.forEach(System.out::println);*/
        //测试普通修改功能
        //updateByPrimaryKey
        Emp emp = new Emp(3,"李玉",null,"女");
        //mapper.updateByPrimaryKey(emp);
        //测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);

    }
}
