package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/promotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    @RequestMapping("/findAllPromotionAd")
    public ResponseResult findAllPromotionAd(PromotionAdVo adVo){
        PageInfo<PromotionAd> allAdByPage = promotionAdService.findAllAdByPage(adVo);
        return  new ResponseResult(true,1,"请求成功",allAdByPage);
    }


    @RequestMapping("/promotionAdUpload")
    public  ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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



    @RequestMapping("/updatePromotionAdStatus")
    public  ResponseResult updatePromotionAdStatus(int id , int status) {


        promotionAdService.updatePromotionAdStatus(id,status);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("status",status);
        return  new ResponseResult(true,1,"请求成功",hashMap);
    }



}
