package io.fruitbase.business.services.employee;

import io.fruitbase.business.services.dummy.dto.EmployeeCreationRequest;
import io.fruitbase.model.entities.Employee;

public interface EmployeeService {

	Employee create(EmployeeCreationRequest request);
}
