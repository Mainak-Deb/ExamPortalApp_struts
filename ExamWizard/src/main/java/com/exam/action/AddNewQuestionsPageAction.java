package com.exam.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class AddNewQuestionsPageAction   extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		if(role=="admin") {
    			String examId = request.getParameter("eid");
    			request.setAttribute("eid", examId);
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	}catch(Exception e) {
    		return mapping.findForward("failure");
    	}
    }
}