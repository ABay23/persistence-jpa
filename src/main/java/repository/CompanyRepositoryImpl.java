package repository;

import jakarta.persistence.EntityManager;
import jpa_Entity.Company;


import java.util.Optional;

public class CompanyRepositoryImpl implements CompanyRepository {


    private EntityManager entityManager;

    public CompanyRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Company> save(Company company){
        try{
            entityManager.getTransaction().begin(); //*? Entity Manager opens .begin() the transaction
            if(company.getId() == null){
                entityManager.persist(company);
            } else {
                company = entityManager.merge(company);
            }
            entityManager.getTransaction().commit(); //? This is the closing with commit() everything is wrapped around that.

            return Optional.of(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Company> getCompanyById(Long id){
        Company company = entityManager.find(Company.class, id);
        return company != null ? Optional.of(company) : Optional.empty();
    }

    @Override
    public void deleteCompany(Company company){
        entityManager.getTransaction().begin();

        if(entityManager.contains(company)){
            entityManager.remove(company);
        } else {
            entityManager.merge(company);
        }

        entityManager.getTransaction().commit();
    }
}
