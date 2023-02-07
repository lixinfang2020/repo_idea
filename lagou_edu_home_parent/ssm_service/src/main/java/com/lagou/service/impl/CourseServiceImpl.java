package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.dao.TestMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.domain.Test;
import com.lagou.service.CourseService;
import com.lagou.service.TestService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.annotations.CacheNamespace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        return courseMapper.findCourseByCondition(courseVO);
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);

        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);

        courseMapper.saveCourse(course);

        int id = course.getId();

        Teacher teacher = new Teacher();

        BeanUtils.copyProperties(teacher,courseVO);

        teacher.setCourseId(id);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        courseMapper.saveTeacher(teacher);

    }

    @Override
    public CourseVO findCourseById(int id) {

        CourseVO courseVO = courseMapper.findCourseById(id);

        return courseVO ;
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);
        Date date = new Date();
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(int id, int status) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(new Date());
        courseMapper.updateCourseStatus(course);
    }
}
