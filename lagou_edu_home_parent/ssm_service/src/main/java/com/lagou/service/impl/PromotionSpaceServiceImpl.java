package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.CourseContentService;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;





    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        UUID uuid = UUID.randomUUID();
        promotionSpace.setSpaceKey(uuid.toString());
        promotionSpace.setIsDel(0);
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findPromotionSpaceById(int id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        Date date = new Date();

        promotionSpace.setUpdateTime(date);
         promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
