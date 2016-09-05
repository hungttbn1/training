package io.fruitbase.business.services.testone.member;


import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.fruitbase.business.services.testone.dto.DateCreationRequest;
import io.fruitbase.business.services.testone.dto.MemberCreationRequest;
import io.fruitbase.model.entities.testone.member.Address;
import io.fruitbase.model.entities.testone.member.Member;
import io.fruitbase.model.repos.testone.member.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	
	@Autowired
	private MemberRepository memberRepository;
			
	@Override
	public List<Member> listAllMember() {		
		return memberRepository.findAll();
	}
		
	@Override
	public List<Member> findByStatusAndAddress(boolean status, String address) {		
		return memberRepository.findByStatusAndAddress(status, address);
	}
		
	@Override
	public List<Member> findByStatus(boolean status) {		
		return memberRepository.findByStatus(status);
	}

	@Override
	public List<Member> findByAddress(String address) {		
		return memberRepository.findByStreetCity(address);
	}
	
	@Override
	public List<Member> findByKeyword(String keyword) {		
		return memberRepository.findByKeyword(keyword);
	}
	
	@Override
	public Member findById(Long id) {
		return memberRepository.findOne(id);
	}
	
	@Override
	public Member findByToken(String token) {		
		return memberRepository.findByToken(token);
	}

	@Override
	public Member register(MemberCreationRequest request) {
		
		Member member = new Member();				
		BeanUtils.copyProperties(request, member);
		
		Address address = new Address();
		address.setCity(request.getCity());
		address.setStreet(request.getStreet());
		member.setAddress(address);
		
		long date = System.currentTimeMillis();		
		Timestamp timeStamp = new Timestamp(date);	
		member.setRegistrationTime(timeStamp);
		member.setStatus(false);
		
		String random = getSaltString();
		member.setCode(random);		
		
		return memberRepository.save(member);
	}
	
	/*@Override
	public Member login(MemberCreationRequest request) {
		
		return memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
	}*/
	
	@Override
	public Member activateMember(MemberCreationRequest request) {
		
		List<Member> members = memberRepository.findAll();
		Member member = new Member();
		
		for(Member member1 : members){
			if(request.getEmail().equals(member1.getEmail())){
				
				if(request.getCode().equals(member1.getCode())){
					
					member = memberRepository.findByEmail(request.getEmail());
					member.setPassword(member1.getPassword());
					member.setStatus(true);
					
					long date = System.currentTimeMillis();
					Timestamp timeStamp = new Timestamp(date);
					member.setApprovalTime(timeStamp);
					
					memberRepository.save(member);
					break;
				}
			}
		}
		return member;
			
	}
	
	
	@Override
	public Member login(String email) {
		Member member = memberRepository.findByEmail(email);
		UUID uuid = UUID.randomUUID();
		String token = uuid.toString();
		member.setToken(token);
		memberRepository.save(member);
		return member;
	}

	@Override
	public List<Member> findByRegistrationTimeLast12Hours() {
		long date = System.currentTimeMillis();
		date -= TimeUnit.HOURS.toMillis(12);
		Timestamp time = new Timestamp(date);
		return memberRepository.findByRegistrationTime(time);
	}
	

	
	@Override
	public List<Member> findByRegistrationTimeLast24Hours() {
		long date = System.currentTimeMillis();
		date -= TimeUnit.HOURS.toMillis(24);
		Timestamp time = new Timestamp(date);
		return memberRepository.findByRegistrationTime(time);
	}
	

	@Override
	public List<Member> findByRegistrationTimeLastWeek() {
		long date = System.currentTimeMillis();
		date -= TimeUnit.DAYS.toMillis(7);
		Timestamp time = new Timestamp(date);
		return memberRepository.findByRegistrationTime(time);
	}
	

	@Override
	public List<Member> findByRegistrationTimeLastMonth() {
		long date = System.currentTimeMillis();
		date -= TimeUnit.DAYS.toMillis(30);
		Timestamp time = new Timestamp(date);
		return memberRepository.findByRegistrationTime(time);
	}
	

	@Override
	public List<Member> findByRegstrationTime(DateCreationRequest date) {
		
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = stringToDate(date.getFromTime());
			toDate = stringToDate(date.getToTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		long millisFromDate = fromDate.getTime();
		long millisToDate = toDate.getTime();
		
		Timestamp fromTime = new Timestamp(millisFromDate);
		Timestamp toTime = new Timestamp(millisToDate);
			
		return memberRepository.findByRegistrationTime(fromTime, toTime);
	}

	@Override
	public String logout(Long id) {
		Member member = memberRepository.findOne(id);
		member.setToken(null);
		memberRepository.save(member);
		return "Logout";
	}

	
	//--------------------- Create a random string for register code ------------------
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	

	// ------------------convert String to date-----------------------------
	public Date stringToDate(String stringTime) throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = (Date) formatter.parse(stringTime);
		return date;
	}

	
	

	

	
	

	
	



	

}
