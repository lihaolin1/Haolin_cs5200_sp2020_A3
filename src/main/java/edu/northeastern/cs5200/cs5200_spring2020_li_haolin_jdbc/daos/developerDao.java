package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.developer;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass.developer_person;

public interface developerDao {
	void createdeveloper(developer d) throws SQLException;
	 
    //refresh
    void updatedeveloper(int developerid, developer d) throws SQLException;
 
    //delete
    void deletedeveloper(int developer_id) throws SQLException;
 
    //find
    developer_person finddeveloperById(int developer_id) throws SQLException;
//    
//    //find
    developer_person finddeveloperByusername(String username) throws SQLException;
//    
    //find
    developer_person finddeveloperByCredentials(String username, String password) throws SQLException;
 
//    //find all
    Collection<developer_person> findAlldevelopers()throws SQLException;
    
    person findpersonbyId(int personid) throws SQLException;

}
