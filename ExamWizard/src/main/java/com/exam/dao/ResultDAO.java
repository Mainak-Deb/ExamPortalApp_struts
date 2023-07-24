package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exam.dto.ResultDTO;
import com.exam.form.ResultForm;

//import com.exam.forms.LoginForm;


public class ResultDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection conn;

    public ResultDAO() {
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
//Method to insert a new result into the "Results" table
public int insertResult(String userId, int examId, int totalMarks, int score) throws SQLException {
    
	connect();
	String sql = "INSERT INTO Results (Uid, Eid, RTotal, RScore) VALUES (?, ?, ?, ?)";
    
    PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, userId);
        statement.setInt(2, examId);
        statement.setInt(3, totalMarks);
        statement.setInt(4, score);
        
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        int generatedId=0;
        if (generatedKeys.next()) {
            generatedId = generatedKeys.getInt(1);
            System.out.println("Automatically generated ID: " + generatedId);
        }
        
        statement.close();
        disconnect();
         return generatedId;
    
}

// Method to retrieve a result record from the "Results" table based on the resultId
public List<ResultDTO> getResultByUid(String uid) throws SQLException {
	List<ResultDTO> lr = new ArrayList<>();
    String sql = "SELECT * FROM Results WHERE uid = ?";
    connect();
    PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, uid);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int rid = resultSet.getInt("Rid");
                int examId = resultSet.getInt("Eid");
                int totalMarks = resultSet.getInt("RTotal");
                int score = resultSet.getInt("RScore");
                String stime= resultSet.getString("SubmissionTime");
                
                ResultForm result = new ResultForm(rid, uid, examId, totalMarks, score,stime);
                ResultDTO rdto = new ResultDTO(result);
                lr.add(rdto);
            }
      }
    
        statement.close();
        disconnect();
        return lr;
}
public List<ResultDTO> getResultByEid(int eid) throws SQLException {
	List<ResultDTO> lr = new ArrayList<>();
    String sql = "SELECT * FROM Results WHERE eid = ?";
    connect();
    PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, eid);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int rid = resultSet.getInt("Rid");
                String uid = resultSet.getString("uid");
                int totalMarks = resultSet.getInt("RTotal");
                int score = resultSet.getInt("RScore");
                String stime= resultSet.getString("SubmissionTime");
                ResultForm result = new ResultForm(rid, uid, eid, totalMarks, score,stime);
                ResultDTO rdto = new ResultDTO(result);
                lr.add(rdto);
            }
      }
    
    statement.close();
    disconnect();
    return lr;
}
public ResultDTO getResultByRid(int rid) throws SQLException {
	ResultDTO rdto = null;
    String sql = "SELECT * FROM Results WHERE Rid = ?";
    connect();
    PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, rid);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int eid = resultSet.getInt("Eid");
                String uid = resultSet.getString("uid");
                int totalMarks = resultSet.getInt("RTotal");
                int score = resultSet.getInt("RScore");
                String stime= resultSet.getString("SubmissionTime");
                ResultForm result = new ResultForm(rid, uid, eid, totalMarks, score,stime);
                rdto = new ResultDTO(result);
            }
      }
    
    statement.close();
    disconnect();
    return rdto;
	}
}