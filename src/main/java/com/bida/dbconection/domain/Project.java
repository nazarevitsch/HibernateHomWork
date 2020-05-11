package com.bida.dbconection.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Project")
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_project")
    private long id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "name")
    private String name;
    @Column(name = "developers_amount")
    private int developersAmount;

    public Project(){}

    public Project(Date startDate, Date endDate, String name, int developersAmount){
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.developersAmount = developersAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDevelopersAmount() {
        return developersAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Transient
    public void setDevelopersAmount(int developersAmount) {
        this.developersAmount = developersAmount;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                "startDate='" + startDate + '\'' +
                "endDate='" + endDate + '\'' +
                ", name='" + name + '\'' +
                ", developersAmount=" + developersAmount +
                '}';
    }
}
