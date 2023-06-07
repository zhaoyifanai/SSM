package springmvc.controller;

/*
*
| **功能**            | **URL** **地址** | **请求方式** |
| ------------------ | ---------------- | ------------ |
| 访问首页√           | /                | GET          |
| 查询全部数据√        | /employee        | GET          |
| 删除√              | /employee/2      | DELETE       |
| 跳转到添加数据页面√   | /toAdd           | GET          |
| 执行保存√           | /employee        | POST         |
| 跳转到更新数据页面√   | /employee/2      | GET          |
| 执行更新√           | /employee        | PUT          |
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.dao.EmployeeDao;
import springmvc.pojo.Employee;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //获取所有的员工信息
        Collection<Employee> allemployee = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allemployee",allemployee);
        //跳转到列表页面
        return "employee_list";

    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        //根据id查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工信息共享到请求域中
        model.addAttribute("employee",employee);
        //跳转到employee_update.html
        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        //修改员工信息
        employeeDao.save(employee);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        //删除员工信息
        employeeDao.delete(id);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

}
