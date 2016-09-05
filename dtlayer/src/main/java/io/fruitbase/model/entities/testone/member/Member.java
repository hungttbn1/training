package io.fruitbase.model.entities.testone.member;


import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.Email;





@Entity
@Table(name = "member")

public class Member {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "registration_time", nullable = false)
	private Timestamp registrationTime;
	
	@Column(name = "approval_time", nullable = true)
	private Timestamp approvalTime;
	
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	
	@Embedded
	private Address address;
	
	@Column(name = "token", unique = true, nullable = true)
	private String token;

	public Member() {
		
	}

	public Member(Long id, String firstName, String lastName, String email, String password, boolean status, Timestamp registrationTime,
			Timestamp approvalTime, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.status = status;
		this.registrationTime = registrationTime;
		this.approvalTime = approvalTime;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
																		
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Timestamp getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Timestamp approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString(){
		return "\n [id:" + id + ",\n email:" + email + ",\n firstName:" + firstName +
				",\n lastName:" + lastName + ",\n registrationTime:" + registrationTime + ",\n status:" + status +
				",\n address: [\n      street:" + address.getStreet() + ",\n      city:" + address.getCity() + "\n]";
		
	}

	
	
}
