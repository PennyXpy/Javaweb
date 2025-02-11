package com.penny.controller;


import com.penny.pojo.Result;
import com.penny.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class uploadController {

//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传 {}, {}, {}", username, age, image);
//        //获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//
//        //防止覆盖 构造唯一文件名 -- uuid（通用唯一识别码）
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("新文件名：{},", newFileName);
//
//        // 本地存储磁盘目录
//        image.transferTo(new File("/Users/begoodcoder/Desktop/Javaweb/image/" + newFileName));
//
//        return Result.success();
//    }

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传 {}", image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成 url是 {}", url);
        return Result.success(url);
    }
}
