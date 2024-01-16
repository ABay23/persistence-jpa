import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jpa_Entity.Employee;
import jpa_Entity.Salary;
import repository.EmployeeRepositoryImpl;

import java.util.Optional;

public class Main {

    @PersistenceContext
    EntityManager entityManager;
    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(entityManager);

        //* create a new employee
        Employee employee = new Employee();
        employee.setFname("Mary");
        employee.setLname("Doe");
        employee.setYearsExperience(20);

        //* set salary
//        employee.setSalary(new Salary(54000.00, true));

        //* save employee
//        Optional<Employee> savedEmployee = employeeRepository.save(employee);

//        System.out.println("Don't forget to launch Postgres before running this code!");

        entityManager.close();
        entityManagerFactory.close();
    }
}
