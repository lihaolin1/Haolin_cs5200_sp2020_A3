package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.List;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.priviledge;

public interface priviledgeDao {
	//create
	void assignWebsitePrivilege(int developerId, int websiteId, String priviledge) throws SQLException;
	 
    //assign
	void assignPagePriviledge(int developerId, int pageId, String priviledge) throws SQLException;
 
    //delete web p
	void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) throws SQLException;
 
    //delete page p
	void deletePagePriviledge(int developerId, int pageId, String priviledge) throws SQLException;
 
    //find all
    //List<priviledge> findAll()throws SQLException;
}
