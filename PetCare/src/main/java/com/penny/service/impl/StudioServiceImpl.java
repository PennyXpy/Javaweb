package com.penny.service.impl;

import com.penny.mapper.StudioMapper;
import com.penny.pojo.Studio;
import com.penny.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudioServiceImpl  implements StudioService {
    @Autowired
    private StudioMapper studioMapper;

    @Override
    public List<Studio> list() {
        return studioMapper.list();
    }

    @Override
    public void delete(Integer id) {
        studioMapper.deleteById(id);
    }

    @Override
    public void add(Studio studio) {
        studio.setCreateTime(LocalDateTime.now());
        studio.setUpdateTime(LocalDateTime.now());

        studioMapper.insert(studio);
    }

    @Override
    public Studio getById(Integer id) {
        return studioMapper.getById(id);
    }

    @Override
    public void modify(Studio studio) {
        studioMapper.updateStudio(studio);
    }

}
