package jpa_Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "employees")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private Long id;

    @Column
    private String fname;

    @Column
    private String lname;

    @Column
    private Integer yearsExperience;

    @Transient
    private Double totalCompensation;

    public Employee(){

    }

    public Employee (Long id, String fname, String lname, Integer yearsExperience){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.yearsExperience = yearsExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Integer yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Double getTotalCompensation() {
        return totalCompensation;
    }

    public void setTotalCompensation(Double totalCompensation) {
        this.totalCompensation = totalCompensation;
    }
}
