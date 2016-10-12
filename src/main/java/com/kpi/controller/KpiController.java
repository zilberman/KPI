package com.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kpi.service.MenuItemService;

@Controller
public class KpiController {
    @Autowired
    private MenuItemService menuItemService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView menu() {
        final ModelAndView model = new ModelAndView("kpi");

        model.addObject("menuItems", this.menuItemService.getMenuItems());

        return model;
    }
}