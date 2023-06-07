package spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.controller.AccountController;

//指定当前测试类在spring的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的Bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境的配置文件
@ContextConfiguration("classpath:tx-xml.xml")
public class AccountTest {

    @Autowired
    private AccountController accountController;

    @Test
    /**
     * 测试转账功能
     */
    public void testTransfer(){
        accountController.transfer(1,2,20);
    }




}
