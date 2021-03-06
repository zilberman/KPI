package com.kpi.dao;

import java.util.List;

import com.kpi.model.Project;

public interface ProjectDao {
    public void addKpiToProject(final long projectId, final long kpiId);

    public void create(Project project);

    public void delete(Project project);

    public List<Project> getAll();

    public void update(Project project);
}
