package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass;

import javax.persistence.Table;

// this table is used in developerIntl to save the join table
public class developer_person {
	
	public int developer_id;
	public int person_id;
	public String firstname;
	public String lastname;
	public String username;
	public String password;
	public String email;
	public String dob;
	public String developer_key;
	public void developer_person_table(int developer_id, int person_id, String firstname, String lastname,String username,String password,String email,String dob,String developer_key) {	
		this.developer_id = developer_id;
		this.person_id = person_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.developer_key = developer_key;
	}
	
	public developer_person() {
		
	}
}
