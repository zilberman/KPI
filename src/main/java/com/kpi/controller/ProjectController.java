package com.kpi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.kpi.constants.KpiConstants;
import com.kpi.model.Project;
import com.kpi.model.ProjectStatus;
import com.kpi.service.ProjectService;

@Controller
@Transactional
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/add-kpi-to-project", method = RequestMethod.POST)
    public ResponseEntity<String> addKpiToProject(@RequestParam("projectId") final long projectId,
            @RequestParam("kpiId") final long kpiId) {

        this.projectService.addKpiToProject(projectId, kpiId);

        return new ResponseEntity<String>(KpiConstants.KPI_ASSIGNED, HttpStatus.OK);
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public ResponseEntity<String> createProject(@RequestParam("name") final String name,
            @RequestParam("code") final String code) {
        final Project project = new Project();
        project.setName(name);
        project.setCode(code);
        project.setStatus(ProjectStatus.DRAFT.toString());
        project.setDateStarted(new Date());

        this.projectService.create(project);

        final List<Project> projects = this.projectService.getAll();

        return new ResponseEntity<String>(new Gson().toJson(projects), HttpStatus.CREATED);
    }
}
