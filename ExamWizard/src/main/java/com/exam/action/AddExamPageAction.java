package com.exam.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class AddExamPageAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		if(role=="admin") {
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	}catch(Exception e) {
    		return mapping.findForward("failure");
    	}
    }
}