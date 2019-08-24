package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;

public class RoleMapperTest2 extends BaseMapperTest {
    SqlSession sqlSession = null;

    @Test
    public void testMethod() {

        try {
            sqlSession = getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = mapper.selectById2(1l);

        } finally {
            sqlSession.close();
        }

    }


}
