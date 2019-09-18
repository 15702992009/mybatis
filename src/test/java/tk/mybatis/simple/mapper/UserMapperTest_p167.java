package tk.mybatis.simple.mapper;

import org.apache.ibatis.ognl.ASTSequence;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest_p167 extends BaseMapperTest {
    @Test
    public void testInsertAndDelete(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test99");
            user.setUserPassword("123456");
            user.setUserEmail("test@,mybatis.com");
            user.setUserInfo("test Info");
            user.setHeadImg(new byte[]{1,2,3});
            //插入用户信息和角色关联信息
            userMapper.insertUserAndRoles(user,"1,2");
            Assert.assertNotNull(user.getId());
            Assert.assertNotNull(user.getCreateTime());
            userMapper.deleteUserById(user.getId());

        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
