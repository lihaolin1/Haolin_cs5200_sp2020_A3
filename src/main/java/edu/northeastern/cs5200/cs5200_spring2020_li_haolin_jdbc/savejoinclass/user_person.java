package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass;

public class user_person {
	public int user_id;
	public int person_id;
	public String firstname;
	public String lastname;
	public String username;
	public String password;
	public String email;
	public String dob;
	public Boolean user_agreement;
	public void developer_person_table(int user_id, int person_id, String firstname, String lastname,String username,String password,String email,String dob,Boolean user_agreement) {	
		this.user_id = user_id;
		this.person_id = person_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.user_agreement = user_agreement;
	}
	
	public user_person() {
		
	}
}
