/*package io.fruitbase.business.services.dummyservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import io.fruitbase.business.services.dummy.dto.EmployeeCreationRequest;
import io.fruitbase.service.entities.Employee;
import io.fruitbase.service.entities.NormalStaff;
import io.fruitbase.service.entities.ProjectManager;
import io.fruitbase.service.entities.TeamLeader;


@Service
public class DummyDataServiceImpl implements DummyDataService {
	
	

	private static final AtomicInteger AUTOMIC_NUMBER = new AtomicInteger();

	public DummyDataServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static final Map<Integer, Employee> EMPLOYEE_DATA = new HashMap<>();

	@Override
	public List<Employee> list() {
		
		
		
		return new ArrayList<>(EMPLOYEE_DATA.values());
		
	}

	@Override
	public List<Employee> search(String keyword) {

		List<Employee> employees = new ArrayList<>();
		for (Employee employee : EMPLOYEE_DATA.values()) {

			String name = employee.getName();
			String email = employee.getEmail();
			if (name.contains(keyword) || email.contains(keyword)) {
				employees.add(employee);
			}
		}
		return employees;
	}

	@Override
	public Employee create(EmployeeCreationRequest request) {
		String type = request.getType();
		Employee employee = null;

		if (NormalStaff.class.getSimpleName().equalsIgnoreCase(type)) {
			employee = new NormalStaff();

		} else if (ProjectManager.class.getSimpleName().equalsIgnoreCase(type)) {
			employee = new ProjectManager();

		} else if (TeamLeader.class.getSimpleName().equalsIgnoreCase(type)) {
			employee = new TeamLeader();

		}

		BeanUtils.copyProperties(request, employee);
		int id = AUTOMIC_NUMBER.incrementAndGet();

		employee.setId(id);

		EMPLOYEE_DATA.put(id, employee);
		return employee;
	}

	@Override
	public Employee update(Integer id, EmployeeCreationRequest request) {
		Employee employee = EMPLOYEE_DATA.get(id);
		BeanUtils.copyProperties(request, employee);
		return employee;
	}

	@Override
	public boolean delete(Integer id) {
		if (EMPLOYEE_DATA.containsKey(id)) {
			EMPLOYEE_DATA.remove(id);
			return true;
		}
		return false;
	}

}
*/