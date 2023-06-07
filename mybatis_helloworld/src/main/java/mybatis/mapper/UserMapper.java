package mybatis.mapper;

import mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 实现添加功能的方法
     * @return
     */
    int insertUser();

    /**
     * 实现修改功能的方法
     */
    void updateUser();

    /**
     * 实现删除功能的方法
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     * @return
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();
}
