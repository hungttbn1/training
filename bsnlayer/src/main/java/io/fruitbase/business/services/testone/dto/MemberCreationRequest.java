package io.fruitbase.business.services.testone.dto;







public class MemberCreationRequest {

	
	private String email;
	
	private String password;
	private String passwordConfirm;
	private String firstName;
	//private Address address;
	private String lastName;
	private String street;
	private String city;
	
	private String code;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
/*	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getStreet(){
		return getAddress().getStreet();
		
	}
	
	public void setStreet(String street){
		this.address.setStreet(street);
	}
	
	public String getCity(){
		return getAddress().getCity();
		
	}
	
	public void setCity(String city){
		this.address.setCity(city);
	}*/
	
	
}
