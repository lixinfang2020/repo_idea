package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.ResourceService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;







    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());
        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);
        PageInfo<Resource> resourcePageInfo = new PageInfo<>(allResource);
        return  resourcePageInfo;
    }
}
