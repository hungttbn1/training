package io.fruitbase.model.repos.testone.member;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.fruitbase.model.entities.testone.member.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom{

	
	Member findByEmailAndPassword(String email, String password);
	
	Member findByEmail(String email);
	
	Member findByToken(String token);
	
	List<Member> findByStatus(boolean status);
		
	//---------------- List by filter by status, address ----------------
	@Query("select m from Member m where m.status = ?1 and ((m.address.street like %?2%) or (m.address.city like %?2%))")
	List<Member> findByStatusAndAddress(boolean status, String address);
	
	
	//---------------- List by filter by status, address ----------------
	@Query("select m from Member m where (m.address.street like %?1%) or (m.address.city like %?1%)")
	List<Member> findByStreetCity(String streetCity);
	
	
	// ------------------List all members who register last 12, 24 hour, 1 week, 1 month--------------------------
	@Query("select m from Member m where m.registrationTime > ?1")
	List<Member> findByRegistrationTime(Timestamp timeStamp);
	
	//--------------List member registration dd/mm/yyyy to dd/mm/yyyy---------------------
	@Query("select m from Member m where m.registrationTime between ?1 and ?2")
	List<Member> findByRegistrationTime(Timestamp fromTime, Timestamp toTime);
	
	//---------------- List by filter by keyword ----------------
	@Query("select m from Member m where (m.email like %?1%) or (m.firstName like %?1%) or (m.lastName like %?1%)"
			+ " or (m.address.street like %?1%) or (m.address.city like %?1%)")
	List<Member> findByKeyword(String keyword);
}
