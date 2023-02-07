package com.lagou.service;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;

import java.util.List;

public interface MenuService {

    public List<Menu> findSubMenuListByPid(int pid);


    List<Menu> findAllMenu();


    Menu findMenuById(Integer id);
}
