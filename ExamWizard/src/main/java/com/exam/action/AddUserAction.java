package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.UserDAO;

public class AddUserAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
				
				
				String name= request.getParameter("name");
				String email= request.getParameter("email");
				String roll= request.getParameter("roll");
				System.out.println(name+","+email);
				
				UserDAO udao = new UserDAO();
				boolean isUpdated=udao.addUser(name, email, roll,"Student");
				System.out.println(isUpdated);
				if(isUpdated) {
					return mapping.findForward("success");
				}
				
				return null;
    	
    }
}