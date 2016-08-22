/*package io.fruitbase.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.fruitbase.business.dto.ResponseObject;
import io.fruitbase.model.repos.StudentRepository;
import io.fruitbase.model.entities.Student;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
	@Autowired
	private StudentRepository sr;
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody // function return value
	public final ResponseEntity<Object> list(@RequestParam(value = "k", required = true) String firstname){
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Student> student = sr.findByFirstName(firstname);
		response.setResponseData(student);
		
		
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
}
*/