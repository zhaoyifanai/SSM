package spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student {

    private Integer sid;
    private String sname;
    private Integer age;
    private String gender;
    private Double score;

    private String[] hobbies;

    private Clazz clazz;

    private Map<String,Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer sid, String sname, String gender, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
    }

    public Student(Integer sid, String sname, String gender, Double score) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                /*", score=" + score +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", clazz=" + clazz +
                ", teacherMap=" + teacherMap +*/
                '}';
    }
}
