package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

import java.util.Collection;
import java.sql.Date;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public class website {
	private int website_id;
	private String wname;
	private String description;
	private Date creates;
	private Date wupdates;
	private int visits;
	
	// id
	public int getwebsiteId() {
	    return website_id;
	}
	public void setwebsiteId(int website_id) {
	    this.website_id = website_id;
	}
	// name
	public String getwname() {
		return wname;
	}
	public void setwname(String wname) {
		this.wname = wname;
	}
	// description
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	// creates
	public Date getcreates() {
		return creates;
	}
	public void setcreates(Date creates) {
		this.creates = creates;
	}
	// wupdates
	public Date getwupdates() {
		return wupdates;
	}
	public void setwupdates(Date wupdates) {
		this.wupdates = wupdates;
	}
	// visits
	public int getvisits() {
		return visits;
	}
	public void setvisits(int visits) {
		this.visits = visits;
	}
	
	//addmore website
	public website websiteaddmore(int websiteid, String webname, String webdescription, Date createdate, Date updatedate, int visits) {
		this.website_id = websiteid;
		this.wname = webname;
		this.description = webdescription;
		this.creates = createdate;
		this.wupdates = updatedate;
		this.visits = visits;	
		//this.developerwebid = developerid;
		return this;
	}
	
	//int developerwebid
	//@ManyToOne()
	//@JsonIgnore
	private developer developerwebid; //foreigner key
	public developer getwebdeveloperid() {
		return developerwebid;
	}
	
	//website_role
	public Collection<website_role> websiterolecollection;
	
	//website priviledge
	public Collection<website_priviledge> websitepriviledgecollection;
	
	//to page
	//@OneToMany(mappedBy = "websitepid")
	public Collection<page> web_pageid;
	
	public website() {
		
	}
}
