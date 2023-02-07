package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findCourseByCondition(Integer courseId){
        List<CourseSection> courseSectionList = courseContentService.findSectionAndLessonByCourseId(courseId);
        return  new ResponseResult(true,1,"请求成功",courseSectionList);
    }



    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){
      Course course= courseContentService.findCourseByCourseId(courseId);
        return  new ResponseResult(true,1,"请求成功",course);
    }


    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        if (courseSection.getId() == null){
            courseContentService.saveSection(courseSection);
            return  new ResponseResult(true,1,"添加成功",null);
        }else {
            courseContentService.updateSection(courseSection);
            return  new ResponseResult(true,1,"更新成功",null);
        }


    }



    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id, int status){

            courseContentService.updateSectionStatus(id,status);
        //封装最新的状态信息
        Map<String,Integer> map = new HashMap<>();
        map.put("status",status);
        return  new ResponseResult(true,1,"更新状态成功",map);

    }

}
