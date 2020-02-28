package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

public class website_role {
	private int webrid;
	private role webrole;
	private developer developer_wid;
	private website wrwebsite_id;
	// page role
	public int getwebrId() {
        return webrid;
    }
    public void setwebrId(int webrid) {
        this.webrid = webrid;
    }
    // role id
    public role getwebroleId() {
        return webrole;
    }
//    public void setwebroleId(int webrole) {
//        this.webrole = webrole;
//    }
    // developer id
    public developer getdeveloperwId() {
        return developer_wid;
    }
//    public void setdeveloperId(int developerid) {
//        this.developer_id = developerid;
//    }
    // page id
    public website getwrwebsiteId() {
        return wrwebsite_id;
    }
//    public void setwrwebsiteId(int wrwebsite_id) {
//        this.wrwebsite_id = wrwebsite_id;
//    }
    
    // create website role more
    public website_role websiteroleaddmore(int webrid, role webrole, developer developer_wid, website wrwebsite_id) {
    	this.webrid = webrid;
    	this.webrole = webrole;
    	this.developer_wid = developer_wid;
    	this.wrwebsite_id = wrwebsite_id;
    	return this;
    }
    
    public website_role() {
    	
    }
}
