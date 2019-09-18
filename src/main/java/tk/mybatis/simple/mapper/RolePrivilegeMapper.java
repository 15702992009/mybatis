package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;

import java.util.List;

public interface RolePrivilegeMapper {


    List<SysRole> selectRoleAndAllPrivileges();
}
