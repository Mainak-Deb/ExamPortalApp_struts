package com.exam.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.ExamDAO;
import com.exam.dao.ExamUserDAO;
import com.exam.form.ExamForm;

public class StudentExamsPageAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		String uid =(String) session.getAttribute("uid");
    		if(role.equalsIgnoreCase("student")) {
    			ExamDAO edao = new ExamDAO();   
    			ExamUserDAO eudao= new ExamUserDAO();
    			
    			
    		    List<ExamForm> onlineExamList=edao.getAllOnlineExam();
    		    List<ExamForm> notEndedExamList=edao.getAllNotExamExam();
    		    List<String> usersExam = eudao.getExamByStudent(uid);
    		    
    		    List<ExamForm> startedExams = new  ArrayList<>();
    		    List<ExamForm> NotStartedExams = new  ArrayList<>();
    		    List<ExamForm> NotEndedExams = new  ArrayList<>();
    		    
    		    
    		    for(ExamForm exam: onlineExamList) {
    		    	if(usersExam.contains(Integer.toString(exam.getEid()))) {
    		    		startedExams.add(exam);
    		    	}
    		    }
    		    
    		    for(ExamForm exam: notEndedExamList) {
    		    	if(usersExam.contains(Integer.toString(exam.getEid()))) {
    		    		NotEndedExams.add(exam);
    		    	}
    		    }
    		    
    		    System.out.println("Not ended exams= "+NotEndedExams);
    		    
    		    for(ExamForm exam: NotEndedExams) {
    		    	if(!startedExams.contains(exam)) {
    		    		NotStartedExams.add(exam);
    		    	}
    		    }
    		    
    		    
//    		    for(ExamForm exam: notEndedExamList) {
//    		    	if(startedExams.contains(exam)) {
//    		    		System.out.println(exam);
//    		    	}
//    		    }
//    		    System.out.println("true"+startedExams.contains(notEndedExamList.get(0)));  ;
    		    System.out.println("started exams= "+startedExams);
    		    System.out.println("upcoming exams= "+NotStartedExams);
    		    
//    		    System.out.println(onlineExamList);
//    		    System.out.println(notEndedExamList);
    		    System.out.println(usersExam);
    		    
    		    request.setAttribute("startedExams", startedExams);
    		    request.setAttribute("NotStartedExams", NotStartedExams);
    		    
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	
    }
}