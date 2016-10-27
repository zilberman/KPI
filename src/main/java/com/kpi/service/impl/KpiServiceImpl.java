package com.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpi.dao.KpiDao;
import com.kpi.model.Kpi;
import com.kpi.service.KpiService;

@Service("kpiService")
public class KpiServiceImpl implements KpiService {
    @Autowired
    private KpiDao kpiDao;

    @Override
    public void create(final Kpi kpi) {
        this.kpiDao.create(kpi);
    }

    @Override
    public void delete(final Kpi kpi) {
        this.kpiDao.delete(kpi);
    }

    @Override
    public List<Kpi> getAll() {
        return this.kpiDao.getAll();
    }

    @Override
    public void update(final Kpi kpi) {
        this.kpiDao.update(kpi);
    }
}
