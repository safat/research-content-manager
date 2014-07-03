package net.therap.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/24/14
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "supervisor")
public class Supervisor extends User {

    @Column(name = "designation")
    private String designation;

    @ManyToMany (targetEntity = Project.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable (name = "supervisor_project",
            joinColumns = @JoinColumn (name = "supervisor_id"),
            inverseJoinColumns = @JoinColumn (name = "project_id"))
    private Set<Project> projectList;

    public String getDesignation() {

        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Set<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                '}';
    }
}
