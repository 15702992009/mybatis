package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;

public class RoleMapperTest extends BaseMapperTest {
    SqlSession sqlSession = null;

    @Test
    public void testMethod() {

        try {
            sqlSession = getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = mapper.selectById(1l);

        } finally {
            sqlSession.close();
        }

    }


}
