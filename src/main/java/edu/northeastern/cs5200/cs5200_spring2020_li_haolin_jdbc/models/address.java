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
public class address {
	private int address_id;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private boolean address_primary;
	//id
	public int getaddressId() {
		return address_id;
	}
	public void setaddressId(int address_id) {
		this.address_id = address_id;
	}
	//street1
	public String getstreet1() {
		return street1;
	}
	public void setstreet1(String street1) {
		this.street1 = street1;
	}
	//street2
	public String getstreet2() {
		return street2;
	}
	public void setstreet2(String street2) {
		this.street2 = street2;
	}
	//city
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	//state
	public String getstate() {
		return state;
	}
	public void setstate(String state) {
		this.state = state;
	}
	//zip
	public String getzip() {
		return zip;
	}
	public void setzip(String zip) {
		this.zip = zip;
	}
	//address_primary
	public boolean getaddprimary() {
		return address_primary;
	}
	public void setaddprimary(Boolean address_primary) {
		this.address_primary = address_primary;
	}
	
	public void setstreet2(boolean address_primary) {
		this.address_primary = address_primary;
	}
	
	//set more address
	public void setaddresses(String street1, String street2) {
		this.street1 = street1;
		this.street2 = street2;
	}
	
	public address address_create(int address_id, String street1, String street2, String city, String state, String zip, Boolean address_primary, person person) {
		this.address_id  = address_id;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.address_primary = address_primary;
		this.address_person_id = person;
		return this;
	}
	
	// foreign key address_person_id
	//@ManyToOne()
	//@JsonIgnore
	private person address_person_id;
	
	public person getpersonaddress() {
		return address_person_id;
	}
	public void setpersonaddress(person address_person_id) {
		this.address_person_id = address_person_id;
	}
	//public void setpersonaddress(person address_person_id) {
	//	this.address_person_id = address_person_id;
	//}
	
}
