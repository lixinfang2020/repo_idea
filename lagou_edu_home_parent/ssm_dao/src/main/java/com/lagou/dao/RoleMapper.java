package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;

import java.util.List;

public interface RoleMapper {

     /*
查询角色列表(条件)
*/
     public List<Role> findAllRole(Role role);


     List<Integer> findMenuByRoleId(Integer roleId);

     void deleteRoleContextMenu(Integer rid);

     void roleContextMenu(Role_menu_relation role_menu_relation);

     void  deleteRole(Integer roleId);
}
