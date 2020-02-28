package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

import java.util.Collection;
import java.sql.Date;
//import java.util.List;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.Entity;

//@Entity
public class page {
	private int page_id;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int views;
	
	// id
		public int getpageId() {
		    return page_id;
		}
		public void setpageId(int page_id) {
		    this.page_id = page_id;
		}
		// name
		public String gettitle() {
			return title;
		}
		public void settitle(String title) {
			this.title = title;
		}
		// description
		public String getdescription() {
			return description;
		}
		public void setdescription(String description) {
			this.description = description;
		}
		// created
		public Date getcreated() {
			return created;
		}
		public void setcreated(Date created) {
			this.created = created;
		}
		// updated
		public Date getupdated() {
			return updated;
		}
		public void setupdated(Date updated) {
			this.updated = updated;
		}
		// visits
		public int getviews() {
			return views;
		}
		public void setviews(int views) {
			this.views = views;
		}
		
		//add more page information
		public page setpagemore(int pageid, String title, String description, Date createdate, Date updatedate, int views) {
			this.page_id = pageid;
			this.title = title;
			this.description = description;
			this.created = createdate;
			this.updated = updatedate;
			this.views = views;
			return this;
		}
		
		//int websitepid
		//@ManyToOne()
		//@JsonIgnore
		private website websitepid; //foreigner key
		public website getwebdeveloperid() {
			return websitepid;
		}
		
		//page_role
		public Collection<page_role> page_role;
		
		//to widget
		//@OneToMany(mappedBy = "pageid")
		public Collection<widget> page_widgetid;
		
		//to page collection
		public Collection<page_priviledge> page_priviledgecollection;
		
		public page() {
			
		}
}
