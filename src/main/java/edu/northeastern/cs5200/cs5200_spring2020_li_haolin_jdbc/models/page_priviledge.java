package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

public class page_priviledge {
	private int pagepid;
	private priviledge pagepriviledgeid;
	private developer ppdeveloperid;
	private page pppageid;
	
	// page role
	public int getpagepId() {
	    return pagepid;
	}
	public void setpagepId(int pagepid) {
	    this.pagepid = pagepid;
	}
	// priviledge
	public priviledge getpagepriviledgeId() {
        return pagepriviledgeid;
    }
	// developer
	public developer getdeveloperId() {
        return ppdeveloperid;
    }
	// pppageid
	public page getpageId() {
        return pppageid;
    }
	
	public page_priviledge() {
		
	}
	
}
