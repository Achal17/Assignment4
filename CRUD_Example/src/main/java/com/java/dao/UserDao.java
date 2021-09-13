package com.java.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import com.java.dao.UserJdbc;
import com.java.model.User;
	
	public class UserDao {
		private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(name , email , country) values"
				+ "(? , ? , ?);";

		private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id=?;";
		private static final String SELECT_ALL_USERS = "select * from users;";
		private static final String DELETE_USER_SQL = "delete from users where id=?;";
		private static final String UPDATE_USERS_SQL = "update users set name=?,email=?,country=? where id=?;";

		
		//methods....
		public void insertUser(User user) throws SQLException {
			System.out.println("Insert methood");
			try(Connection con = UserJdbc.getConnection();
					PreparedStatement pt = con.prepareStatement(INSERT_USERS_SQL);) {
				
				pt.setString(1, user.getName());
				pt.setString(2, user.getEmail());
				pt.setString(3, user.getCountry());
				
				pt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		
		//UPDATE method
		public boolean updateUser(User user) throws SQLException {
			boolean rowUpdated;
			System.out.println("update method");
		//	System.out.println("update Users...");
			try(Connection con = UserJdbc.getConnection();
					PreparedStatement pt = con.prepareStatement(UPDATE_USERS_SQL);) {
				
				pt.setString(1, user.getName());
				pt.setString(2, user.getEmail());
				pt.setString(3, user.getCountry());
				pt.setInt(4,user.getId());
				
				rowUpdated = pt.executeUpdate() > 0;	
			}
			System.out.println("rowupdate : "+ rowUpdated);
			return rowUpdated;
		}
		
		//GET USER BY ID METHOD
		public User selectUser(int id) throws SQLException {
			System.out.println("Select Usser method");
			
			User user=null;
			try(Connection con = UserJdbc.getConnection();
					PreparedStatement pt = con.prepareStatement(SELECT_USER_BY_ID);) {
				
				pt.setInt(1, id);
				
				System.out.println(pt);
				ResultSet set = pt.executeQuery();
				
				while(set.next()) {
					String name=set.getString("name");
					String email = set.getString("email");
					String country = set.getString("country");
					
					user = new User(name , email , country);	
				}	
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			return user;
		}
		
		//SELECT all USER
		public List<User> selectAllUsers() throws SQLException {
			List<User> users = new ArrayList<User>();
			System.out.println("select All Userrs method");
			try(Connection con = UserJdbc.getConnection();
					PreparedStatement pt = con.prepareStatement(SELECT_ALL_USERS);){
				System.out.println(pt);
				ResultSet set = pt.executeQuery();
				
				while(set.next()) {
					int id = set.getInt("id");
					String name = set.getString("name");
					String email = set.getString("email");
					String country = set.getString("country");
					
					users.add(new User(name , email , country));
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			return users; 
		}
		//DELETE METHOD
		public boolean deleteUser(int id) throws SQLException {
			System.out.println("delete method");
			boolean rowDeleted;
			try(Connection con = UserJdbc.getConnection(); 
					PreparedStatement pt = con.prepareStatement(DELETE_USER_SQL);){
				pt.setInt(1,id);
				rowDeleted = pt.executeUpdate() > 0;
			}
			
			return rowDeleted;
		}
		
	}

