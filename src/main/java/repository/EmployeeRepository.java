package repository;

import jpa_Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> save(Employee employee);
    Optional<Employee> getEmployeeById(Long id);
    void deleteEmployee(Employee employee);
//    List<Employee> getEmployeesByExperience(Integer yearsExperience);
//    List<Employee> getEmployeesByExperienceNativeQuery(Integer yearsExperience);
}
