package net.therap.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/24/14
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "student")
public class Student extends User {

    @Column(name = "program")
    private String program;

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    @ManyToMany (targetEntity = Project.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable (name = "student_project",
            joinColumns = @JoinColumn (name = "student_id"),
            inverseJoinColumns = @JoinColumn (name = "project_id"))
    private Set<Project> projectList;

    public Set<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<Project> projectList) {
        this.projectList = projectList;
    }

}
