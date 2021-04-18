package com.itheima.service;

import com.itheima.domain.Items;

import java.io.IOException;

public interface ItemsService {
    public Items findById(Integer id) throws IOException;

    void addOne(Items items) throws IOException;
}
