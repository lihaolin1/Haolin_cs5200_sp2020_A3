package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection1;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.developer;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass.developer_person;
@Service
public class developerImpl implements developerDao{
	    @Override
	    public void createdeveloper(developer d) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        PreparedStatement ps1 = null;
	        //person p = null;
	        String sql = "insert into developer(developer_id,developer_key, developer_personid)values(?,?,?)";
	        String sql1 = "insert into person(person_id,firstname, lastname, username, password, email, dob)values(?,?,?,?,?,?,?)";
	        try {
	            conn = myConnection.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, d.getId());
	            ps.setString(2, d.getkey());
	            ps.setInt(3,d.getpersondeveloper().getId());
	            
	            ps1 = conn.prepareStatement(sql1);
	            ps1.setInt(1, d.getpersondeveloper().getId());
	            ps1.setString(2, d.getpersondeveloper().getfirstname());
	            ps1.setString(3, d.getpersondeveloper().getlastname());
	            ps1.setString(4, d.getpersondeveloper().getusername());
	            ps1.setString(5, d.getpersondeveloper().getpassword());
	            ps1.setString(6, d.getpersondeveloper().getemail());
	            ps1.setString(7, d.getpersondeveloper().getdob());
	            ps1.executeUpdate();
	            ps.executeUpdate();
	         
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("failed create developer!");
	        } finally {
	            myConnection.closeConnection();
	        }
	        System.out.println("success create developer!");
	    }
	 
	    @Override
	    public void updatedeveloper(int developer_id, developer d) throws SQLException {
	    	Connection conn = null;
	        PreparedStatement ps = null;
	        PreparedStatement ps1 = null;
	        if (d == null) return;
	        // update develoepr
	        //person p;
	        String sql = "update developer set ";
	        String sql2 = "update person set";
	        StringBuilder sb = new StringBuilder(sql);
	        sb.append("developer_key=?");
	        sb.append("where developer_id=?");
	        StringBuilder sb2 = new StringBuilder(sql2);
	        sb2.append(",firstname=?");
	        sb2.append(",lastname=?");
	        sb2.append(",username=?");
	        sb2.append(",password=?");
	        sb2.append(",email=?");
	        sb2.append(",dob=?");
	        sb2.append(",where person_id=?");
	        try {
	            conn = myConnection.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, d.getkey());
	            ps.setInt(2,developer_id);
	            
	            ps1 = conn.prepareStatement(sql2);
	            ps1.setString(1, d.getpersondeveloper().getfirstname());
	            ps1.setString(2, d.getpersondeveloper().getlastname());
	            ps1.setString(3, d.getpersondeveloper().getusername());
	            ps1.setString(4, d.getpersondeveloper().getpassword());
	            ps1.setString(5, d.getpersondeveloper().getemail());
	            ps1.setString(6, d.getpersondeveloper().getdob());
	            ps1.setInt(7, d.getpersondeveloper().getId());
	            ps1.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("fail update developer!");
	        } finally {
	            myConnection.closeConnection();
	        }
	        System.out.println("success update developer!");
	    }
	 
	    @Override
	    public void deletedeveloper(int id) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        PreparedStatement ps1 = null;
	        PreparedStatement ps2 = null;
	        PreparedStatement ps3 = null;
	        PreparedStatement ps4 = null;
	        ResultSet rs = null;
	        String sql = "delete from developer where developer_id=?";
	        String sql1 = "select developer_personid from developer where developer_id = ?";
	        String sql2 = "delete from person where person_id = ?";
	        String sql3 = "delete from page_role where developer_id = ?";
	        String sql4 = "delete from website_role where developer_id = ?";
	        try {
	            conn = myConnection.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps1 = conn.prepareStatement(sql1);
	            ps2 = conn.prepareStatement(sql2);
	            ps1.setInt(1, id);
	            rs = ps1.executeQuery();
	            ps2.setInt(1,rs.getInt("developer_personid")); //delete person
	            ps2.executeUpdate();
	            ps.setInt(1,id);
	            ps.executeUpdate();
	            // delete page role and website role
	            ps3 = conn.prepareStatement(sql3);
	            ps4 = conn.prepareStatement(sql4);
	            ps3.setInt(1,id);
	            ps4.setInt(1,id);
	            ps3.executeUpdate();
	            ps4.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("fail delete developer!");
	        } finally {
	            myConnection.closeConnection();
	        }
	        System.out.println("success delete developer!");
	    } //do we need to delete widget and website for a developer?
	 
	    @Override
	    public developer_person finddeveloperById(int id) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        //developer d = null;
	        developer_person dp = null;
	        //class result(int id, String firstname);
	        String sql = "select d.*, p.* from developer d where developer_id=? left join person p on developer_personid = person_id";
	        try {
	            conn = myConnection.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                dp = new developer_person();
	                dp.developer_id = id;
	                dp.person_id = rs.getInt("person_id");
	                dp.firstname = rs.getString("firstname");
	                dp.lastname = rs.getString("lastname");
	                dp.username = rs.getString("username");
	                dp.password = rs.getString("password");
	                dp.email = rs.getString("email");
	                dp.dob = rs.getString("dob");
	                dp.developer_key = rs.getString("developer_key");	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("failed to search developer by id!");
	        } finally {
	        	myConnection.closeConnection();
	        }
	        System.out.println("success to search developer by id!");
	        return dp;
	    }
	    
	    @Override
	    public developer_person finddeveloperByusername(String username) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        //developer d = null;
	        developer_person dp = null;
	        String sql = "select d.*, p.* from person p where where username = ? left join developer d on developer_personid = person_id";
	        try {
	            conn = myConnection.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                dp = new developer_person();
	                dp.developer_id = rs.getInt("developer_id");
	                dp.person_id = rs.getInt("person_id");
	                dp.firstname = rs.getString("firstname");
	                dp.lastname = rs.getString("lastname");
	                dp.username = username;
	                dp.password = rs.getString("password");
	                dp.email = rs.getString("email");
	                dp.dob = rs.getString("dob");
	                dp.developer_key = rs.getString("developer_key");	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("failed to search developer by username!");
	        } finally {
	        	myConnection.closeConnection();
	        }
	        System.out.println("success to search developer by username!");
	        return dp;
	    }
	    
	    @Override
	    public developer_person finddeveloperByCredentials(String username, String password) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        //developer d = null;
	        developer_person dp = null;
	        String sql = "select d.*, p.* from person p where where username = ? and password = ? left join developer d on developer_personid = person_id";
	        try {
	            conn = myConnection.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                dp = new developer_person();
	                dp.developer_id = rs.getInt("developer_id");
	                dp.person_id = rs.getInt("person_id");
	                dp.firstname = rs.getString("firstname");
	                dp.lastname = rs.getString("lastname");
	                dp.username = username;
	                dp.password = password;
	                dp.email = rs.getString("email");
	                dp.dob = rs.getString("dob");
	                dp.developer_key = rs.getString("developer_key");	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("failed to search by username!");
	        } finally {
	        	myConnection.closeConnection();
	        }
	        System.out.println("success to search by username!");
	        return dp;
	    }
	 
	    @Override
	    public List<developer_person> findAlldevelopers() throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        //PreparedStatement ps2 = null;
	        //ResultSet rs2 = null;
	        developer_person dp;
	        List<developer_person> developer_all = new ArrayList<developer_person>();
	        String sql = "select d.*,p.* from developer d left join person p on developer_personid = person_id";
	        //String sql1 = "insert into developer_person(developer_id,person_id,firstname,lastname,username,password, email, dob, developer_key)values(?,?,?,?,?,?,?,?,?)";
	        try {
	            conn = myConnection.getConnection();
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            
	            //ps2 = conn.prepareStatement(sql1);
	            
	            while (rs.next()) {
	            	dp = new developer_person();
	                dp.developer_id = rs.getInt("developer_id");
	                dp.person_id = rs.getInt("person_id");
	                dp.firstname = rs.getString("firstname");
	                dp.lastname = rs.getString("lastname");
	                dp.username = rs.getString("username");
	                dp.password = rs.getString("password");
	                dp.email = rs.getString("email");
	                dp.dob = rs.getString("dob");
	                dp.developer_key = rs.getString("developer_key");	
	                //developer_all = ps2.executeQuery();
	                developer_all.add(dp);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("failed to select all developer!");
	        } finally {
	            myConnection.closeConnection();
	        }
	        System.out.println("success to select all developer!");
	        return developer_all;
	    }
	    
	    
	    @Override
	    public person findpersonbyId(int personid) throws SQLException{
	    	Connection conn1 = null;
	        PreparedStatement ps1 = null;
	        ResultSet rs1 = null;
	        person p = new person();
	        //PreparedStatement ps1 = null;
	        String sql = "select * from person where person_id = ?";
	        try {
	        	conn1 = myConnection.getConnection();
	            ps1 = conn1.prepareStatement(sql);
	            ps1.setInt(1, personid);
	            rs1 = ps1.executeQuery();
	            if(rs1.next()) {
	            p.setId(rs1.getInt("person_id"));
	            p.setfirstname(rs1.getString("firstname"));
	            p.setlastname(rs1.getString("lastname"));
	            p.setusername(rs1.getString("username"));
	            p.setpassword(rs1.getString("password"));
	            p.setemail(rs1.getString("email"));
	            p.setdob(rs1.getString("dob"));
	            //ps.setInt(rs.getInt("person"));
	            }
	        }catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("failed select person by id!");
	        } finally {
	            myConnection.closeConnection();
	        }
	        System.out.println("success select person by id!");
	        return p;
	    }

}
