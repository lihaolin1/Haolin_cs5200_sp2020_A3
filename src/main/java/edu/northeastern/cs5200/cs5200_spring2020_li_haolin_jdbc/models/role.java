package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

import java.util.Collection;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
////import javax.persistence.Id;
//import javax.persistence.Table;

public class role {
	private int role_id;
	private String role_name;
	//role id
	public int getroleid() {
		return role_id;
	}

	// rolename
	public String getrolename() {
		return role_name;
	}
	public void setrolename(String role_name) {
		this.role_name = role_name;
	}
	
	//page role
	public Collection<page_role> pagerolecollection;
	//website role
	public Collection<website_role> websiterolecollection;
	
	public role() {
		
	}
}
