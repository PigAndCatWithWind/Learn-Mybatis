import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.flower;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/25下午1:35
 * @描述
 */
public class main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream =
                Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        List<flower> list =
                sqlSession.selectList("mapper.flower.findAll");
        for (flower f:list
             ) {
            System.out.println(f.toString());
        }

        int all = sqlSession.selectOne("mapper.flower.AllNumber");
        System.out.println(all);

        Map<Object, Object> map = sqlSession.selectMap("mapper.flower.Map","name");
        System.out.println(map);
    }
}
