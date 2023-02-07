package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourceVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;
    /**
     * 查询菜单列表信息
     * */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(){

        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();
        ResponseResult result = new ResponseResult(true,200,"响应成功",allResourceCategory);
        return result;
    }


}
