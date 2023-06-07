package mybatis.mapper;

import mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分布查询员工以及部门所对应的信息的第二步
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查询部门以及部门中的员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 通过分布查询部门以及部门中的员工信息第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
