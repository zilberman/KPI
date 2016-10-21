package com.kpi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long   Id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Code")
    private String code;

    @Column(name = "Status")
    private String status;

    @Column(name = "DateStarted", nullable = false)
    private Date   dateStarted;

    @Column(name = "DateFinished")
    private Date   dateFinished;

    public Project() {
    }

    public Project(final long id, final String name, final String code, final String status,
            final Date dateStarted, final Date dateFinished) {

        super();

        this.Id = id;
        this.name = name;
        this.code = code;
        this.status = status;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
    }

    public String getCode() {
        return this.code;
    }

    public Date getDateFinished() {
        return this.dateFinished;
    }

    public Date getDateStarted() {
        return this.dateStarted;
    }

    public long getId() {
        return this.Id;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setDateFinished(final Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public void setDateStarted(final Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setId(final long id) {
        this.Id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
