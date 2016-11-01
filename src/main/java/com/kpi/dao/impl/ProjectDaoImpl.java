package com.kpi.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpi.dao.ProjectDao;
import com.kpi.model.Kpi;
import com.kpi.model.Project;

@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addKpiToProject(final long projectId, final long kpiId) {
        final Session session = this.sessionFactory.getCurrentSession();

        final Project project = (Project) session.load(Project.class, projectId);

        final Kpi kpi = (Kpi) session.load(Kpi.class, kpiId);

        project.getKpis().add(kpi);
    }

    @Override
    public void create(final Project project) {
        this.sessionFactory.getCurrentSession().save(project);
    }

    @Override
    public void delete(final Project project) {
        this.sessionFactory.getCurrentSession().delete(project);
    }

    @Override
    public List<Project> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Project").list();
    }

    @Override
    public void update(final Project project) {
        this.sessionFactory.getCurrentSession().update(project);
    }
}
