package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.*;

import java.util.List;

public interface UserService {

    /*
查询所有用户
*/
    public PageInfo findAllUserByPage(UserVo userVo);

    User  login (User user) throws Exception;


    /**
     * 获取用户拥有的角色
     * */
    public List<Role> findUserRelationRoleById(int id) ;


    /*
用户关联角色
*/
    void userContextRole(UserVo userVo);


    /*
     * 获取用户权限
     * */
    ResponseResult getUserPermissions(Integer userId);
}
