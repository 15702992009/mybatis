package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {
        SysUser selectById(Long id);
        List<SysUser> selectALl();
        List<SysRole> selectRolesByUserId(Long userId);
        SysUser selectUserAndRoleById(Long userId);
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

}
