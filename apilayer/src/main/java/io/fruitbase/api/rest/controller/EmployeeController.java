package io.fruitbase.api.rest.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.fruitbase.business.dto.ResponseObject;
import io.fruitbase.business.services.dummy.dto.EmployeeCreationRequest;
import io.fruitbase.business.services.dummy.entity.Employee;
import io.fruitbase.business.services.dummy.service.DummyDataService;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> list(@RequestParam(value = "k", required = false) String keyword) {

		ResponseObject<Object> response = new ResponseObject<Object>();

		List<Employee> employees = StringUtils.isEmpty(keyword) ? DummyDataService.list()
				: DummyDataService.search(keyword);

		response.setResponseData(employees);

		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public final ResponseEntity<Object> create(@RequestBody EmployeeCreationRequest request) {

		ResponseObject<Object> response = new ResponseObject<Object>();
		Employee employee = DummyDataService.create(request);
		response.setResponseData(employee);

		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public final ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody EmployeeCreationRequest request) {

		ResponseObject<Object> response = new ResponseObject<Object>();
		Employee employee = DummyDataService.update(id, request);
		response.setResponseData(employee);

		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public final ResponseEntity<Object> delete(@PathVariable Integer id) {

		ResponseObject<Object> response = new ResponseObject<Object>();
		boolean isSuccess = DummyDataService.delete(id);
		response.setResponseData(isSuccess);

		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
}
