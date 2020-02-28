package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public class user {
	private int user_id;
	private String user_agreement;
	// id
	public int getId() {
        return user_id;
    }
    public void setId(int user_id) {
        this.user_id = user_id;
    }
    // user_agreement
    public String getagreement() {
        return user_agreement;
    }
    public void setagreement(String user_agreement) {
        this.user_agreement = user_agreement;
    }
    
    //create user with some person information
   
    public void createusermore(int userid, String user_agreement, int personid, String firstname, String lastname) {
    	person person = new person();
    	this.user_id = userid;
    	this.user_agreement = user_agreement;
    	this.user_personid = person.create_person_name(personid, firstname, lastname);
    }
    
    
    public user createusermore1(int userid, String user_agreement, int personid, String firstname, String lastname, String username, String password, String email, String dob) {
    	person person1 = new person();
    	this.user_id = userid;
    	this.user_agreement = user_agreement;
    	this.user_personid = person1.create_person_all(personid, firstname, lastname, username, password, email, dob);
    	return this;
    }
    
    //for person table
    //@OneToOne()
    //@JsonIgnore
    private person user_personid;
    
	public person getpersonuser() {
		return user_personid;
	}
	public void setpersonuser(person user_personid) {
		this.user_personid = user_personid;
	}
	//public void setpersonuser(person user_personid) {
	//	this.user_personid = user_personid;
	//}
    
    public user() {
    	
    }
}
