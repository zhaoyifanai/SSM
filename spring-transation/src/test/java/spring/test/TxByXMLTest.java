package spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.controller.BookController;

/**
 * 声明式事务的配置步骤：
 * 1.在Spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 * 3.处理事务一般在service层处理
 * 在BookServiceImpl的buybook()添加注解@Transactional
 *
 * @Transactional注解标识的位置
 * 1.标识在方法上，只会影响该方法
 * 2.标识在类上，会影响类中所有的方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
        //bookController.checkout(1,new Integer[]{1,2});
    }

}
