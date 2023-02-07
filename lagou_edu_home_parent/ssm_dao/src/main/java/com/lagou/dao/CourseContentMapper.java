package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

public interface CourseContentMapper {



    /**
     * 查询课程下的章节与课时信息
     * */
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);


     Course findCourseByCourseId(int courseId);

     void  saveSection(CourseSection courseSection);


    void updateCourseSection(CourseSection courseSection);



    /**
     * 修改章节状态
     * */
    public void updateSectionStatus(CourseSection section);
}
