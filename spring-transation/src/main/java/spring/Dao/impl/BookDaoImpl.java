package spring.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.Dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据图书id查询价格
    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookId);
    }

    //更新图书的库存
    @Override
    public void updateStock(Integer bookId) {
        String sql = "update t_book set stock = stock -1 where book_id = ?";
        jdbcTemplate.update(sql,bookId);

    }

    //更新用户的余额
    @Override
    public void updateBalance(Integer userId, Integer price) {
        String sql = "update t_user2 set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql,price,userId);
    }
}
