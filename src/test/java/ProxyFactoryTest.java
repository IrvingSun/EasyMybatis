import biz.dao.ISchoolDao;
import ibatis.binding.MapperRegistry;
import ibatis.session.DefaultSqlSessionFactory;
import ibatis.session.SqlSession;
import ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import biz.dao.IUserDao;

/**
 * @author sunw
 * @date 2023/11/28
 */
//@SpringBootTest
public class ProxyFactoryTest {

    @Test
    public void testMapperProxyFactory() {
        MapperRegistry registry = new MapperRegistry();
        registry.addMappersViaPackage("biz.dao");

        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.retrieveMapper(IUserDao.class);

        String res = userDao.queryUserName("111");
        System.out.println("测试结果：" + res);

        ISchoolDao schoolDao = sqlSession.retrieveMapper(ISchoolDao.class);
        String schoolRes = schoolDao.querySchoolName("222");
        System.out.println("测试结果：" + schoolRes);
    }
}
