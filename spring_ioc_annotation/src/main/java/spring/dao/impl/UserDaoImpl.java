package spring.dao.impl;

import org.springframework.stereotype.Repository;
import spring.dao.UserDao;


@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");

    }
}
