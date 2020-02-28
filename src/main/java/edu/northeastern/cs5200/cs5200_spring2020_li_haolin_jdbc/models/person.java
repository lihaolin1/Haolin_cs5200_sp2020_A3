package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;

//import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
//@Entity
public class person {
	private int person_id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String dob;
	
	//private int user_person_generalization;
	//public person getperson() {
	//	return person;
	//}
	// id
	public int getId() {
        return person_id;
    }
    public void setId(int person_id) {
        this.person_id = person_id;
    }
    // firstname
    public String getfirstname() {
        return firstname;
    }
    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }
    // lastname
    public String getlastname() {
        return lastname;
    }
    public void setlastname(String lastname) {
        this.lastname = lastname;
    }
    // username
    public String getusername() {
        return username;
    }
    public void setusername(String username) {
        this.username = username;
    }
    // password
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    // email
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    // dob
    public String getdob() {
        return dob;
    }
    public void setdob(String dob) {
        this.dob = dob;
    }
    //create person with name
    public person create_person_name(int id, String firstname, String lastname) {
    	this.person_id = id;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	return this;
    }
    //create person with more information
    public person create_person_all(int id, String firstname, String lastname, String username, String password, String email, String dob) {
    	this.person_id = id;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.username = username;
    	this.password = password; 
    	this.email = email;
    	this.dob = dob;
    	return this;
    }
    // developer_person_generalization
    //@OneToOne(mappedBy = "developer_personid")
    //private developer developer_person_generalization;
    // user_person_generalization
    //@OneToOne(mappedBy = "user_personid")
    //private user user_person_generalization;
    private Collection<developer> developer_person_generalization = new ArrayList<>();
    public Collection<developer> getdeveloper_person(){
    	return developer_person_generalization;
    }
    public void setdeveloper_person(Collection<developer> developer_person_generalization){
    	this.developer_person_generalization = developer_person_generalization;
    }
    //user
    private Collection<user> user_person_generalization = new ArrayList<>();
    public Collection<user> getuser_person(){
    	return user_person_generalization;
    }
    public void setuser_person(Collection<user> user_person_generalization){
    	this.user_person_generalization = user_person_generalization;
    }
    //to phone
    //@OneToMany(mappedBy = "pho_person_id")
    //private List<phone> person_phoneid;
    public Collection<phone> person_phone = new ArrayList<>();;
    //addphone(phone) { }
    //removephone(phone) { }
    
    //to address
    //@OneToMany(mappedBy = "address_person_id")
    //private List<address> person_addressid;
    public Collection<address> person_address = new ArrayList<>();;
    
    public person() {
    	
    }
}
