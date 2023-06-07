package spring.Dao;

public interface AccountDao {

    /**
     * 查询用户1余额
     * @param userId1
     * @return
     */
    Integer getBalanceById1(Integer userId1);

    /**
     * 查询用户2余额
     * @param userId2
     * @return
     */
    Integer getBalanceById2(Integer userId2);


    /**
     * 更新账户余额
     * @param userId1
     * @param userId2
     * @param money
     */
    void updateBalance(Integer userId1, Integer userId2, Integer money);
}
