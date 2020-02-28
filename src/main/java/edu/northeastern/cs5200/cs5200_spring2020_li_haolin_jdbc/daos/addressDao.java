package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.address;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.phone;

public interface addressDao {
	void createaddress(address a) throws SQLException;
	 
    //refresh
    void updateaddress(int address_id, address a) throws SQLException;
 
    //delete
    void deleteaddress(int address_id) throws SQLException;
    
    //phone findaddressBynumber(String phone_number) throws SQLException;
    
    Collection<address> findAlladdress()throws SQLException;
}
