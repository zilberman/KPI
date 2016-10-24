package com.kpi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.kpi.model.Project;
import com.kpi.service.ProjectService;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public ResponseEntity<String> createProject(@RequestParam("name") final String name,
            @RequestParam("code") final String code) {
        final Project project = new Project();
        project.setName(name);
        project.setCode(code);
        project.setStatus("Draft");
        project.setDateStarted(new Date());

        this.projectService.create(project);

        final List<Project> projects = this.projectService.getAll();

        return new ResponseEntity<String>(new Gson().toJson(projects), HttpStatus.CREATED);
    }
}
