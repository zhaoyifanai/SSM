package spring.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.Dao.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getBalanceById1(Integer userId1) {
        String sql = "select balance from t_user2 where user_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,userId1);
    }

    @Override
    public Integer getBalanceById2(Integer userId2) {
        String sql = "select balance from t_user2 where user_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,userId2);
    }

    @Override
    public void updateBalance(Integer userId1, Integer userId2, Integer money) {
        String sql1 = "update t_user2 set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql1,money,userId1);

        String sql2 = "update t_user2 set balance = balance + ? where user_id = ?";
        jdbcTemplate.update(sql2,money,userId2);
    }
}
