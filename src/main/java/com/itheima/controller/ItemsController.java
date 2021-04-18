package com.itheima.controller;

import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/find1")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/find")
    public ModelAndView findDetail() {
        ModelAndView modelAndView1 = new ModelAndView();
        try {

            Items items = itemsService.findById(1);
            modelAndView1.addObject("item", items);
            modelAndView1.setViewName("itemDetail");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView1;

    }

    @RequestMapping("/add")
    public void addOne() {
        try {
            Items items = new Items();

            itemsService.addOne(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
