package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;
@Service
public class pageImpl implements pageDao{
	public pageImpl() {
		
	}
	@Override
	public void createPageForWebsite(int websiteId, page page) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
        String sql = "insert into page(page_id, title, description, created, updated, views, websitepid)values(?,?,?,?,?,?,?) ";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, page.getpageId());
            ps.setString(2, page.gettitle());
            ps.setString(3, page.getdescription());
            ps.setDate(4, page.getcreated());
            ps.setDate(5, page.getupdated());
            ps.setInt(6, page.getviews());
            ps.setInt(7, websiteId);//page.getwebdeveloperid().getwebsiteId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create page!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create page!");
	}
	
	public Collection<page> findAllPages() throws SQLException {
		List<page> page_collection = new ArrayList<page>(); //should I also return the widget information of website?
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        page pa = null;
        String sql = "select * from page";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();
        	while(rs.next()) {
        		pa = new page();
        		pa.setpageId(rs.getInt("page_id"));
        		pa.settitle(rs.getString("title"));
        		pa.setdescription(rs.getString("description"));
        		pa.setcreated(rs.getDate("created"));
        		pa.setupdated(rs.getDate("updated"));
        		pa.setviews(rs.getInt("views"));
        		
        		//page_collection.createPageForWebsite(rs.getInt("websitepid"), pa);
        		page_collection.add(pa);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to select all page!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to selecct all page!");
		return page_collection;
	}
	
	public page findPageById(int pageId) throws SQLException {
		page findpage = null;
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        page pa = null;
        String sql = "select * from page where page_id = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1, pageId);
        	rs = ps.executeQuery();
            if (rs.next()) {
            	pa = new page();
            	pa.setpageId(pageId);
            	pa.settitle(rs.getString("title"));
            	pa.setdescription(rs.getString("description"));
            	pa.setcreated(rs.getDate("created"));
            	pa.setupdated(rs.getDate("updated"));
            	pa.setviews(rs.getInt("views"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to search by page id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to search by page id!");
		return pa;
	}
	
	public Collection<page> findPagesForWebsite(int websiteId) throws SQLException {
		List<page> page_collection = new ArrayList<page>(); 
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        page pa = null;
        String sql = "select * from page where websitepid = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1, websiteId);
        	rs = ps.executeQuery();
        	
        	while(rs.next()) {
        		pa = new page();
        		pa.setpageId(rs.getInt("page_id"));
        		pa.settitle(rs.getString("title"));
        		pa.setdescription(rs.getString("description"));
        		pa.setcreated(rs.getDate("created"));
        		pa.setupdated(rs.getDate("updated"));
        		pa.setviews(rs.getInt("views"));
        		
        		//page_collection.createWebsiteForDeveloper(rs.getInt("websiteId"), pa);
        		page_collection.add(pa);
        	}
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to search page by website id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to search page by website id!");
		return page_collection;
	}

	public int updatePage(int pageId, page page) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update page set title = ?, description = ?, created = ?, updated = ?, views = ? where page_id = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	//ps.setInt(1, pageId);
        	//web = new website();
            ps.setString(1,page.gettitle());
            ps.setString(2, page.getdescription());
            ps.setDate(3, page.getcreated());
            ps.setDate(4, page.getupdated());
            ps.setInt(5, page.getviews());
            ps.setInt(6, pageId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to update page!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to update page!");
		return pageId;
	}
	
	public int deletePage(int pageId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ////////delete widget
        widgetImpl widget = new widgetImpl();
        Collection<widget>widget_to_delete = widget.findWidgetsForPage(pageId);
        Iterator<widget> it = widget_to_delete.iterator();
        while(it.hasNext()) {
        	widget.deleteWidget(it.next().getwidgetId());
        }
        ////////////////////////
        ////////delete pagerole
        
        String sql = "delete from page where page_id=?";
        String sql1 = "delete from page_role where page_id = ?";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps1 = conn.prepareStatement(sql1);
            //delete page role
            ps1.setInt(1,pageId);
            ps1.executeUpdate();
            //delete page
            ps.setInt(1,pageId);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("fail delete page!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete page!");
		
		return pageId;
	}
}
