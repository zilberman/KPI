package com.kpi.service;

import java.util.List;

import com.kpi.model.Kpi;

public interface KpiService {
    public void create(Kpi Kpi);

    public void delete(Kpi Kpi);

    public List<Kpi> getAll();

    public void update(Kpi Kpi);
}
