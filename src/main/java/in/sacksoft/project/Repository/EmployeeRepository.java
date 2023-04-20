package in.sacksoft.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sacksoft.project.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

}
