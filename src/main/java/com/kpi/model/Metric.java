package com.kpi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Metric")
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long   Id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Formula")
    private String formula;

    public String getFormula() {
        return this.formula;
    }

    public long getId() {
        return this.Id;
    }

    public String getName() {
        return this.name;
    }

    public void setFormula(final String formula) {
        this.formula = formula;
    }

    public void setId(final long id) {
        this.Id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
