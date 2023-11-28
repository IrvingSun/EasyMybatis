package biz.dao;

/**
 * @author sunw
 * @date 2023/11/28
 */
public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
