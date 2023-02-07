package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

        List<Role> allRole = roleService.findAllRole(role);
        ResponseResult responseResult = new ResponseResult(true, 200, "查询用户角色成功", allRole);

       return responseResult;
    }


    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){

        List<Menu> menuList = menuService.findSubMenuListByPid(-1);

        HashMap<String, Object> map = new HashMap<>();
         map.put("parentMenuList", menuList);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有菜单成功", map);

        return responseResult;
    }


    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){

        List<Integer> menuList = roleService.findMenuByRoleId(roleId);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询角色已设置的菜单成功", menuList);

        return responseResult;
    }

    @RequestMapping("/roleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVo roleMenuVo){

         roleService.roleContextMenu(roleMenuVo);

        ResponseResult responseResult = new ResponseResult(true, 200, "角色设置菜单成功", null);

        return responseResult;
    }


    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){

        roleService.deleteRole(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除角色成功", null);

        return responseResult;
    }

}
