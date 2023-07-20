package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.exam.forms.LoginForm;


public class LoginDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection conn;

    public LoginDAO() {
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
    
    public String getIdByEmail(String mail) throws SQLException {
    	String userId="";
    	connect();
        PreparedStatement stmt = conn.prepareStatement("SELECT uid FROM User WHERE emailid = ?");
        stmt.setString(1, mail);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            userId = rs.getString("uid");
        }
		return userId;
    }
    public String getNameByEmail(String mail) throws SQLException {
    	String uname="";
    	connect();
        PreparedStatement stmt = conn.prepareStatement("SELECT uname FROM User WHERE emailid = ?");
        stmt.setString(1, mail);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            uname = rs.getString("uname");
        }
		return uname;
    }
    
    public String getRollByEmail(String mail) throws SQLException {
    	String uroll="";
    	connect();
        PreparedStatement stmt = conn.prepareStatement("SELECT uroll FROM User WHERE emailid = ?");
        stmt.setString(1, mail);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
        	uroll = rs.getString("uroll");
        }
		return uroll;
    }

    // Checking whether credentials valid or not
    public String isValidCredentials(String username, String password) throws SQLException {
    		
    	connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT urole FROM User WHERE emailid = ? AND uroll = ?");

            stmt.setString(1, username);
            stmt.setString(2, password); 

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("urole");
                if(role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("student")) {
                	stmt.close();
                    disconnect();
                    return role;
                }
            }
            stmt.close();
            disconnect();
            return null;
        
    }}