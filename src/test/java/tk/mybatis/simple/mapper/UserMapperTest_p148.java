package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest_p148 extends BaseMapperTest {
    @Test
    public void testSelectUserAndRoleByIdSelect() {
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAllUserAndRoles();
            System.out.println("用户数:"+userList.size());
            for (SysUser user : userList) {
                System.out.println("用户名:"+user.getUserName());
                for (SysRole role : user.getRoleList()) {
                    System.out.println("角色名:"+role.getRoleName());
                    for (SysPrivilege privilege : role.getPrivilegeList()) {
                        System.out.println("权限名："+privilege.getPrivilegeName());
                    }
                }
            }

        }finally {
            sqlSession.close();
        }
    }
}
