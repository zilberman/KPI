package com.kpi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kpi.model.Kpi;
import com.kpi.model.Project;
import com.kpi.service.KpiService;
import com.kpi.service.MenuItemService;
import com.kpi.service.ProjectService;

@Controller
@Transactional
public class KpiController {
    @Autowired
    private MenuItemService menuItemService;
    @Autowired
    private ProjectService  projectService;
    @Autowired
    private KpiService      kpiService;

    @RequestMapping(value = "/kpi", method = RequestMethod.POST)
    public ResponseEntity<String> createProject(@RequestParam("name") final String name) {
        final Kpi kpi = new Kpi();
        kpi.setName(name);

        this.kpiService.create(kpi);

        final List<Kpi> kpis = this.kpiService.getAll();

        return new ResponseEntity<String>(new Gson().toJson(kpis), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView menu() {
        final ModelAndView model = new ModelAndView("kpi");

        final List<Project> projects = this.projectService.getAll();

        final List<Kpi> kpis = this.kpiService.getAll();

        final Map<String, String> menuItems = this.menuItemService.getMenuItems();

        model.addObject("menuItems", menuItems);

        model.addObject("projects", new Gson().toJson(projects));

        model.addObject("kpis", new Gson().toJson(kpis));

        return model;
    }
}
