package com.lips.dao.lipsAdmin;

import com.lips.dao.lipsAdmin.pojo.SysUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(SysUserRole record);

    List<SysUserRole> selectAll();
}