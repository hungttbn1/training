package io.fruitbase.business.services.dummy.service;
/*package io.fruitbase.business.services.dummy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.BeanUtils;

import io.fruitbase.business.services.dummy.dto.EmployeeCreationRequest;
import io.fruitbase.business.services.dummy.entity.Employee;
import io.fruitbase.business.services.dummy.entity.NormalStaff;
import io.fruitbase.business.services.dummy.entity.ProjectManager;
import io.fruitbase.business.services.dummy.entity.TeamLeader;

public final class DummyDataService {
	
	private static final AtomicInteger AUTOMIC_NUMBER = new AtomicInteger(0);

	private DummyDataService() {
	}
	// Map tap du lieu kieu key-value
	public static final Map<Integer, Employee> EMPLOYEE_DATA = new HashMap<>();

	public static List<Employee> list() {
		return new ArrayList<>(EMPLOYEE_DATA.values());
	}

	public static List<Employee> search(String keyword) {

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

	public static Employee create(EmployeeCreationRequest request) {

		String type = request.getType();
		Employee employee = null;

		if (NormalStaff.class.getSimpleName().equalsIgnoreCase(type)) {

			employee = new NormalStaff();

		} else if (TeamLeader.class.getSimpleName().equalsIgnoreCase(type)) {

			employee = new TeamLeader();

		} else if (ProjectManager.class.getSimpleName().equalsIgnoreCase(type)) {
			employee = new ProjectManager();
		}
		// copy properties tu` employee sang request
		BeanUtils.copyProperties(request, employee);
		
		int id = AUTOMIC_NUMBER.incrementAndGet();
		employee.setId(id);

		EMPLOYEE_DATA.put(id, employee);

		return employee;
	}

	public static Employee update(Integer id, EmployeeCreationRequest request) {
		Employee employee = EMPLOYEE_DATA.get(id);
		BeanUtils.copyProperties(request, employee);
		return employee;
	}

	public static boolean delete(Integer id) {
		if (EMPLOYEE_DATA.containsKey(id)) {
			EMPLOYEE_DATA.remove(id);
			return true;
		}
		return false;
	}

}
*/