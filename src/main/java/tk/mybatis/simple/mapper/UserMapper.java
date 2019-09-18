package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;
import java.util.Map;

public interface UserMapper {
        SysUser selectById(Long id);
        List<SysUser> selectALl();
        List<SysRole> selectRolesByUserId(Long userId);
        SysUser selectUserAndRoleById(Long userId);
        SysUser selectUserAndRoleById2(Long userId);
        int insert(SysUser sysUser);

        /**
         * 注解实现
         * @param id
         * @return
         */

//        SysUser selectById2(Long id);

        /**
         *
         * @param sysUser
         * @return
         */

        List<SysUser> selectByUser(SysUser sysUser);
        SysUser selectUserAndRoleByIdSelect(Long id);
        List<SysUser> selectAllUserAndRoles();
        SysUser selectAllUserAndRolesSelect(Long id);

        /**
         * 使用存储过程查询用户信息
         * @param user
         */
        void selectUserById(SysUser user);
        List<SysUser> selectUserPage(Map<String,Object> params);
        int insertUserAndRoles(@Param("user")SysUser user,@Param("roleId")String roleIds);
        int deleteUserById(Long id);


}
