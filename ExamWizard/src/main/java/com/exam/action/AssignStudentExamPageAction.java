package com.exam.action;


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
import com.exam.dao.UserDAO;
import com.exam.form.ExamForm;
import com.exam.form.SignupForm;

public class AssignStudentExamPageAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		if(role=="admin") {
    			 String examId = request.getParameter("eid"); // Extract dynamic parameter from the URL
    		     System.out.println(examId);
    		     UserDAO udao= new UserDAO();
     			 List<SignupForm> studentlist = udao.getAllStudentsExcludeAdmin();
     			 System.out.println(studentlist);
     			 
     			 ExamUserDAO eudao=new ExamUserDAO();
     			 List<String> checkedStudents = eudao.getStudentByExam(examId);
     			 
     			 System.out.println(checkedStudents);
     			 
    		     request.setAttribute("eid",examId);
    		     request.setAttribute("studentlist",studentlist);
    		     request.setAttribute("checkedStudents", checkedStudents);
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	}catch(Exception e) {
    		return mapping.findForward("failure");
    	}
    }
}