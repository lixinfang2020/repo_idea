package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionAdService;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo<PromotionAd> findAllAdByPage(PromotionAdVo adVo) {
        PageHelper.startPage(adVo.getCurrentPage(),adVo.getPageSize());
        List<PromotionAd> allAdByPage = promotionAdMapper.findAllAdByPage();
        PageInfo<PromotionAd> promotionAdPageInfo = new PageInfo<>(allAdByPage);
        return  promotionAdPageInfo;
    }

    @Override
    public void updatePromotionAdStatus(int id , int status) {
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
