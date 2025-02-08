package com.penny.service;

import com.penny.pojo.Studio;

import java.util.List;

public interface StudioService {

    // show all studios
    List<Studio> list();

    void delete(Integer id);

    void add(Studio studio);

    Studio getById(Integer id);

    void modify(Studio studio);
}
