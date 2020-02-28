package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.phone;
@Service
public class phoneImpl implements phoneDao{
	public phoneImpl() {
		
	}
	@Override
	public void createphone(phone p) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
        String sql = "insert into phone(phone_number, phone_primary, pho_person_id)values(?,?,?) ";
        try {
        	conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getphonenumber());
            ps.setBoolean(2, p.getphoneprimary());
            ps.setInt(3, p.getpersonphone().getId());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create phone!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create phone!");
	}
	 
    //refresh
	@Override
    public void updatephone(phone p, String phone_number) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
        String sql = "update phone set phone_number = ?, phone_primary = ? where phone_id = ?";//, pho_person_id = ?
        try {
        	conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone_number);
            ps.setBoolean(2, p.getphoneprimary());
            //ps.setInt(3, p.getpersonphone().getId());
            ps.setInt(3, p.getphoneId());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed update phone!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success update phone!");
	}
    
 
    //delete
	@Override
    public void deletephone(String phone_number) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
        String sql = "delete * from phone where phone_number = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone_number);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed delete phone!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete phone!");
	}
	@Override
    public phone findphoneBynumber(String phone_number) throws SQLException{
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        phone save_phone = new phone();
        //PreparedStatement ps1 = null;
        String sql = "select * from phone where phone_number = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone_number);
            rs = ps.executeQuery();
            if(rs.next()) {
            save_phone.setphoneId(rs.getInt("phone_id"));
            save_phone.setphonenumber(rs.getString("phone_number"));
            save_phone.setphoneprimary(rs.getBoolean("phone_primary"));
            //ps.setInt(rs.getInt("person"));
            //save_phone.setpersonphone((person) rs.getInt("pho_person_id"));
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed find phone!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success find phone!");
        return save_phone;
	}
	@Override
    public Collection<phone> findAllphones() throws SQLException{
    	List<phone> phone_collection = new ArrayList<phone>(); //should I also return the widget information of website?
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        phone ph = null;
        String sql = "select * from phone";
        try {
        	conn = myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();
        	while(rs.next()) {
        		ph = new phone();
        		ph.setphoneId(rs.getInt("phone_id"));
        		ph.setphonenumber(rs.getString("phone_number"));
        		ph.setphoneprimary(rs.getBoolean("phone_promary"));
        		//ph.setpersonphone();
//        		ph.setcreated(rs.getDate("created"));
//        		ph.setupdated(rs.getDate("updated"));
//        		ph.setviews(rs.getInt("views"));
        		
        		//page_collection.createPageForWebsite(rs.getInt("websitepid"), pa);
        		phone_collection.add(ph);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to select all page!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to selecct all page!");
		return phone_collection;
	}
    
    
    
}
