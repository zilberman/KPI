package com.kpi.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class KPIController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(final HttpServletRequest request,
            final HttpServletResponse response) {
        final ModelAndView model = new ModelAndView("main");

        model.addObject("menuItems", this.getMenuItems());

        return model;
    }

    private Map<String, String> getMenuItems() {
        final Map<String, String> menuItems = new HashMap<>();

        menuItems.put("Home", "Some content about home page");
        menuItems.put("Projects", "Some content about projects page");
        menuItems.put("Metrics", "Some content about metrics page");
        menuItems.put("KPIs", "Some content about KPIs page");

        return menuItems;
    }
}