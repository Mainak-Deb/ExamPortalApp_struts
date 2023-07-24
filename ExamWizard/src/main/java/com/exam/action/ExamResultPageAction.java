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

import com.exam.dao.ExamDAO;
import com.exam.dao.ResultDAO;
import com.exam.dto.ResultDTO;
import com.exam.form.ExamForm;



public class ExamResultPageAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		int eid = Integer.parseInt(request.getParameter("eid"));
    		if(role=="admin") {
    			ResultDAO rdao = new ResultDAO();
    			ExamDAO edao = new ExamDAO();
    			List<ResultDTO> lr = rdao.getResultByEid(eid);
    			ExamForm eform = edao.getExam(Integer.toString(eid));
    			
    			System.out.println(lr);
    			request.setAttribute("ename", eform.getEtitle());
    			request.setAttribute("results", lr);
    			
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	
    }
}