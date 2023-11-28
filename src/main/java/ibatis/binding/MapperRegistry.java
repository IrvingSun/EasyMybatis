package ibatis.binding;

import cn.hutool.core.lang.ClassScanner;
import ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 注册器  提供自动获取 MapperProxyFactory的能力
 * @author sunw
 * @date 2023/11/28
 */
public class MapperRegistry {
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap();

    /**
     * 从包路径下获取mapper接口，并注册成 MapperProxyFactory
     * 每个接口只允许存在一个MapperProxyFactory
     *
     * @param packageName
     */
    public void addMappersViaPackage(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for(Class<?> mapperClass : mapperSet){
            addMapper(mapperClass);
        }
    }

    private  <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            //重复添加校验
            if (hasMapper(type)) {
                throw new RuntimeException("Type " + type + " 重复注册.");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    private <T> boolean hasMapper(Class<T> type) {
        return Objects.nonNull(knownMappers.get(type));
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if(Objects.isNull(mapperProxyFactory)){
            throw new RuntimeException("Type " + type + " 未找到.");
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }
}
