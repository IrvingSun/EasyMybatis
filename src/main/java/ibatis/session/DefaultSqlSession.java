package ibatis.session;

import ibatis.binding.MapperRegistry;

/**
 * @author sunw
 * @date 2023/11/28
 */
public class DefaultSqlSession implements SqlSession{

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + "方法：" + statement );
    }

    @Override
    public <T> T selectOne(String statement, Object param) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + param);
    }

    @Override
    public <T> T retrieveMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
