package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest_p154 extends BaseMapperTest {
    @Test
    public void testSelectUserAndRoleByIdSelect() {
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = mapper.selectAllUserAndRolesSelect(1L);
            System.out.println("用户名："+user.getUserName());
            for (SysRole role : user.getRoleList()) {
                System.out.println("角色名："+role.getRoleName());
                for (SysPrivilege privilege : role.getPrivilegeList()) {
                    System.out.println("权限名："+privilege.getPrivilegeName());
                }
            }

        }finally {
            sqlSession.close();
        }
    }
}
