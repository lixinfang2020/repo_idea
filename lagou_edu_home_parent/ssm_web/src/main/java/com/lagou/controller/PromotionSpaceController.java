package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jnlp.PersistenceService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/promotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> courseSectionList = promotionSpaceService.findAllPromotionSpace();
        return  new ResponseResult(true,1,"请求成功",courseSectionList);
    }





    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody  PromotionSpace promotionSpace){

        if (promotionSpace.getId() == null){
            promotionSpaceService.savePromotionSpace(promotionSpace);
            return  new ResponseResult(true,200,"新增广告位成功",null);
        }else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            return  new ResponseResult(true,200,"更新广告位成功",null);
        }



    }

    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(Integer id){
        PromotionSpace promotionSpaceById = promotionSpaceService.findPromotionSpaceById(id);

        return  new ResponseResult(true,200,"查询广告位成功",promotionSpaceById);
    }

}
