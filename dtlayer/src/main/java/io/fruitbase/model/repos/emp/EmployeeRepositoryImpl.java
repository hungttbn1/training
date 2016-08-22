package io.fruitbase.model.repos.emp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.fruitbase.model.entities.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> timTatCaNhanvien() {
		// TODO Auto-generated method stub
		return null;
	}

}
