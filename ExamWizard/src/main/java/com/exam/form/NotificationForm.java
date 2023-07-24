package com.exam.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

public class NotificationForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nid;
    private String uid;
    private int eid;
    private int rid;
    private String timestamp;
    
    public NotificationForm(String uid, int eid, int rid) {
    	this.uid=uid;
    	this.eid=eid;
    	this.rid=rid;
	}
    
    public NotificationForm(int nid,String uid, int eid, int rid,String time) {
    	this.nid= nid;
    	this.uid=uid;
    	this.eid=eid;
    	this.rid=rid;
    	this.timestamp=time;
	}
	//Getters and setters
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "NotificationForm [nid=" + nid + ", uid=" + uid + ", eid=" + eid + ", rid=" + rid + ", timestamp="
				+ timestamp + "]";
	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
