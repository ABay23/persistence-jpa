package repository;

import jakarta.persistence.EntityManager;
import jpa_Entity.Employee;

import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager){
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

    @Override
    public Optional<Employee> getEmployeeById(Long id){
        Employee employee = entityManager.find(Employee.class, id);
        return employee != null ? Optional.of(employee) : Optional.empty();
    }

    @Override
    public void deleteEmployee(Employee employee){
        entityManager.getTransaction().begin();

        if(entityManager.contains(employee)){
            entityManager.remove(employee);
        } else {
            entityManager.merge(employee);
        }

        entityManager.getTransaction().commit();
    }
}
