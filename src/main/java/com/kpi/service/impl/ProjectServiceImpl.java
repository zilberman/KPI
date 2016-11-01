package com.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpi.dao.ProjectDao;
import com.kpi.model.Project;
import com.kpi.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    public void addKpiToProject(final long projectId, final long kpiId) {

    }

    @Override
    public void create(final Project project) {
        this.projectDao.create(project);
    }

    @Override
    public void delete(final Project project) {
        this.projectDao.delete(project);
    }

    @Override
    public List<Project> getAll() {
        return this.projectDao.getAll();
    }

    @Override
    public void update(final Project project) {
        this.projectDao.update(project);
    }
}
