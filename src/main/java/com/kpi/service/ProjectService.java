package com.kpi.service;

import java.util.List;

import com.kpi.model.Project;

public interface ProjectService {
    public void create(Project project);

    public void delete(Project project);

    public List<Project> getAll();

    public void update(Project project);
}
