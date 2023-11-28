package ibatis.session;

/**
 * @author sunw
 * @date 2023/11/28
 */
public interface SqlSessionFactory {

    /**
     * 打开一个session
     * @return
     */
    SqlSession openSession();
}
