package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface UserMapper {

     public List<User> findAllUserByPage(UserVo userVo);


   User  login(User user);




   void deleteUserContextRole(Integer userId);

   void  userContextRole(User_Role_relation user_role_relation);


    List<Role> findUserRelationRoleById(Integer id);

    List<Menu> findParentMenuByRoleId(List<Integer> ids);

    List<Menu> findSubMenuByPid(Integer pid);

    List<Resource> findResourceByRoleId(List<Integer> ids);
     
     
      List<Resource> findResourceByRoleId2(List<Integer> ids);
     
     List<Resource> findResourceByRoleId3(List<Integer> ids);
}
