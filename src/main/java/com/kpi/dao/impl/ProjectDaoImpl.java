package com.kpi.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kpi.dao.ProjectDao;
import com.kpi.model.Project;

@Transactional
@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    private SessionFactory sessionFactory;

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
