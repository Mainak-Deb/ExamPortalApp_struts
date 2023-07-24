package com.exam.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.ResultDAO;
import com.exam.dao.UserDAO;
import com.exam.dto.ResultDTO;
import com.exam.form.SignupForm;

public class StudentResultPageAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		String uid = (String)session.getAttribute("uid");
    		System.out.println(uid);
    		if(role.equalsIgnoreCase("student")) {
    			ResultDAO rdao = new ResultDAO();
    			UserDAO udao = new UserDAO();
    			List<ResultDTO> lr =rdao.getResultByUid(uid);
    			SignupForm sform = udao.getOneStudent(uid);
    			System.out.println(lr);
    			request.setAttribute("uname", sform.getUname());
    			request.setAttribute("uroll", sform.getUroll());
    			request.setAttribute("results", lr);
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	
    }
}