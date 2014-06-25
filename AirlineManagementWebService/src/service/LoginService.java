package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import model.UserMessageBean;


public class LoginService {
	private static final String LOGIN_QUERY = "select * from user where email=? and password=? and type=?";
	

	public UserMessageBean validateUser(String email,String password,String type){
		
		UserMessageBean userMessageBean = new UserMessageBean();
		User user = new User();
		Connection conn;
		try {
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(LOGIN_QUERY);
			prepStmt.setString(1, email);
			prepStmt.setString(2, password);
			prepStmt.setString(3, type);
			ResultSet rs = prepStmt.executeQuery();			
			System.out.println("Query: "+prepStmt);		
			user = setUserBeanValues(rs,user);
			if(user != null){
				userMessageBean.setUser(user);
				userMessageBean.setMessage("Welcome "+user.getF_name()+" "+user.getL_name());				
			}else{
				userMessageBean.setMessage("Invalid Login Please try again!!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			userMessageBean.setMessage("Invalid Login Please try again!!!");
			e.printStackTrace();
		}
		return userMessageBean;
	}
	
	public User setUserBeanValues(ResultSet rs,User user){
		try {
			if(rs.next()) {
				user.setUser_id(rs.getInt("user_id"));			
				user.setF_name(rs.getString("f_name"));
				user.setL_name(rs.getString("l_name"));
				user.setEmail(rs.getString("email"));				
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setState(rs.getString("state"));
				user.setZipcode(rs.getString("zipcode"));
				user.setDob(rs.getDate("dob").toString());
				user.setType(rs.getString("type"));
				return user;
			}				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
