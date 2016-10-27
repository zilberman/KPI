package com.kpi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Kpi")
public class Kpi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long   Id;

    @Column(name = "Name")
    private String name;

    public Kpi() {
    }

    public Kpi(final long id, final String name) {
        this.Id = id;
        this.name = name;
    }

    public long getId() {
        return this.Id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(final long id) {
        this.Id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
