package com.bida.dbconection.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "DeveloperProject")
@Table(name = "developers_projects")
public class DeveloperProject implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "developer_id")
    private long developerId;

    @Column(name = "project_id")
    private long projectId;

    public DeveloperProject(long developerId, long projectId) {
        this.developerId = developerId;
        this.projectId = projectId;
    }

    public DeveloperProject(){}

    public long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(long developerId) {
        this.developerId = developerId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getId(){return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeveloperProject)) return false;
        DeveloperProject that = (DeveloperProject) o;
        return getDeveloperId() == that.getDeveloperId() &&
                getProjectId() == that.getProjectId();
    }

    @Override
    public int hashCode(){
        return Integer.valueOf(String.valueOf(developerId) + String.valueOf(projectId));
    }

    @Override
    public String toString() {
        return "DevelopersProjects{" +
                "id=" + id +
                ", developerId='" + developerId + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
