package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourceVo;

import java.util.List;

public interface ResourceCategoryMapper {

     public List<ResourceCategory> findAllResourceCategory();
}
