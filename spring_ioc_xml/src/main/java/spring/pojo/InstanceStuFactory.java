package spring.pojo;

import java.util.HashMap;
import java.util.Map;

public class InstanceStuFactory {

    private Map<String,Student> student = null;
    public InstanceStuFactory(){
        student = new HashMap<String,Student>();
        student.put("student1",new Student(1001,"张三","男",23));
        student.put("student2",new Student(1002,"李四","女",18));
        student.put("student3",new Student(1003,"王五","男",24));
    }

    public Student getStudent(String name){
        return student.get(name);
    }
}
