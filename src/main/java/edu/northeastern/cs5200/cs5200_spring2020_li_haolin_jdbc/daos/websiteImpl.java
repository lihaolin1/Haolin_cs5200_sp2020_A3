package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;
@Service
public class websiteImpl implements websiteDao{
	@Override
	public void createWebsiteForDeveloper(int developerId, website w) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;	
        String sql = "insert into website(website_id, wname, description, creates, wupdates, visits,  developerwebid)values(?,?,?,?,?,?,?) ";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, w.getwebsiteId());
            ps.setString(2, w.getwname());
            ps.setString(3, w.getdescription());
            ps.setDate(4, w.getcreates());
            ps.setDate(5, w.getwupdates());
            ps.setInt(6, w.getvisits());
            ps.setInt(7, developerId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create website!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create website!");
	}
	
	@Override
	public Collection<website> findAllWebsites() throws SQLException {
		List<website> website_collection = new ArrayList<website>(); //should I also return the widget information of website?
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        website web = null;
        String sql = "select * from website";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();
        	while(rs.next()) {
        		web = new website();
        		web.setwebsiteId(rs.getInt("website_id"));
        		web.setwname(rs.getString("wname"));
        		web.setdescription(rs.getString("description"));
        		web.setcreates(rs.getDate("creates"));
        		web.setwupdates(rs.getDate("wupdates"));
        		web.setvisits(rs.getInt("visits"));
        		
        		//website_collection.createWebsiteForDeveloper(rs.getInt("developerwebid"), web);
        		website_collection.add(web);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to select all website!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to selecct all website!");
		return website_collection;
	}
	
	@Override
	public Collection<website> findWebsitesForDeveloper (int developerId) throws SQLException{
		List<website> website_developer_collection = new ArrayList<website>();
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        website web = null;
        String sql = "select * from website where developerwebid = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1, developerId);
        	rs = ps.executeQuery();
        	while(rs.next()) {
        		web = new website();
        		web.setwebsiteId(rs.getInt("website_id"));
        		web.setwname(rs.getString("wname"));
        		web.setdescription(rs.getString("description"));
        		web.setcreates(rs.getDate("creates"));
        		web.setwupdates(rs.getDate("wupdates"));
        		web.setvisits(rs.getInt("visits"));
        		//website_developer_collection.createWebsiteForDeveloper(rs.getInt("developerwebid"), web);
        		website_developer_collection.add(web);
        	}
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to search website by developer id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to search website by developer id!");
		return website_developer_collection;
	}
	
	@Override
	public website findWebsiteById(int websiteId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        website web = null;
        String sql = "select * from website where website_id = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1, websiteId);
        	rs = ps.executeQuery();
            if (rs.next()) {
            	web = new website();
            	web.setwebsiteId(websiteId);
            	web.setwname(rs.getString("wname"));
            	web.setdescription(rs.getString("description"));
            	web.setcreates(rs.getDate("creates"));
            	web.setwupdates(rs.getDate("wupdates"));
            	web.setvisits(rs.getInt("visits"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to search by website id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to search by website id!");
        return web;
    }

	@Override
	public int updateWebsite(int websiteId, website website) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //website web = null;
        String sql = "update website set wname = ?, description = ?, creates = ?, wupdates = ?, visits = ? where website_id = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	//ps.setInt(1, websiteId);
        	//web = new website();
            ps.setString(1,website.getwname());
            ps.setString(2, website.getdescription());
            ps.setDate(3, website.getcreates());
            ps.setDate(4, website.getwupdates());
            ps.setInt(5, website.getvisits());
            ps.setInt(6, websiteId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to update by website id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to update by website id!");
		return websiteId;
	}
	
	@Override
	public int deleteWebsite(int websiteId) throws SQLException {
		// should I also delete page?
		Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ///////////////////delete page
        pageImpl page = new pageImpl(); 
        Collection<page>page_to_delete = page.findPagesForWebsite(websiteId);
        Iterator<page> it = page_to_delete.iterator();
        while(it.hasNext()) {
        	page.deletePage(it.next().getpageId());
        }
        ////////////////////////
		String sql = "delete from website where website_id=?";
		String sql1 = "delete from website_role where wrwebsite_id = ?";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps1 = conn.prepareStatement(sql1);
            // delete website role
            ps1.setInt(1,websiteId);
            ps1.executeUpdate();
            //delete website
            ps.setInt(1,websiteId);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("fail delete website!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete website!");
		return websiteId;
	}
	
}
