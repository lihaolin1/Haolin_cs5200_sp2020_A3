package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public class phone {
	private int phone_id;
	private String phone_number;
	private boolean phone_primary;
	
	//id
	public int getphoneId() {
	    return phone_id;
	}
	public void setphoneId(int phone_id) {
	    this.phone_id = phone_id;
	}
	//phone_number
	public void setphonenumber(String phonenumber) {
		this.phone_number =  phonenumber;
	}
	public String getphonenumber() {
		return phone_number;
	}
//	public void settitle(String phone_number) {
//		this.phone_number = phone_number;
//	}
	// primary
	public boolean getphoneprimary() {
		return phone_primary;
	}
	public void setphoneprimary(boolean phone_primary) {
		this.phone_primary = phone_primary;
	}
	
	public phone Phone_create(int phone_id, String phone_number, Boolean phone_primary, person d) {
		this.phone_id  = phone_id;
		this.phone_number = phone_number;
		this.phone_primary = phone_primary;
		this.pho_person_id = d;
		return this;
	}
	// to person
	//@ManyToOne()
	//@JsonIgnore
	private person pho_person_id;
	
	public person getpersonphone() {
		return pho_person_id;
	}
	public void setpersonphone(person pho_person_id) {
		this.pho_person_id = pho_person_id;
	}
	//public void setpersonphone(person pho_person_id) {
	//	this.pho_person_id = pho_person_id;
	//}
	
	//person pho_person_id;
	
}
