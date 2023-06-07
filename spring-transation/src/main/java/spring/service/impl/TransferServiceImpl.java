package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.Dao.AccountDao;
import spring.service.BookService;
import spring.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(Integer userId1, Integer userId2, Integer money) {

        //查询用户1余额
        Integer balance1 = accountDao.getBalanceById1(userId1);
        //查询用户2余额
        Integer balance2 = accountDao.getBalanceById1(userId2);

        //更新用户余额
        accountDao.updateBalance(userId1,userId2,money);

    }

}
