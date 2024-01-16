package repository;

import jakarta.persistence.EntityManager;
import jpa_Entity.Salary;
import jpa_Entity.Salary;

import java.util.Optional;

public class SalaryRepositoryImpl implements SalaryRepository {

    private EntityManager entityManager;

    public SalaryRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Salary> save(Salary salary){
        try{
            entityManager.getTransaction().begin(); //*? Entity Manager opens .begin() the transaction
            if(salary.getId() == null){
                entityManager.persist(salary);
            } else {
                salary = entityManager.merge(salary);
            }
            entityManager.getTransaction().commit(); //? This is the closing with commit() everything is wrapped around that.

            return Optional.of(salary);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Salary> getSalaryById(Long id){
        Salary salary = entityManager.find(Salary.class, id);
        return salary != null ? Optional.of(salary) : Optional.empty();
    }

    @Override
    public void deleteSalary(Salary salary){
        entityManager.getTransaction().begin();

        if(entityManager.contains(salary)){
            entityManager.remove(salary);
        } else {
            entityManager.merge(salary);
        }

        entityManager.getTransaction().commit();
    }
}
