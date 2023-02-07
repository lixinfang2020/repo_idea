package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface CourseMapper {


    List<Course>  findCourseByCondition(CourseVO courseVO);


    /**
     * 保存课程信息
     */
    int saveCourse(Course course);
    /**
     * 保存讲师信息
     * */
   void saveTeacher(Teacher teacher);


    /**
     * 根据id 获取课程信息
     * */
    public CourseVO findCourseById(int id);




    /**
     * 根据id 获取课程信息
     * */
    void updateCourse(Course course);




    void updateTeacher(Teacher teacher);



    public  void updateCourseStatus(Course course);

}
