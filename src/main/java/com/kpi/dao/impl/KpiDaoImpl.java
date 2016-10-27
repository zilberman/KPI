package com.kpi.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kpi.dao.KpiDao;
import com.kpi.model.Kpi;

@Transactional
@Repository("kpiDao")
public class KpiDaoImpl implements KpiDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(final Kpi kpi) {
        this.sessionFactory.getCurrentSession().save(kpi);
    }

    @Override
    public void delete(final Kpi kpi) {
        this.sessionFactory.getCurrentSession().delete(kpi);
    }

    @Override
    public List<Kpi> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Kpi").list();
    }

    @Override
    public void update(final Kpi kpi) {
        this.sessionFactory.getCurrentSession().update(kpi);
    }
}
