package io.fruitbase.business.services.testone.member;



import java.util.List;

import io.fruitbase.business.services.testone.dto.DateCreationRequest;
import io.fruitbase.business.services.testone.dto.MemberCreationRequest;
import io.fruitbase.model.entities.testone.member.Member;

/**
 * @author HungTaQuang
 *
 */

public interface MemberService {

	
	Member register(MemberCreationRequest request);
	
	//Member login(MemberCreationRequest request);
	
	Member login(String email);
	
	String logout(Long id);
	
	Member findById(Long id);
	
	Member findByToken(String token);
	
	List<Member> listAllMember();
	
	Member activateMember(MemberCreationRequest request);
	
	List<Member> findByStatusAndAddress(boolean status, String address);
	
	List<Member> findByStatus(boolean status);
	
	List<Member> findByAddress(String address);
	
	List<Member> findByRegistrationTimeLast12Hours();
	
	List<Member> findByRegistrationTimeLast24Hours();
	
	List<Member> findByRegistrationTimeLastWeek();
	
	List<Member> findByRegistrationTimeLastMonth();
	
	List<Member> findByRegstrationTime(DateCreationRequest date);
	
	List<Member> findByKeyword(String keyword);
	
	
}
