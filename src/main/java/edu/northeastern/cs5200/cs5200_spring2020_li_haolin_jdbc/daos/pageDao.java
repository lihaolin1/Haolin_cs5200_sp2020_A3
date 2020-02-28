package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;

public interface pageDao {
	//create page
	void createPageForWebsite(int websiteId, page page) throws SQLException;
	 
    //find all
	Collection<page> findAllPages() throws SQLException;
 
    //find page by id
	page findPageById(int pageId) throws SQLException;
 
    //find page for web
	Collection<page> findPagesForWebsite(int websiteId) throws SQLException;
 
    //update
	int updatePage(int pageId, page page) throws SQLException;
	
	//delete
	int deletePage(int pageId) throws SQLException;
}
