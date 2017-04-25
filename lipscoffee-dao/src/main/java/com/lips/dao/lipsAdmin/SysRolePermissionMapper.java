package com.lips.dao.lipsAdmin;

import com.lips.dao.lipsAdmin.pojo.SysRolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(@Param("role_id") Long role_id, @Param("permission_id") Long permission_id);

    int insert(SysRolePermission record);

    List<SysRolePermission> selectAll();
}