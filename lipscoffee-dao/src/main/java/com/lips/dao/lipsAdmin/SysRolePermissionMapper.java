package com.lips.dao.lipsAdmin;

import com.lips.dao.lipsAdmin.pojo.SysRolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(SysRolePermission record);

    List<SysRolePermission> selectAll();
}