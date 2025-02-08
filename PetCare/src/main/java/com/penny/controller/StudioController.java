package com.penny.controller;

import com.penny.pojo.Result;
import com.penny.pojo.Studio;
import com.penny.service.StudioService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // equal to below which comment
@RequestMapping("/depts")
@RestController
public class StudioController {

//    private static Logger log  = LoggerFactory.getLogger(StudioController.class);
    @Autowired
    private StudioService studioService;

    @GetMapping
    public Result list(){
        log.info("Search All Studio Data");
        List<Studio> studioList = studioService.list();
        return Result.success(studioList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("Delete Studio by id: {}", id);
        studioService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Studio studio){
        log.info("Add Studio: {}", studio);
        studioService.add(studio);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据 id 查找工作室: {}", id);

        // 调用 service 查找工作室
        Studio studio = studioService.getById(id);

        return Result.success(studio);
    }

    @PutMapping
    public Result modify(@RequestBody Studio studio) {
        log.info("修改工作室: {}", studio);

        // 调用 service 修改工作室
        studioService.modify(studio);

        return Result.success();
    }


}
