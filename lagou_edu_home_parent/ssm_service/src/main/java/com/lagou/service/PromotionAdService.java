package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface PromotionAdService {

    /*
分页获取所有的广告列表
*/
    public PageInfo<PromotionAd> findAllAdByPage(PromotionAdVo adVo);


    void  updatePromotionAdStatus(int id , int status);
}
