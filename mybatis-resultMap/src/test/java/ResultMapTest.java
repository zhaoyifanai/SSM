import mybatis.mapper.DeptMapper;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapTest {

    @Test
    /**
     * 根据id查询员工信息
     */
    public void testGetEmpByEmpId(){
        //获取sqlsession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //调用方法
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);
    }

    @Test
    /**
     * 获取员工以及部门所对应的信息
     */
    public void testGetEmpAndDeptByEmpId(){
        //获取sqlsession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //调用方法
        Emp emp = mapper.getEmpAndDeptByEmpId(1);
        System.out.println(emp);
    }

    @Test
    /**
     * 获取员工以及部门所对应的信息
     */

    public void testGetEmpAndDeptByStep(){
        //获取sqlsession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //调用方法
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp.getEmpName());
    }

    @Test
    /**
     * 查询部门以及部门中的员工信息
     */

    public void testGetDeptAndEmpByDeptId(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper的代理实现类对象
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        //调用方法
        Dept dept = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
    }

    @Test
    /**
     * 通过分布查询部门以及部门中的员工信息
     */

    public void testGetDeptAndEmpByStep(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper的代理实现类对象
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        //调用方法
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept.getDeptName());
    }
}
