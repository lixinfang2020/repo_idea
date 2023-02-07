package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    List<Course>  findCourseByCondition(CourseVO courseVO);

    /**
     * 保存课程信息
     * */
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;


    /**
     * 根据id获取课程信息
     * */
    public CourseVO findCourseById(int id);


    /**
     * 修改课程信息
     * */
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;


    /**
     * 修改课程状态
     * */
    public void updateCourseStatus(int id,int status);


}
