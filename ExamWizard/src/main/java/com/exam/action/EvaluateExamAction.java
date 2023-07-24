package com.exam.action;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.ExamUserDAO;
import com.exam.dao.NotificationDAO;
import com.exam.dao.QuestionDAO;
import com.exam.dao.ResultDAO;
import com.exam.form.NotificationForm;
import com.exam.service.CheckAnswer;

public class EvaluateExamAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
				
    	int eid = Integer.parseInt(request.getParameter("eid"));
    	String uid = request.getParameter("uid");
    	
    	System.out.println(eid+","+uid);
    	
    	Enumeration<String> parameterNames = request.getParameterNames();
    	
    	QuestionDAO qdao = new QuestionDAO();
    	int total=qdao.totalMarks(eid);
    	int point=0;
    	
        while (parameterNames.hasMoreElements()) {
        	String v = parameterNames.nextElement();
        	if(!v.equalsIgnoreCase("eid") && !v.equalsIgnoreCase("uid")) {
        		System.out.println(v +","+request.getParameter(v));
        		point+=CheckAnswer.check(Integer.parseInt(v), Integer.parseInt(request.getParameter(v)));
        	}
        }
        System.out.println("point is = "+point+"/"+total);
        request.setAttribute("total", total);
        request.setAttribute("score", point);
        
        ResultDAO rdao = new ResultDAO();
        int rid = rdao.insertResult(uid, eid, total, point);
        
        NotificationDAO ndao = new NotificationDAO();
        NotificationForm nform = new NotificationForm(uid, eid, rid); 
        System.out.println(nform);
        ndao.createNotificationForm(nform);
        
        
        ExamUserDAO eudao = new ExamUserDAO();
        eudao.deleteOneStdent(uid,Integer.toString(eid));
        return mapping.findForward("success");
    }
}