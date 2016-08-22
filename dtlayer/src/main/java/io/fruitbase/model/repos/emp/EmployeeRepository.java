package io.fruitbase.model.repos.emp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.fruitbase.model.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {

	// public <EmployeeCreationRequest> Employee create(EmployeeCreationRequest
	// request);

	List<Employee> findByName(String name);
	
	@Query("select e from Employee e where e.email like %:email%")
	Employee searchByEmail(@Param("email") String email);

}
