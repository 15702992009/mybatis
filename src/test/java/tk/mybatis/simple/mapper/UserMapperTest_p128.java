package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysUser;


public class UserMapperTest_p128 extends  BaseMapperTest{
    @Test
    public void testSelectUserAndROleById(){
        //获取SQLSession
        SqlSession sqlSession=getSqlSession();
        try{
            //获取UseMapper接口
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            SysUser user= userMapper.selectUserAndRoleById2(1001L);
        //    System.out.println(user);
            Assert.assertNotNull(user);
            Assert.assertNotNull(user.getRole());
        }finally {
            sqlSession.close();
        }
    }
}
