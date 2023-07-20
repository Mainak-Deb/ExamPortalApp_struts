package com.exam.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exam.dto.QuestionDTO;
import com.exam.dto.Triad;

public class QuestionDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection conn;

    public QuestionDAO() {
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
    // Method to insert a new question into the "Question" table
    public int insertQuestion(String questionText, int questionMarks) throws SQLException {
        String sql = "INSERT INTO Question (QText, QMarks) VALUES (?, ?)";
        	connect();
        	PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            statement.setString(1, questionText);
            statement.setInt(2, questionMarks);
            
            
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
   
    
    // Method to delete a question from the "Question" table based on the question ID
    public void deleteQuestion(int questionId) throws SQLException {
        String sql = "DELETE FROM Question WHERE Qid = ?";
        	connect();
        	PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, questionId);
            
            statement.executeUpdate();
            
            statement.close();
            disconnect();
        }
    
    
    // Method to edit an existing question in the "Question" table
    public void editQuestion(int questionId, String questionText, int questionMarks, int answer) throws SQLException {
        String sql = "UPDATE Question SET QText = ?, QMarks = ?, QAns = ? WHERE Qid = ?";
        connect();
        PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, questionText);
            statement.setInt(2, questionMarks);
            statement.setInt(3, answer);
            statement.setInt(4, questionId);
            
            statement.executeUpdate();
            
            statement.close();
            disconnect();
        }
    
    public Triad<Integer,String,String> getQuestion(int qid) throws SQLException {
    	Triad<Integer,String,String> t = new Triad<>();
        String sql = "select qtext,qmarks from question where qid = ?";
        connect();
        
        PreparedStatement statement = conn.prepareStatement(sql); 
        statement.setInt(1, qid);
          
        try (ResultSet resultSet = statement.executeQuery()) {
           if (resultSet.next()) {
                int qmarks= resultSet.getInt("qmarks");
                String qtext=resultSet.getString("qtext");
                t.first=qmarks;
                t.second=qtext;
            }
        }
        statement.close();
        disconnect();
        
        return t;
    }
    
    public int totalMarks(int eid) throws SQLException {
    	int total=0;
        String sql = "select sum(qmarks) as total from questiontoexam join question \r\n"
        		+ "where question.qid=questiontoexam.qid\r\n"
        		+ "and eid=?";
        connect();
        
        PreparedStatement statement = conn.prepareStatement(sql); 
        statement.setInt(1, eid);
          
        try (ResultSet resultSet = statement.executeQuery()) {
           if (resultSet.next()) {
                total= resultSet.getInt("total");
            }
        }
        statement.close();
        disconnect();
        
        return total;
    }
    
    
    
    
}
