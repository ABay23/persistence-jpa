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


}
