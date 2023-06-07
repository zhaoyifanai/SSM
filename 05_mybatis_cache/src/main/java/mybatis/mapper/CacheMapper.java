package mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import mybatis.pojo.Emp;

public interface CacheMapper {

    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * 添加员工信息
     * @param emp
     */
    void insertEmp(Emp emp);

}
