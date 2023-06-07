package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    //@Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
