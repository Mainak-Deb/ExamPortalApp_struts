package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.OptionDAO;
import com.exam.dao.QuestionDAO;
import com.exam.form.QuestionSubmitForm;

public class SubmitQuestionAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    		QuestionSubmitForm qform =(QuestionSubmitForm) form;
    		System.out.println(qform);
    		QuestionDAO qdao = new QuestionDAO();
    		int qid=qdao.insertQuestion(qform.getQ_text(), qform.getMarks());
    		System.out.println(qid);
    		
    		
    		OptionDAO odao = new OptionDAO();
    		
    		if(qform.getAnswer().equalsIgnoreCase("a")) {
    			odao.insertOption(qform.getOption_a_text(),qid,true);
    		}else {
    			odao.insertOption(qform.getOption_a_text(),qid,false);
    		}
    		
    		if(qform.getAnswer().equalsIgnoreCase("b")) {
    			odao.insertOption(qform.getOption_b_text(),qid,true);
    		}else {
    			odao.insertOption(qform.getOption_b_text(),qid,false);
    		}
    		
    		if(qform.getAnswer().equalsIgnoreCase("c")) {
    			odao.insertOption(qform.getOption_c_text(),qid,true);
    		}else {
    			odao.insertOption(qform.getOption_c_text(),qid,false);
    		}
    		
    		if(qform.getAnswer().equalsIgnoreCase("d")) {
    			odao.insertOption(qform.getOption_d_text(),qid,true);
    		}else {
    			odao.insertOption(qform.getOption_d_text(),qid,false);
    		}
    		
    		
    		return new ActionForward("/addNewQuestionsPage.do?eid="+Integer.toString(qform.getEid()), true);
    }}