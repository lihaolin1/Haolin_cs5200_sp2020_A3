package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

import java.util.ArrayList;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
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
//
//import com.fasterxml.jackson.annotation.JsonIgnore;

//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.Connection;

//@Entity
public class developer{
	private int developer_id;
	private String developer_key;
	//public int developer_id;
	//public String developer_key;
	// id
	public int getId() {
        return developer_id;
    }
    public void setId(int developer_id) {
        this.developer_id = developer_id;
    }
    // developer_key
    public String getkey() {
        return developer_key;
    }
    public void setkey(String developer_key) {
        this.developer_key = developer_key;
    }
    
    //when add something here
    
    public developer setadddeveloper1( int DeveloperID, String developer_key, int personid, String developer_firstname, String developer_lastname) {
    	person person1 = new person();
    	this.developer_id = DeveloperID;
    	this.developer_key = developer_key;
    	this.developer_personid = person1.create_person_name(personid, developer_firstname, developer_lastname);
    	//person1.create_person_name(personid, developer_firstname, developer_lastname);
    	return this;
    }
    
    //when add more
    public developer setadddeveloper2(int DeveloperID,String developer_key, int personid, String developer_firstname, String developer_lastname, String username, String password, String email, String dob) {
    	person person1 = new person();
    	this.developer_id = DeveloperID;
    	this.developer_key = developer_key;
    	this.developer_personid = person1.create_person_all(personid, developer_firstname, developer_lastname, username, password, email, dob);
    	//person1.create_person_all(personid, developer_firstname, developer_lastname, username, password, email, dob);
    	return this;
    }
    // when add more more
    
    public void setadddeveloper3(int DeveloperID, String developer_key, int personid, String developer_firstname, String developer_lastname, String username, String password, String email, String dob, String street1, String street2, String phone_number) {
    	address address = new address();
        phone phone = new phone();
        person person1 = new person();
    	this.developer_id = DeveloperID;
    	this.developer_key = developer_key;
    	this.developer_personid = person1.create_person_all(personid, developer_firstname, developer_lastname, username, password, email, dob);
    	//person1.create_person_all(personid, developer_firstname, developer_lastname, username, password, email, dob);
    	address.setaddresses(street1, street2);
    	phone.setphonenumber(phone_number);
    	
    }
    
    //public person create_person;
    //public person help() {
	//	return developer_personid;
	//}
//    Connection conn = null;
//    conn = DriverManager.getConnection("cs5200-spring2020-a2.ccgpqnp6qpps.us-east-2.rds.amazonaws.com/A2_dataset","haolin","cs5200haolin");
//    Statement statement = conn.createStatement();
//    String sql =	"select person_id,firstname, lastname "
//			+ "from person";
//    ResultSet  result = statement.executeQuery(sql);
//    public void setadddeveloper1(String developer_key, int DeveloperID, String developer_firstname, String developer_lastname) {
//    	this.developer_key = developer_key;
//        this.developer_id = DeveloperID;
//        while(result.next()) {
//        if(result.getString("firstname") == developer_firstname && result.getString("lastname") == developer_lastname) {
//        	this.developer_personid = result;//.getString("person_id") ;
//        }
//        }
//    }
    
    
    // to person
    //@OneToOne()
    //@JsonIgnore
    private person developer_personid;
//    public int getdpId() {
//        return developer_personid;
//    }
//    public void setdpId(int developer_personid) {
//        this.developer_personid = developer_personid;
//    }
    public void setpersondeveloperid(person developer_personid) {
    	this.developer_personid = developer_personid;
    }
    
    public person getpersondeveloper() {
		return developer_personid;
	}
    //to website
    //@OneToMany(mappedBy = "developerwebid")
    //private List<website> dep_websiteid;
    public Collection<website> dep_websiteid= new ArrayList<>();
    
    //page role
    public Collection<page_role> dep_pagerole= new ArrayList<>();
    
    //website role
    public Collection<website_role> dep_websiterole= new ArrayList<>();
    
    // page priviledge
    public Collection<page_priviledge> page_priviledgecollection= new ArrayList<>();
    
    //website priviledge
    public Collection<website_priviledge> website_priviledgecollection= new ArrayList<>();
    
    public developer() {
    	
    }
}
