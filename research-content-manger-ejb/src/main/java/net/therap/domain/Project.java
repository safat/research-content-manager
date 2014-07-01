package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/23/14
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToMany(mappedBy = "projectList", fetch = FetchType.LAZY)
    private Set<Supervisor> supervisorList;

    @ManyToMany(mappedBy = "projectList", fetch = FetchType.LAZY)
    private Set<Student> studentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Supervisor> getSupervisorList() {
        return supervisorList;
    }

    public void setSupervisorList(Set<Supervisor> supervisorList) {
        this.supervisorList = supervisorList;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", supervisorList=" + supervisorList +
                ", studentList = " + studentList +

                '}';
    }
}
