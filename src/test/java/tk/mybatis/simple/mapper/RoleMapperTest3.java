package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;

import java.util.List;

public class RoleMapperTest3 extends BaseMapperTest {
    SqlSession sqlSession = null;

    @Test
    public void testMethod() {

        try {
            sqlSession = getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> sysRoles = mapper.selectAll();

        } finally {
            sqlSession.close();
        }

    }


}
