package com.kpi.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class MenuItemServiceTest {

    @Mock
    MenuItemService menuItemService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMenuItemService() {
        Assert.assertEquals(0, this.menuItemService.getMenuItems().size());
    }

    @Test
    public void testMenuItemServiceAsMock() {
        final Map<String, String> menuItems = new HashMap<>();
        menuItems.put("menu1", "content");

        Mockito.when(this.menuItemService.getMenuItems()).thenReturn(menuItems);
        Assert.assertEquals(1, this.menuItemService.getMenuItems().size());
    }
}
