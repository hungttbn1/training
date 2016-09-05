package io.fruitbase.api.rest.controller.testone.member;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
import io.fruitbase.business.services.testone.dto.DateCreationRequest;
import io.fruitbase.business.services.testone.dto.MemberCreationRequest;
import io.fruitbase.business.services.testone.member.MemberService;
import io.fruitbase.model.entities.testone.member.Member;

@Controller
@RequestMapping(value = "/members")
public class MemberController {

	
	@Autowired
	private MemberService memberService;
	
	
	// ------------------------Register new member-------------------------	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public final ResponseEntity<Object> resgiterMember(@RequestBody MemberCreationRequest request){
		ResponseObject<Object> response = new ResponseObject<Object>();
		String error = null;
		
		if(request.getPassword().equals(request.getPasswordConfirm())){
			Member member = memberService.register(request);
			response.setResponseData(member);
			
		}else{
			error = "Password invald";
			response.setResponseData(error);
		}
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//---------------------- Member login--------------------
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseEntity<Object> login(@RequestBody MemberCreationRequest request){
		ResponseObject<Object> response = new ResponseObject<>();
		String error = null;
		List<Member> members = memberService.listAllMember();
		
		for(Member member : members){
			
			if(request.getEmail().equals(member.getEmail())){
				
				if(request.getPassword().equals(member.getPassword())){
					member = memberService.login(request.getEmail());
					
					response.setResponseData(member);
					
				}else{
					error = "Password is incorrect!";
					response.setResponseData(error);
				}
				break;
			}else{
				error = "Email is incorrect";
				response.setResponseData(error);
			}
		}
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//--------------- Member logout to delete token----------------------
	
	@RequestMapping(value = "/logout/{id}", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> logout(@PathVariable Long id){
		ResponseObject<Object> response = new ResponseObject<Object>();
		String logout = memberService.logout(id);
		response.setResponseData(logout);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//------------------ Activate Member--------------------
	
	@RequestMapping(value = "/activate", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseEntity<Object> activateMember(@RequestBody MemberCreationRequest request){
		ResponseObject<Object> response = new ResponseObject<Object>();
		Member member = memberService.activateMember(request);
		response.setResponseData(member);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	// --------------------view detail member by id and token-------------------------
	
	@RequestMapping(value = "/{id}/{token}", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> findById(@PathVariable Long id, @PathVariable String token){
		ResponseObject<Object> response = new ResponseObject<Object>();
		String error = "Error";
		Member member = memberService.findById(id);
		if (token.equals(member.getToken())){
			
			response.setResponseData(member.toString());
		}else{
			response.setResponseData(error);
		}
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//--------------------list all member by token-------------------------
	
	@RequestMapping(value = "/listAll/{token}", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> listAll(@PathVariable String token){
		ResponseObject<Object> response = new ResponseObject<Object>();
		String error = "Error";
		List<Member> members = memberService.listAllMember();
		for (Member member : members){
			if (token.equals(member.getToken())){
				response.setResponseData(members);
				break;
			}else {
				response.setResponseData(error);
			}
		}
		
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	// ----------------------------list member by keyword (email, firstname, lastname, street, city)---------------------------
	
	@RequestMapping(value = "/listByKeyword", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> listByKeyword(@RequestParam(value = "k", required = true) String keyword){
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Member> members = memberService.findByKeyword(keyword);
		response.setResponseData(members);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//------------------------- view member registration last 12 hour------------------------------------
	
	@RequestMapping(value = "/listRegistrationLast12Hour", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> listLast12Hour(){
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Member> members = memberService.findByRegistrationTimeLast12Hours();
		response.setResponseData(members);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//------------------------- view member registration last 24 hour------------------------------------
	
	@RequestMapping(value = "/listRegistrationLast24Hour", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> listLast24Hour(){
		
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Member> members = memberService.findByRegistrationTimeLast24Hours();
		response.setResponseData(members);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//------------------------- view member registration last week------------------------------------
	
	
	@RequestMapping(value = "/listRegistrationLastWeek", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> listLastWeek(){
		ResponseObject<Object> response = new ResponseObject<Object>();
		
		List<Member> members = memberService.findByRegistrationTimeLastWeek();
		response.setResponseData(members);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//------------------------- view member registration last month ------------------------------------
	
	@RequestMapping(value = "/listRegistrationLastMonth", method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> listLastMonth(){
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Member> members = memberService.findByRegistrationTimeLastMonth();
		response.setResponseData(members);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//------------------------- view member registration dd/mm/yyyy to dd/mm/yyyy------------------------------------
	
	@RequestMapping(value = "/listRegistrationDateToDate", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseEntity<Object> listDateToDate(@RequestBody DateCreationRequest date){
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Member> members = memberService.findByRegstrationTime(date);
		response.setResponseData(members);
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//-------------------------------List by filter by status, address-----------------------------------------
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<Object> findByStatusOrAddress(@RequestParam(value = "s", required = false)Boolean status, @RequestParam(value = "a", required = false) String address){
		ResponseObject<Object> response = new ResponseObject<Object>();
		List<Member> members;
		if(StringUtils.isEmpty(address)){
			members = memberService.findByStatus(status);
		}
		else if(StringUtils.isEmpty(status)){
			members = memberService.findByAddress(address);
		}
		else{
			members = memberService.findByStatusAndAddress(status, address);
		}
		//List<Member> members = StringUtils.isEmpty(address) ? memberService.findByStatusAndAddress(status, address) : memberService.findByStatus(status);
		response.setResponseData(members);
		
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
		
	}
	

	
	
	
	
	/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseEntity<Object> login(@RequestBody MemberCreationRequest request){
		ResponseObject<Object> response = new ResponseObject<>();
		String error = null;
		try{
			Member member = memberService.login(request);
			response.setResponseData(member);
			
		
		}catch (Exception e){
			error = "Invald";
			response.setResponseData(error);
			
		}
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.OK);
	}*/
}
