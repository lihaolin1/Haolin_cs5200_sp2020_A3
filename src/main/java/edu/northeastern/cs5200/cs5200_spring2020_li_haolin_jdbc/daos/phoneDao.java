package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.developer;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.phone;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass.developer_person;

public interface phoneDao {
	void createphone(phone p) throws SQLException;
	 
    //refresh
    void updatephone(phone p, String phone_number) throws SQLException;
 
    //delete
    void deletephone(String phone_number) throws SQLException;
    
    phone findphoneBynumber(String phone_number) throws SQLException;
    
    Collection<phone> findAllphones()throws SQLException;
    
}
