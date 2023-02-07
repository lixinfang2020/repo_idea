package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.TestMapper;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.TestService;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getCurrentPage());
        List<User> allUserByPage = userMapper.findAllUserByPage(userVo);
        PageInfo<User> userPageInfo = new PageInfo<>(allUserByPage);

        return userPageInfo;
    }

    @Override
    public User login(User user) throws Exception {
        User user2 = userMapper.login(user);
        if (user2 !=null && Md5.verify(user.getPassword(),"lagou",user2.getPassword())){
            return user2;
        }else {
            return  null;
        }
    }

    @Override
    public List<Role> findUserRelationRoleById(int id) {
        List<Role> userRelationRoleById = userMapper.findUserRelationRoleById(id);
        return userRelationRoleById;
    }

    @Override
    public void userContextRole(UserVo userVo) {
        userMapper.deleteUserContextRole(userVo.getUserId());

        for (Integer roleId:userVo.getRoleIdList()) {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleId);
            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");
            userMapper.userContextRole(user_role_relation);
        }
    }

    @Override
    public ResponseResult getUserPermissions(Integer userId) {
        List<Role> userRelationRoleById = userMapper.findUserRelationRoleById(userId);

        ArrayList<Integer> roleIds = new ArrayList<>();

        for (Role role: userRelationRoleById
             ) {
            roleIds.add(role.getId());
        }

        List<Menu> parentMenuByRoleId = userMapper.findParentMenuByRoleId(roleIds);

        for (Menu menu:parentMenuByRoleId) {
            List<Menu> subMenuByPid = userMapper.findSubMenuByPid(menu.getId());
            menu.setMenuList(subMenuByPid);
        }


        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);


        HashMap<String, Object> map = new HashMap<>();

        map.put("menuList",parentMenuByRoleId);
        map.put("resourceList",resourceList);
        return  new ResponseResult(true,200,"响应成功",map);

    }
}
