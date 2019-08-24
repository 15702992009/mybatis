package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;

import java.util.Date;

/**
 * test 通过配置注解，返回自增主键
 * INSERT INTO 'sys_role' VALUES ('1','管理员','1','1','2016-04-01 17:02:14');
 */
public class RoleMapperTest4 extends BaseMapperTest {
    SqlSession sqlSession = null;

    @Test
    public void testMethod() {

        try {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("wangjiabo");
            sysRole.setEnabled(1);
            sysRole.setCreateBy(1l);
            sysRole.setCreateTime(new Date());
            sqlSession = getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            int i = mapper.insert2(sysRole);
            Assert.assertEquals(1,i);
            Assert.assertNotNull(sysRole.getId());
            System.out.println(sysRole.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }


}
