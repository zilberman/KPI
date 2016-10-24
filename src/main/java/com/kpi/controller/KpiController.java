package com.kpi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.kpi.model.Project;
import com.kpi.service.MenuItemService;
import com.kpi.service.ProjectService;

@Controller
public class KpiController {
    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private ProjectService  projectService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView menu() {
        final ModelAndView model = new ModelAndView("kpi");

        final List<Project> projects = this.projectService.getAll();

        model.addObject("menuItems", this.menuItemService.getMenuItems());

        model.addObject("projects", new Gson().toJson(projects));

        return model;
    }
}
