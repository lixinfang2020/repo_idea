package com.lagou.dao;

import com.lagou.domain.Menu;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

public interface ResourceMapper {

     public List<Resource> findAllResource(ResourceVo resourceVo);
}
