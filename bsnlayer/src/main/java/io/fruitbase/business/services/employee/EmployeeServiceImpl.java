package io.fruitbase.business.services.employee;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.fruitbase.business.services.dummy.dto.EmployeeCreationRequest;
import io.fruitbase.model.entities.Employee;
import io.fruitbase.model.entities.Team;
import io.fruitbase.model.repos.emp.EmployeeRepository;
import io.fruitbase.model.repos.team.TeamRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRep;

	@Autowired
	private TeamRepository teamRp;

	@Override
	public Employee create(EmployeeCreationRequest request) {

		Employee emp = new Employee();
		BeanUtils.copyProperties(request, emp);

		Team team = teamRp.findOne(request.getTeamId());
		emp.setTeam(team);

		return employeeRep.save(emp);
	}

}
