package com.penny.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.penny.mapper.EmpMapper;
import com.penny.mapper.StudioMapper;
import com.penny.pojo.Emp;
import com.penny.pojo.PageBean;
import com.penny.pojo.Studio;
import com.penny.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl  implements EmpService {

    @Autowired
    private EmpMapper empMapper;
//
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long count = empMapper.count();
//
//        // 获取分页查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//
//        //实体类封装pageBean
//        return new PageBean(count, empList);
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }
}
