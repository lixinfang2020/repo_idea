package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourceVo;

import java.util.List;

public interface ResourceCategoryService {

    List<ResourceCategory> findAllResourceCategory();
}
