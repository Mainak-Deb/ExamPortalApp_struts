package com.exam.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class FileUploadForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormFile file;
	
	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
	   HttpServletRequest request) {
		
	    ActionErrors errors = new ActionErrors();
	      
	    if( getFile().getFileSize()== 0){
	       errors.add("common.file.err",
	    	new ActionMessage("error.common.file.required"));
	       return errors;
	    }
	   
	      
	    return errors;
	}
}