package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.address;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;

public class addressImpl {
	public void createaddress(address a) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
        String sql = "insert into address(street1, street2, city, state, zip, address_primary, address_person_id)values(?,?,?,?,?,?,?) ";
        try {
        	conn = myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getstreet1());
            ps.setString(2, a.getstreet2());
            ps.setString(3, a.getcity());
            ps.setString(4, a.getstate());
            ps.setString(5, a.getzip());
            ps.setBoolean(6, a.getaddprimary());
            ps.setInt(7, a.getpersonaddress().getId());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create address!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create address!");
	}
	 
    //refresh
    public void updateaddress(int address_id, address a) throws SQLException{
    	Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
        String sql = "update phone set street1 = ?, street2 = ?, city = ?, state = ?, zip = ?, address_primary = ?, address_person_id = ? where address_id = ?";
        try {
        	conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getstreet1());
            ps.setString(2, a.getstreet2());
            ps.setString(3, a.getcity());
            ps.setString(4, a.getstate());
            ps.setString(5, a.getzip());
            ps.setBoolean(6, a.getaddprimary());
            ps.setInt(7, a.getpersonaddress().getId());
            ps.setInt(8, address_id);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed update address!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success update address!");
    }
    //find all
    public Collection<address> findAlladdress() throws SQLException{
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from address";
        developerImpl d = new developerImpl();
        Collection<address> collect_address = new ArrayList<address>();
        try {
        	conn = (Connection) myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();
        	int i = 0;
        	int j = 0;
        	while (rs.next()) {
        		//myConnection.getConnection();
        		address ad = new address();
        		ad.setaddressId(rs.getInt("address_id"));
        		ad.setaddresses(rs.getString("street1"), rs.getString("street2"));
        		ad.setcity(rs.getString("city"));
        		ad.setstate(rs.getString("state"));
        		ad.setzip(rs.getString("zip"));
        		ad.setaddprimary(rs.getBoolean("address_primary"));
        		person p = d.findpersonbyId(rs.getInt("address_person_id"));
        		conn = (Connection) myConnection.getConnection();
            	ps = conn.prepareStatement(sql);
            	rs = ps.executeQuery();
            	i = i + 1;
        		for (j = 0; j < i; j++) {
        			rs.next();
        		}
        		ad.setpersonaddress(p);
        		collect_address.add(ad);
        	}
        	
        }catch (Exception e) {
        	e.printStackTrace();
        throw new SQLException("failed find all address!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success find all address!");
        return collect_address;//collect_address;
    }
    //delete
    public void deleteaddress(int address_id) throws SQLException{
    	Connection conn = null;
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
        String sql = "delete from address where address_id= ?";
        try {
        	conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, address_id);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed delete address!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete address!");
    }
}
