package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.Collection;
//import java.util.List;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;

public interface widgetDao {
	//create
	void createWidgetForPage(int pageId, widget widget) throws SQLException;
	 
    //find all
	Collection<widget> findAllWidgets() throws SQLException;
 
    //find widget by id
	widget findWidgetById(int widgetId) throws SQLException;
 
    //find widget for page
	Collection<widget> findWidgetsForPage(int pageId) throws SQLException;
 
    //update
	int updateWidget(int widgetId, widget widget) throws SQLException;
	
	//delete
	int deleteWidget(int widgetId) throws SQLException;
}
