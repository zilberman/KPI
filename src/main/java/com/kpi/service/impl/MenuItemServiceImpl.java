package com.kpi.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kpi.service.MenuItemService;

@Service("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {
    @Override
    public Map<String, String> getMenuItems() {
        final Map<String, String> menuItems = new HashMap<>();

        menuItems.put("Home", "Some content about home page");
        menuItems.put("Projects", "Some content about projects page");
        menuItems.put("Metrics", "Some content about metrics page");
        menuItems.put("KPIs", "Some content about KPIs page");

        return menuItems;
    }
}
