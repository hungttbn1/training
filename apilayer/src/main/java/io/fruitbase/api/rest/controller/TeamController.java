package io.fruitbase.api.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import io.fruitbase.business.dto.ResponseObject;
import io.fruitbase.business.services.team.TeamService;
import io.fruitbase.model.entities.Team;



@Controller
@RequestMapping(value = " /teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public final ResponseEntity<Object> create(@RequestBody Team team){
		ResponseObject<Object> response = new ResponseObject<Object>();
		team = teamService.create(team);
		response.setResponseData(team);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> list(){
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Team> teams = teamService.listAll();
		response.setResponseData(teams);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/{name}", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> findByName(@PathVariable String name){
		ResponseObject<Object> response = new ResponseObject<>();
		Team team = teamService.findByName(name);
		response.setResponseData(team);
		
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public final ResponseEntity<Object> delete(@PathVariable Integer id){
		
		ResponseObject<Object> response = new ResponseObject<Object>();
		boolean isSuccess = teamService.delete(id);
		response.setResponseData(isSuccess);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public final ResponseEntity<Object> update(@PathVariable int id, @RequestBody Team team){
		ResponseObject<Object> response = new ResponseObject<Object>();
		team = teamService.update(id, team);
		response.setResponseData(team);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
		
	}
}
