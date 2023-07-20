package com.exam.service;

import java.sql.SQLException;

import com.exam.dao.OptionDAO;
import com.exam.dao.QuestionDAO;
import com.exam.dto.Triad;

public class CheckAnswer {
		public static int check(int qid,int oid) throws SQLException {
			QuestionDAO qdao = new QuestionDAO();
			OptionDAO odao = new OptionDAO();
			
			Triad<Integer,String,String> t =  qdao.getQuestion(qid);
			int marks=t.first;
			boolean isOk = odao.checkAnswer(qid, oid);
			if(isOk) {
				System.out.println(qid+"= ok");
				return marks;
			}else {
				System.out.println(qid+"= not ok");
				return 0;
			}
		}
}
