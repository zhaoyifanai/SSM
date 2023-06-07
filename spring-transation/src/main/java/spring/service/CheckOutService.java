package spring.service;

public interface CheckOutService {
    /**
     * 结账 买多本书
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
