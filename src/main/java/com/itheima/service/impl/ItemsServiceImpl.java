package com.itheima.service.impl;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

@Service

public class ItemsServiceImpl implements ItemsService {
    private ItemsDao mapper() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        ItemsDao mapper = sqlSession.getMapper(ItemsDao.class);
        return mapper;
    }

    public Items findById(Integer id) throws IOException {
        ItemsDao mapper = mapper();
        return mapper.findById(id);
    }

    @Override
    public void addOne(Items items) throws IOException {
        ItemsDao mapper = mapper();
        items.setName("summer");
        items.setPrice(23.0);
        items.setPic("asd");
        items.setCreatetime(new Date(4732984719237492L));
        items.setDetail("sadfg");

        mapper.addOne(items);
    }


}
