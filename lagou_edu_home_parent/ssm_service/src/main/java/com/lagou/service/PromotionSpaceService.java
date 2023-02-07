package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

    /*
获取所有的广告位
*/
    public List<PromotionSpace> findAllPromotionSpace();


    void   savePromotionSpace(PromotionSpace promotionSpace);



    /**
     * 根据id 查询广告位信息
     * */
    PromotionSpace findPromotionSpaceById(int id);


    void   updatePromotionSpace(PromotionSpace promotionSpace);
}
