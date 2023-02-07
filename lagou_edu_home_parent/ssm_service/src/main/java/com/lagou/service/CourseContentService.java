package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseContentService {

    /**
     * 查询课程下的章节与课时信息
     * */
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);



    Course findCourseByCourseId(int courseId);


    public void saveSection(CourseSection section);

    void updateSection(CourseSection courseSection);


    public void updateSectionStatus(int id,int status);
}
