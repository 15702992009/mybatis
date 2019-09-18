package tk.mybatis.simple.mapper;


import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysUser;

public class Chapter7Test_p178 extends BaseMapperTest {
    @Test
    public void testL1Cache(){
        SqlSession sqlSession = getSqlSession();
        SysUser user1=null;
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user1 = userMapper.selectById(1l);
            user1.setUserName("New Name");
            SysUser user2 = userMapper.selectById(1L);
            Assert.assertEquals(user1,user2); //如果selectById()方法清空了一级缓存，则他们两个不相等，上面就会进行两次数据库得查询操作
        }finally {
            sqlSession.close();
        }
        //开启新的线程
        System.out.println("开启新的线程");
        sqlSession=getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user2 = userMapper.selectById(1l);
            Assert.assertNotEquals("New Name",user2.getUserName());
            Assert.assertNotEquals(user1,user2);
            userMapper.deleteUserById(2L);
            //
            SysUser user3 = userMapper.selectById(1L);
            Assert.assertNotEquals(user2,user3);
        }finally {
            sqlSession.close();
        }

    }
}
