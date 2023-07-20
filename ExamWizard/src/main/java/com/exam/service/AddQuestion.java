package com.exam.service;

import java.sql.SQLException;

import com.exam.dao.OptionDAO;
import com.exam.dao.QuestionDAO;
import com.exam.dao.QuestionToExamDAO;

public class AddQuestion {
	public static final void add(int eid, String qtext, String a,String b, String c, String d, int marks, String correctAns) throws SQLException {
		QuestionDAO qdao = new QuestionDAO();
		
		int qid=qdao.insertQuestion(qtext, marks);
		System.out.println(qid);
		
		QuestionToExamDAO qtedao = new QuestionToExamDAO();
		qtedao.insertQuesToExam(qid, eid);
		
		OptionDAO odao = new OptionDAO();
		
		if(correctAns.equalsIgnoreCase("a")) {
			odao.insertOption(a,qid,true);
		}else {
			odao.insertOption(a,qid,false);
		}
		
		if(correctAns.equalsIgnoreCase("b")) {
			odao.insertOption(b,qid,true);
		}else {
			odao.insertOption(b,qid,false);
		}
		
		if(correctAns.equalsIgnoreCase("c")) {
			odao.insertOption(c,qid,true);
		}else {
			odao.insertOption(c,qid,false);
		}
		
		if(correctAns.equalsIgnoreCase("d")) {
			odao.insertOption(d,qid,true);
		}else {
			odao.insertOption(d,qid,false);
		}
	}
}
