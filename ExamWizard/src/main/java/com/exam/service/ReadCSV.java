package com.exam.service;

import java.util.ArrayList;

import com.exam.form.UserForm;

public class ReadCSV {
	String fileContent;
	public ReadCSV(String fileContent) {
		this.fileContent=fileContent;
	}
	public ArrayList<UserForm> getData(){
		ArrayList<UserForm> data = new ArrayList<UserForm>();
		String[] lines=fileContent.split("\n");
		lines=this.deleteFirstElement(lines);
		for (String line : lines) {
            String[] columns = line.split(",");

            UserForm uf = new UserForm();
            if(columns.length==3) {
	            if(columns[0].length()!=0) {
	            	uf.setName(columns[0]);
	            }
	            if(columns[1].length()!=0) {
	            	uf.setRoll(columns[1]);
	            }
	            if(columns[2].length()!=0) {
	            	uf.setEmail(columns[2]);
	            }
	            data.add(uf);
            }
            
        }
		return data;
		
	}
	 public String[] deleteFirstElement(String[] array) {
	        if (array == null || array.length == 0) {
	            return array;
	        }

	        String[] newArray = new String[array.length - 1];
	        System.arraycopy(array, 1, newArray, 0, array.length - 1);

	        return newArray;
	    }
}
