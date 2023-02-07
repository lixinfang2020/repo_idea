package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseContentService;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;





    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    @Override
    public Course findCourseByCourseId(int courseId) {
        return courseContentMapper.findCourseByCourseId(courseId);
    }

    @Override
    public void saveSection(CourseSection section) {
        //补全信息
        Date date = new Date();
        section.setCreateTime(date);
        section.setUpdateTime(date);
        courseContentMapper.saveSection(section);
    }

    @Override
    public void updateSection(CourseSection courseSection) {
        //补全信息
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseContentMapper.updateCourseSection(courseSection);
    }

    @Override
    public void updateSectionStatus(int id, int status) {
        CourseSection courseSection = new CourseSection();
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseSection.setUpdateTime(new Date());
        courseContentMapper.updateSectionStatus(courseSection);
    }
}
