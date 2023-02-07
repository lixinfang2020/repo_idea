package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Test;
import com.lagou.service.CourseService;
import com.lagou.service.TestService;
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

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){
        List<Course> courseByCondition = courseService.findCourseByCondition(courseVO);
        return  new ResponseResult(true,1,"请求成功",courseByCondition);
    }
    @RequestMapping("/courseUpload")
    public  ResponseResult fileUpload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException {
        if (file.isEmpty()){
            throw  new RuntimeException();
        }
        String realPath = request.getServletContext().getRealPath("/");
        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));
        String originalFilename = file.getOriginalFilename();

        String newFilename = System.currentTimeMillis()+originalFilename.substring(originalFilename.lastIndexOf("."));

        String uploadPah = substring+"upload\\";
        File filePath = new File(uploadPah, newFilename);

        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录："+filePath);
        }

        file.transferTo(filePath);

        HashMap<String, String> map = new HashMap<>();

        map.put("fileName",newFilename);
        map.put("filePath","http://localhost:8888/upload/"+newFilename);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);

       return  responseResult;
    }

    @RequestMapping("/saveOrUpdateCourse")
    public  ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException
    {
        if (courseVO.getId() == null){
            courseService.saveCourseOrTeacher(courseVO);
            return  new ResponseResult(true,200,"增加成功",null);
        }else {
            courseService.updateCourseOrTeacher(courseVO);
            return  new ResponseResult(true,200,"修改成功",null);
        }
    }



    @RequestMapping("/findCourseById")
    public  ResponseResult findCourseById(Integer id)  {

        CourseVO courseVO = courseService.findCourseById(id);


        return  new ResponseResult(true,200,"响应成功",courseVO);
    }


    @RequestMapping("/updateCourseStatus")
    public  ResponseResult updateCourseStatus(Integer id,Integer status)  {

       courseService.updateCourseStatus(id,status);

        HashMap<String, Object> map = new HashMap<>();
        map.put("status",status);

        return  new ResponseResult(true,200,"响应成功",map);
    }
}
