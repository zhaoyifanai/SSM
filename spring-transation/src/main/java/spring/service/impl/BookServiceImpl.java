package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.Dao.BookDao;
import spring.service.BookService;

import java.util.concurrent.TimeUnit;

@Service

public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    /*@Transactional(
            //readOnly = true
            //timeout = 3
            //noRollbackFor = ArithmeticException.class
            //isolation = Isolation.DEFAULT
            propagation = Propagation.REQUIRES_NEW
    )*/
    public void buyBook(Integer userId, Integer bookId) {
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书库存
        bookDao.updateStock(bookId);
        //更新用户余额
        bookDao.updateBalance(userId,price);
    }
}
