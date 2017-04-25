package com.lips.dao.lipsAdmin;

import com.lips.dao.lipsAdmin.pojo.SysUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(@Param("user_id") Long user_id, @Param("role_id") Long role_id);

    int insert(SysUserRole record);

    List<SysUserRole> selectAll();
}