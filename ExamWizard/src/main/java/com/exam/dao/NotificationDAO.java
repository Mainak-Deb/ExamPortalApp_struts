package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.exam.form.NotificationForm;


public class NotificationDAO {

	    private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection conn;

	    public NotificationDAO() {
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
	// Method to retrieve NotificationForms ordered by timestamp in descending order
    public List<NotificationForm> retrieveNotificationForms() throws SQLException {
        List<NotificationForm> NotificationForms = new ArrayList<>();
        connect();
        try (Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM Notifications ORDER BY Timestamp DESC";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int nid = rs.getInt("Nid");
                String uid = rs.getString("Uid");
                int eid = rs.getInt("Eid");
                int rid = rs.getInt("Rid");
                String timestamp = rs.getString("Timestamp");

                NotificationForm NotificationForm = new NotificationForm(nid, uid, eid, rid, timestamp);
                NotificationForms.add(NotificationForm);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            disconnect();
        }

        return NotificationForms;
    }

    // Method to create a new NotificationForm
    public void createNotificationForm(NotificationForm NotificationForm) throws SQLException {
    	connect();
    	PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO Notifications(Uid, Eid, Rid) VALUES (?, ?, ?)");
            pstmt.setString(1, NotificationForm.getUid());
            pstmt.setInt(2, NotificationForm.getEid());
            pstmt.setInt(3, NotificationForm.getRid());

            pstmt.executeUpdate();
            disconnect();
        
    }

    // Method to delete a NotificationForm by Nid
    public void deleteNotificationForm(int nid) throws SQLException {
    	connect();
        try (PreparedStatement pstmt = conn.prepareStatement(
                "DELETE FROM Notifications WHERE Nid = ?")) {
            pstmt.setInt(1, nid);
            pstmt.executeUpdate();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            disconnect();
        }
    }
}
