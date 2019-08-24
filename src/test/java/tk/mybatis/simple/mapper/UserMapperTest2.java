package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest2 extends BaseMapperTest {
    SqlSession sqlSession=getSqlSession();
    @Test
    public void testMethod(){
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //只查询用户名时
            SysUser sysUser = new SysUser();
            sysUser.setUserName("ad");
            List<SysUser> sysUsers = mapper.selectByUser(sysUser);
            Assert.assertTrue(sysUsers.size()>0);
            //只查询邮箱
            SysUser sysUser1 = new SysUser();
            sysUser1.setUserEmail("test@mybatis.tk");
            List<SysUser> sysUserList = mapper.selectByUser(sysUser1);
            Assert.assertTrue(sysUserList.size()>0);
            //同时查询用户名和邮箱
            SysUser sysUser2 = new SysUser();
            sysUser2.setUserEmail("test@mybatis.tk");
            sysUser2.setUserName("ad");
            List<SysUser> sysUserList1 = mapper.selectByUser(sysUser2);
            Assert.assertTrue(sysUserList1.size()==0);

        }finally {
            sqlSession.close();

        }
    }
}
