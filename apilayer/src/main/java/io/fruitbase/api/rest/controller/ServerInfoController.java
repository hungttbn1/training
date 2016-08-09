package io.fruitbase.api.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.fruitbase.business.dto.ResponseObject;

@Controller
@RequestMapping(value = "/")
public class ServerInfoController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> getServerInfo() {

		ResponseObject<Object> response = new ResponseObject<Object>();
		
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("message", "Cool!!! Everything seems fine ^^!");

		response.setResponseData(info);

		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
}
