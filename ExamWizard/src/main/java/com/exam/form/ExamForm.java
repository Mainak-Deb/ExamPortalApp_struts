package com.exam.form;

import org.apache.struts.action.ActionForm;

public class ExamForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eid;
	private String etitle;
	private int eduration;
	private String estart;
	private String eend;
	
	public ExamForm() {
		
	}
	
    public ExamForm(int eid, String etitle, int eduration, String estart, String eend) {
        this.eid = eid;
        this.etitle = etitle;
        this.eduration = eduration;
        this.estart = estart;
        this.eend = eend;
    }
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public int getEduration() {
		return eduration;
	}
	public void setEduration(int eduration) {
		this.eduration = eduration;
	}
	public String getEstart() {
		return estart;
	}
	public void setEstart(String estart) {
		this.estart = estart;
	}
	public String getEend() {
		return eend;
	}
	public void setEend(String eend) {
		this.eend = eend;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	 public String toString() {
	        return "Exam [ id = "+this.eid+"," +this.etitle+" , "+this.estart+" ]";
	 }
	@Override
    public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamForm a = (ExamForm) o;
        return this.eid==a.eid;
    }

}
