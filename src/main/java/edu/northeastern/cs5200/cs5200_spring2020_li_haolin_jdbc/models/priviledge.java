package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

import java.util.Collection;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Table;

public class priviledge {
	private String priviledge_name;
	// priviledge
	public String getpriviledge() {
		return priviledge_name;
	}
	public void setpriviledge(String priviledge_name) {
		this.priviledge_name = priviledge_name;
	}
	
	// to page priviledge
	public Collection<page_priviledge> save_pagepriviledge;
	
	// to website priviledge
	public Collection<website_priviledge> save_websitepriviledge;
	
	public priviledge() {
		
	}
}
