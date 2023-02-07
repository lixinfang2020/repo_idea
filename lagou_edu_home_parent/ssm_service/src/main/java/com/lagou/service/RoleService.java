package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;
import com.lagou.domain.UserVo;

import java.util.List;

public interface RoleService {

    public List<Role> findAllRole(Role role);


    List<Integer> findMenuByRoleId(Integer roleId);

    void roleContextMenu(RoleMenuVo roleMenuVo);


    void deleteRole(Integer id);

}
