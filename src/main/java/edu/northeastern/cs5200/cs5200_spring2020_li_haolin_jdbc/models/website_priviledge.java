package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

public class website_priviledge {
	private int webpid;
	private priviledge webpriviledge;
	private developer developerid;
	private website wpwebsiteid;
	
	// page role
	public int getwebpId() {
	    return webpid;
	}
	public void setwebpId(int webpid) {
	    this.webpid = webpid;
	}
	// priviledge
	public priviledge getwebpriviledge() {
        return webpriviledge;
    }
	// developer
	public developer getdeveloperId() {
        return developerid;
    }
	// pppageid
	public website getwpwebsiteId() {
        return wpwebsiteid;
    }
	
	public website_priviledge() {
		
	}
}
