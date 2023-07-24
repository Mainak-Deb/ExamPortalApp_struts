package com.exam.form;

import org.apache.struts.action.ActionForm;

public class ResultForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    private int rid;
	    private String userId;
	    private int examId;
	    private int totalMarks;
	    private int score;
	    private String time;
	    
	    // Constructors
	    public ResultForm() {
	    }
	    
	    public ResultForm(int rid, String userId, int examId, int totalMarks, int score,String time) {
	        this.rid = rid;
	        this.userId = userId;
	        this.examId = examId;
	        this.totalMarks = totalMarks;
	        this.score = score;
	        this.setTime(time);
	    }
	    
	    // Getters and Setters
	    public int getRid() {
	        return rid;
	    }
	    
	    public void setRid(int rid) {
	        this.rid = rid;
	    }
	    
	    public String getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(String userId) {
	        this.userId = userId;
	    }
	    
	    public int getExamId() {
	        return examId;
	    }
	    
	    public void setExamId(int examId) {
	        this.examId = examId;
	    }
	    
	    public int getTotalMarks() {
	        return totalMarks;
	    }
	    
	    public void setTotalMarks(int totalMarks) {
	        this.totalMarks = totalMarks;
	    }
	    
	    public int getScore() {
	        return score;
	    }
	    
	    public void setScore(int score) {
	        this.score = score;
	    }

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}
}

