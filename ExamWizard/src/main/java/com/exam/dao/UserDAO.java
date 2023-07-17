package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.form.SignupForm;

public class UserDAO {
	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection conn;

	    public UserDAO() {
	        this.jdbcURL = "jdbc:mysql://localhost:3306/exam_master";
	        this.jdbcUsername = "root";
	        this.jdbcPassword = "root";
	    }

	    // Establishes a database connection
	    protected void connect() throws SQLException {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }

	    // Closes the database connection
	    protected void disconnect() throws SQLException {
	        if (conn != null && !conn.isClosed()) {
	            conn.close();
	        }
	    }
	    
	    public boolean addUser( String name, String email, String roll, String urole ) throws SQLException {
	    	connect(); 
	            // Check if the urole field is empty or null
	            if (urole == null || urole.isEmpty()) {
	                // Set the default value to "student"
	                urole = "student";
	            }
	            
	            // Create the SQL query to insert the record into the table
	            String query = "INSERT INTO user (uname, emailid, uroll, urole) VALUES (?, ?, ?, ?)";
	            
	            // Prepare the statement
	            PreparedStatement stmt = conn.prepareStatement(query);
	            
	            // Set the values for the placeholders
	            stmt.setString(1, name);
	            stmt.setString(2, email);
	            stmt.setString(3, roll);
	            stmt.setString(4, urole);
	            
	            // Execute the query
	            int rowsAffected = stmt.executeUpdate();
	            
	            // Check if the insertion was successful
	            if (rowsAffected > 0) {
	                return true;
	            }

	        // If the insertion failed or an exception occurred
	            stmt.close();
	            disconnect();
	        return false;
	    }
//===============================================================================================//	    
	    public List<SignupForm> getAllStudents() throws SQLException {
	        List<SignupForm> students = new ArrayList<>();
	        String sql = "SELECT * FROM User";
	        connect();
	        System.out.println("here");

	        PreparedStatement statement = conn.prepareStatement(sql);
	        

	        ResultSet resultSet = statement.executeQuery();
	        System.out.println("here2");
	        while (resultSet.next()) {
	        	String uid= resultSet.getString("uid");
	            String uname = resultSet.getString("uname");
	            String uroll = resultSet.getString("uroll");
	            String urole = resultSet.getString("urole");
	            String email = resultSet.getString("emailid");

	            System.out.println(uname);
	            SignupForm  newStudent = this.makeStudent( uid, uname, uroll, urole, email);
	            System.out.println(newStudent);
	            students.add(newStudent);
	        }
	        resultSet.close();
	        statement.close();
	        disconnect();
//	        for(SignupForm c:students) {
//	        	System.out.println(c.getStudentId() +" | "+c.getFullName()+" | "+c.getStudentEmail());
//	        }
	    	return students;
	    }
	  
//===============================================================================================//

	    public boolean deleteStudent(String uid) throws SQLException {
	        String sql = "DELETE from User WHERE uid = '"+uid+"'";
	        connect();

	        PreparedStatement statement = conn.prepareStatement(sql);
	        int rows = statement.executeUpdate();
	        statement.close();
	        disconnect();
	        if (rows == 0) {
	            return false;
	        }
	        else {
	        	return true;
	        }
	    }

//===============================================================================================// 
	    public SignupForm makeStudent( String uid, String uname, String uroll, String urole,
	            String email) {
	    	SignupForm student = new SignupForm();
	    	
	    	student.setUid(uid);
	    	student.setUname(uname);
	    	student.setUroll(uroll);
	    	student.setUrole(urole);
	    	student.setEmail(email);
	    	
	    	return student;
	    }
}
