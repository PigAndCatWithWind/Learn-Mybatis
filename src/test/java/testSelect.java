//import mapperInfo.flowerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.flower;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/3/7上午10:43
 * @描述
 */
public class testSelect {
    InputStream inputStream =
            Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory factory =
            new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = factory.openSession();

    public testSelect() throws IOException {
    }
    @Test
    public void test01(){
        sqlSession.selectOne("mapper.flower.findById",2);
    }
    @Test
    public void test02(){
        flower f = new flower();
        f.setId(1);
        f.setPrice(6.2f);
        sqlSession.selectOne("mapper.flower.findByObj",f);
    }
    @Test
    public void test03(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flowerId",3);
        sqlSession.selectOne("mapper.flower.findByMap",map);
    }
    @Test
    public void test04(){
        sqlSession.selectList("mapper.flower.findBytest",2);
    }
    @Test
    public void test05(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageStart",1);
        map.put("pageSize",2);
        sqlSession.selectList("mapper.flower.page",map);
    }
    @Test
    public void test06(){
        flower flower = new flower();
        flower.setName("flower");
        flower.setPrice(0.9f);
        flower.setProduction("xi'an");
        int insert = sqlSession.insert("mapper.flower.insertOne",flower);
        if (insert>0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
    }
//    @Test
//    public void test07(){
//
//        flowerMapper flowerMapper = sqlSession.getMapper(flowerMapper.class);
//        List<flower> list = flowerMapper.selectAll();
//        for (flower f:
//             list) {
//            System.out.println(f.toString());
//        }
//    }
    @Test
    public void test08(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","");
        sqlSession.selectList("mapper.flower.userIf",map);
    }
    @Test
    public void test09(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","name");
        sqlSession.selectList("mapper.flower.userWhere",map);
    }
    @Test
    public void test10(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","name");
        map.put("price",0.6f);
        sqlSession.selectList("mapper.flower.userChoose",map);
    }
    @Test
    public void test11(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("price",0.6f);
        map.put("id",1);
        int index = sqlSession.update("mapper.flower.updateFlower",map);
        if (index>0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
    }
    @Test
    public void test12(){
        flower flower = new flower();
        flower.setName("flower");
        flower.setPrice(0.9f);
        flower.setProduction("xi'an");
        flower.setId(3);
        int index = sqlSession.update("mapper.flower.userTrim",flower);
//        if (index)
    }

}
