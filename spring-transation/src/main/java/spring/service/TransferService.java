package spring.service;

public interface TransferService {
    /**
     * 转账
     * @param userId1
     * @param userId2
     * @param money
     */
    void transfer(Integer userId1, Integer userId2, Integer money);
}
