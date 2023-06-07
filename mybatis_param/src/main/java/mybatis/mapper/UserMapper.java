package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * mybatis获取参数值的两种方式：#{} 和 ${}
 * ${}的本质就是字符串拼接，#{}的本质就是占位符赋值
 *
 * 1.若mapper接口中的方法参数为单个的字面量类型
 * 此时可以使用${}和#{}以任意的名称获取参数的值，注意${}需要手动加单引号
 *
 * 2.若mapper接口中的方法参数为多个时
 * 此时MyBatis会自动将这些参数放在一个map集合中，以两种方式存储
 * a>以arg0,arg1...为键，以参数为值；
 * b>以param1,param2...为键，以参数为值；
 * 因此只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号
 *
 * 3.若mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合，将这些数据放在map中
 * 只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号
 *
 * 4.若mapper接口中的方法参数为实体类对象时
 * 此时可以使用${}和#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
 *
 * 5.可以通过@Param注解标识mapper接口中的方法参数
 * 此时，会将这些参数放在map集合中，以两种方式进行存储
 * a>以@Param注解的value属性值为键，以参数为值；
 * b>以param1,param2...为键，以参数为值；
 * 只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号
 */

public interface UserMapper {

    /*MyBatis获取参数值的两种方式*/

    /**
     * 根据用户名来查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 验证登录（以map集合作为参数）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 添加用户信息
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录（使用@Param注解）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
