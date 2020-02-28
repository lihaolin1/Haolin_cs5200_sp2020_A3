package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
//import java.util.List;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.role;

public interface roleDao {
	void assignWebsiteRole(int developerId, int websiteId, int roleId) throws SQLException;
	 
    //refresh
	void assignPageRole(int developerId, int pageId, int roleId) throws SQLException;
 
    //delete
    //void delete(String role_name) throws SQLException;
 
    //find
    void deleteWebsiteRole(int developerId, int websiteId, int roleId) throws SQLException;
 
    //find all
    void deletePageRole(int developerId, int pageId, int roleId) throws SQLException;
}
