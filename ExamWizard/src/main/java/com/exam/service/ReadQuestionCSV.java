package com.exam.service;

import java.util.ArrayList;



public class ReadQuestionCSV {
	String fileContent;
	public ReadQuestionCSV(String fileContent) {
		this.fileContent=fileContent;
	}
	public ArrayList<String[]> getData(){
		ArrayList<String[]> data = new ArrayList<String[]>();
		String[] lines=fileContent.split("\n");
		lines=this.deleteFirstElement(lines);
		for(String s:lines) {
			String[] words=s.split(",");
			data.add(words);
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
