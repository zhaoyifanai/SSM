package spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.pojo.Account;
import spring.pojo.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class AccountJDBCTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    /**
     * 测试修改功能
     */
    public void testupdateAccount(){
        String sql = "insert into t_user2 values(null,?,?)";
        jdbcTemplate.update(sql,"zhaowu",400);
    }

    @Test
    /**
     * 测试添加功能
     */
    public void testInsertAccount(){
        String sql = "update t_user2 set balance = ? where user_id = ?";
        jdbcTemplate.update(sql,300,4);
    }

    @Test
    /**
     * 测试删除功能
     */
    public void testDeleteAccount(){
        String sql = "delete from t_user2 where user_id = ?";
        jdbcTemplate.update(sql,4);
    }

    @Test
    /**
     * 测试查询功能(一条数据)
     */
    public void findAccountById(){
        String sql = "select * from t_user2 where user_id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), 1);
        System.out.println(account);

    }

    @Test
    /**
     * 查询多条数据
     */
    public void findAllAccount(){
        String sql = "select * from t_user2";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        list.forEach(System.out::println);
    }
}
