package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.Collection;
//import java.util.List;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website;

public interface websiteDao {
	//create
	void createWebsiteForDeveloper(int developerId, website website) throws SQLException;
	 
    //find all
	Collection<website> findAllWebsites() throws SQLException;
 
    //find website for developer
	Collection<website> findWebsitesForDeveloper(int developerId) throws SQLException;
 
    //find by id
	website findWebsiteById(int websiteId) throws SQLException;
 
    //update
	int updateWebsite(int websiteId, website website) throws SQLException;
	
	//delete
	int deleteWebsite(int websiteId) throws SQLException;
}
