package repository;

import jakarta.persistence.EntityManager;
import jpa_Entity.Employee;

import java.util.Optional;

public class EmployeeRepositotryImpl implements EmployeeRepository {

    private EntityManager entityManager;

    public EmployeeRepositotryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Employee> save(Employee employee){
        try{
            entityManager.getTransaction().begin(); //*? Entity Manager opens .begin() the transaction
            if(employee.getId() == null){
                entityManager.persist(employee);
            } else {
                employee = entityManager.merge(employee);
            }
            entityManager.getTransaction().commit(); //? This is the closing with commit() everything is wrapped around that.

            return Optional.of(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
