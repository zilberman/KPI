package com.kpi.dao;

import java.util.List;

import com.kpi.model.Kpi;

public interface KpiDao {
    public void create(Kpi Kpi);

    public void delete(Kpi Kpi);

    public List<Kpi> getAll();

    public void update(Kpi Kpi);
}
