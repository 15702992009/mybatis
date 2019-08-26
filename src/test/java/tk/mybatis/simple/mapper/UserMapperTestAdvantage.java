package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class UserMapperTestAdvantage extends  BaseMapperTest{
    @Test
    public void testSelectUserAndROleById(){
        //获取SQLSession
        SqlSession sqlSession=getSqlSession();
        try{
            //获取UseMapper接口
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            SysUser user= userMapper.selectRolesByUserId(1001L);
            Assert.assertNotNull(user);
            Assert.assertNotNull(user.getRole());
        }finally {
            sqlSession.close();
        }
    }
}
