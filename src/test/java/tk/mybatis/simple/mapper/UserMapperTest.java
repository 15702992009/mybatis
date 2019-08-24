package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.Date;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectById方法,查询id为1的用户
            SysUser sysUser = userMapper.selectById(1l);
            Assert.assertNotNull(sysUser);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUsers = userMapper.selectALl();
            Assert.assertNotNull(sysUsers);
            Assert.assertTrue(sysUsers.size() > 0);

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> sysRoles = mapper.selectRolesByUserId(1l);
            Assert.assertNotNull(sysRoles);
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 测试insert方法的执行
     */
    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建SysUer对象
            SysUser sysUser = new SysUser();
            sysUser.setCreateTime(new Date());
            sysUser.setHeadImg(new byte[]{1,2,3,4});
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@example.com");
            sysUser.setUserInfo("test Info");
            //将新创建的对象insert到数据库中
            int insert = userMapper.insert(sysUser);
            Assert.assertEquals(1,insert);
            Assert.assertNull(sysUser.getId());
        } finally {
//            sqlSession.rollback();
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
