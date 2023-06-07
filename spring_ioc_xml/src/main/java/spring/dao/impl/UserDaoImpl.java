package spring.dao.impl;

import spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
