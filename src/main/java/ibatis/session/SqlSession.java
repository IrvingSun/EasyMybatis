package ibatis.session;

/**
 * SqlSession标准定义
 * 执行SQL、获取映射器以及事务管理等标准接口
 * @author sunw
 * @date 2023/11/28
 */
public interface SqlSession {
    /**
     * 根据指定的sql获取一条记录
     * @param statement
     * @param <T>
     * @return
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的sql获取一条记录 允许传递参数 pojo,Map等
     * @param statement
     * @param param
     * @param <T>
     * @return
     */
    <T> T selectOne(String statement, Object param);

    /**
     * 获取映射器 使用泛型 使得类型安全
     * @param type
     * @param <T>
     * @return
     */
    <T> T retrieveMapper(Class<T> type);
}
