package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.*;
import com.lagou.service.TestService;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody  UserVo userVo){

        PageInfo allUserByPage = userService.findAllUserByPage(userVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "查询用户分页成功", allUserByPage);

       return responseResult;
    }

    @RequestMapping("/login")
    public  ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User user1 = userService.login(user);
        if (user1 != null){

            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("user_id",user1.getId());
            session.setAttribute("access_token",access_token);

            HashMap<String, Object> map = new HashMap<>();

            map.put("user_id",user1.getId());
            map.put("access_token",access_token);
            ResponseResult responseResult   = new ResponseResult(true,1,"响应成功",map);
            return responseResult;

        }else {
            ResponseResult responseResult = new ResponseResult(false, 400, "用户名或密码错误", null);
             return  responseResult;
        }
    }

    @RequestMapping("/findUserRelationRoleById")
    public  ResponseResult findUserRelationRoleById(Integer id){
        List<Role> userRelationRoleById = userService.findUserRelationRoleById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "查询了所有角色", userRelationRoleById);
       return  responseResult;
    }


    @RequestMapping("/userContextRole")
    public  ResponseResult userContextRole(@RequestBody UserVo userVo){
       userService.userContextRole(userVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "分配角色成功", null);
        return  responseResult;
    }

    @RequestMapping("/getUserPermissions")
    public  ResponseResult getUserPermissions(HttpServletRequest request){
        String header_token= request.getHeader("Authorization");
        String access_token = (String) request.getSession().getAttribute("access_token");
        if (header_token.equals(access_token)){
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");
            ResponseResult responseResult = userService.getUserPermissions(user_id);
            return responseResult;
        }else {
            ResponseResult result = new ResponseResult(false,400,"获取失败","");
            return result;
        }

    }
}
