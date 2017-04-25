package com.lips.dao.lipsAdmin;

import com.lips.dao.lipsAdmin.pojo.SysPermission;
import java.util.List;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    SysPermission selectByPrimaryKey(Long id);

    List<SysPermission> selectAll();

    int updateByPrimaryKey(SysPermission record);
}