package ibatis.session;

import ibatis.binding.MapperRegistry;

/**
 * @author sunw
 * @date 2023/11/28
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
