package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.*;
import tk.mybatis.simple.model.SysRole;

import java.util.List;

public interface RoleMapper {
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role where id=#{id}"})
    SysRole selectById(Long id);

    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role where id=#{id}"})
    SysRole selectById2(Long id);

    @ResultMap("roleResultMap")
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role "})
    List<SysRole> selectAll();

    @Insert({"insert into sys_role(role_name,enabled,create_by,create_time) values(#{roleName}, #{enabled}, #{createBy}, #{createTime,jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true,  keyColumn ="id," )
    int insert2(SysRole sysRole);
    SysRole selectRoleById(Long id);
    SysRole selectRoleByUserId(Long userId);

}
