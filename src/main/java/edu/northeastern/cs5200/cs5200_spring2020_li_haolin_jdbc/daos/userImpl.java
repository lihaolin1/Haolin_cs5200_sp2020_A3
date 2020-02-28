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
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.user;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass.developer_person;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass.user_person;
@Service
public class userImpl implements userDao{
	public userImpl() {
		
	}
	@Override
	public void createuser(user u) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        //person p = null;
        String sql = "insert into user(user_id,user_agreement, user_personid)values(?,?,?)";
        String sql1 = "insert into person(person_id,firstname, lastname, username, password, email, dob)values(?,?,?,?,?,?,?)";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getagreement());
            ps.setInt(3,u.getpersonuser().getId());
            
            ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, u.getpersonuser().getId());
            ps1.setString(2, u.getpersonuser().getfirstname());
            ps1.setString(3, u.getpersonuser().getlastname());
            ps1.setString(4, u.getpersonuser().getusername());
            ps1.setString(5, u.getpersonuser().getpassword());
            ps1.setString(6, u.getpersonuser().getemail());
            ps1.setString(7, u.getpersonuser().getdob());
            ps1.executeUpdate();
            ps.executeUpdate();
         
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create user!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create user!");
	}
	 
    //refresh
	@Override
    public void updateuser(int userid, user u) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        if (u == null) return;
        // update develoepr
        //person p;
        String sql = "update user set ";
        String sql2 = "update person set";
        StringBuilder sb = new StringBuilder(sql);
        sb.append("user_agreement=?");
        sb.append("where user_personid=?");
        StringBuilder sb2 = new StringBuilder(sql2);
        sb2.append(",firstname=?");
        sb2.append(",lastname=?");
        sb2.append(",username=?");
        sb2.append(",password=?");
        sb2.append(",email=?");
        sb2.append(",dob=?");
        sb2.append(",where person_id=?");
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getagreement());
            ps.setInt(2,u.getpersonuser().getId());
            ps.executeUpdate();
            ps1 = conn.prepareStatement(sql2);
            ps1.setString(1, u.getpersonuser().getfirstname());
            ps1.setString(2, u.getpersonuser().getlastname());
            ps1.setString(3, u.getpersonuser().getusername());
            ps1.setString(4, u.getpersonuser().getpassword());
            ps1.setString(5, u.getpersonuser().getemail());
            ps1.setString(6, u.getpersonuser().getdob());
            ps1.setInt(7, userid);
            ps1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("fail update user!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success update user!");
    }
 
    //delete
	@Override
    public void deleteuser(int user_id) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        String sql = "delete from user where user_id=?";
        String sql1 = "select user_personid from user where user_id = ?";
        String sql2 = "delete from person where person_id = ?";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);
            ps1.setInt(1, user_id);
            rs = ps1.executeQuery();
            ps2.setInt(1,rs.getInt("user_personid")); //delete person
            ps2.executeUpdate();
            ps.setInt(1,user_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("fail delete user!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete user!");
    }
 
    //find
	@Override
    public user_person finduserById(int user_id) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //developer d = null;
        user_person up = null;
        //class result(int id, String firstname);
        String sql = "select u.*, p.* from user u where user_id=? left join person p on user_personid = person_id";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            //if (rs.next()) {
                up = new user_person();
                up.user_id = user_id;
                up.person_id = rs.getInt("person_id");
                up.firstname = rs.getString("firstname");
                up.lastname = rs.getString("lastname");
                up.username = rs.getString("username");
                up.password = rs.getString("password");
                up.email = rs.getString("email");
                up.dob = rs.getString("dob");
                up.user_agreement = rs.getBoolean("user_agreement");	               
            //}
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to search user by id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to search user by id!");
        return up;
    }
//    
//    //find
	@Override
    public user_person finduserByusername(String username) throws SQLException{
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //developer d = null;
        user_person up = null;
        //class result(int id, String firstname);
        String sql = "select u.*, p.* from person p where where username = ? left join user u on user_personid = person_id";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            //if (rs.next()) {
                up = new user_person();
                up.user_id = rs.getInt("user_id");
                up.person_id = rs.getInt("person_id");
                up.firstname = rs.getString("firstname");
                up.lastname = rs.getString("lastname");
                up.username = username;//rs.getString("username");
                up.password = rs.getString("password");
                up.email = rs.getString("email");
                up.dob = rs.getString("dob");
                up.user_agreement = rs.getBoolean("user_agreement");	               
            //}
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to search user by id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to search user by id!");
        return up;
    }
//    
	@Override
    public Collection<user_person> findAllusers()throws SQLException{
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //PreparedStatement ps2 = null;
        //ResultSet rs2 = null;
        user_person up;
        List<user_person> user_all = new ArrayList<user_person>();
        String sql = "select u.*,p.* from user u left join person p on user_personid = person_id";
        //String sql1 = "insert into developer_person(developer_id,person_id,firstname,lastname,username,password, email, dob, developer_key)values(?,?,?,?,?,?,?,?,?)";
        try {
            conn = (Connection) myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //ps2 = conn.prepareStatement(sql1);
            
            while (rs.next()) {
            	up = new user_person();
                up.user_id = rs.getInt("user_id");
                up.person_id = rs.getInt("person_id");
                up.firstname = rs.getString("firstname");
                up.lastname = rs.getString("lastname");
                up.username = rs.getString("username");
                up.password = rs.getString("password");
                up.email = rs.getString("email");
                up.dob = rs.getString("dob");
                up.user_agreement = rs.getBoolean("user_agreement");	
                //developer_all = ps2.executeQuery();
                user_all.add(up);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to select all user!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success to select all user!");
        return user_all;
    }
}
