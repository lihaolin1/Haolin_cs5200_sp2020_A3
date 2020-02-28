package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

public class page_role {
	private int pagerid;
	private role role_id;
	private developer developer_id;
	private page page_id;
	// page role
	public int getpagerId() {
        return pagerid;
    }
    public void setpagerId(int pagerid) {
        this.pagerid = pagerid;
    }
    // role id
    public role getroleId() {
        return role_id;
    }
//    public void setroleId(int role_id) {
//        this.role_id = role_id;
//    }
    // developer id
    public developer getdeveloperId() {
        return developer_id;
    }
//    public void setdeveloperId(int developerid) {
//        this.developer_id = developerid;
//    }
    // page id
    public page getpageId() {
        return page_id;
    }
//    public void setpageId(int pageid) {
//        this.page_id = pageid;
//    }
    
    public page_role() {
    	
    }
}
