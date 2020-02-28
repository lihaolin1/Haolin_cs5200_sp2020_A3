package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection;

@Service
public class roleImpl implements roleDao{
	public roleImpl() {
		
	}
	@Override
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into website_role(webrole, developer_wid, wrwebsite_id)values(?,?,?)";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setInt(2, developerId);
            ps.setInt(3, websiteId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create website role!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create website role!");
	}
	
	@Override
	public void assignPageRole(int developerId, int pageId, int roleId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into page_role(role_id, developer_id, page_id)values(?,?,?)";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setInt(2, developerId);
            ps.setInt(3, pageId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create page role!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create page role!");
	}
	
	@Override
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from website_role where developer_wid = ? and wrwebsite_id = ? and webrole = ?";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, developerId);
            ps.setInt(2, websiteId);
            ps.setInt(3, roleId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed delete website role!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete website role!");
	}
	
	@Override
	public void deletePageRole(int developerId, int pageId, int roleId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from page_role where role_id = ? and developer_id = ? and page_id = ?";
        try {
            conn = myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setInt(2, developerId);
            ps.setInt(3, pageId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed delete page role!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete page role!");
	}
}
