package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest_p149 extends BaseMapperTest {
    @Test
    public void testSelectUserAndRoleByIdSelect() {
        SqlSession sqlSession = getSqlSession();
        try{
            RolePrivilegeMapper mapper = sqlSession.getMapper(RolePrivilegeMapper.class);
            List<SysRole> sysPrivileges = mapper.selectRoleAndAllPrivileges();
//            System.out.println(sysPrivileges.size());

        }finally {
            sqlSession.close();
        }
    }
}
