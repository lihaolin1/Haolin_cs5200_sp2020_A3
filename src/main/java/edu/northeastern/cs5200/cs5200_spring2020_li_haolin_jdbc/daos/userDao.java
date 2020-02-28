package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.developer;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.user;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass.developer_person;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.savejoinclass.user_person;

public interface userDao {
	void createuser(user u) throws SQLException;
	 
    //refresh
    void updateuser(int userid, user u) throws SQLException;
 
    //delete
    void deleteuser(int user_id) throws SQLException;
 
    //find
    user_person finduserById(int user_id) throws SQLException;
//    
//    //find
    user_person finduserByusername(String username) throws SQLException;
//    
    //find
    //find all
    Collection<user_person> findAllusers()throws SQLException;
}
