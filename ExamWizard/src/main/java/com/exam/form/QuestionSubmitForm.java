package com.exam.form;

import org.apache.struts.action.ActionForm;

public class QuestionSubmitForm  extends ActionForm{
	
		private static final long serialVersionUID = 1L;
		private int eid;
		private String q_text;
		private String option_a_text;
		private String option_b_text;
		private String option_c_text;
		private String option_d_text;
		private String answer;
		private int marks;
		public int getEid() {
			return eid;
		}
		public void setEid(int eid) {
			this.eid = eid;
		}
		public String getQ_text() {
			return q_text;
		}
		public void setQ_text(String q_text) {
			this.q_text = q_text;
		}
		public String getOption_a_text() {
			return option_a_text;
		}
		public void setOption_a_text(String option_a_text) {
			this.option_a_text = option_a_text;
		}
		public String getOption_b_text() {
			return option_b_text;
		}
		public void setOption_b_text(String option_b_text) {
			this.option_b_text = option_b_text;
		}
		public String getOption_c_text() {
			return option_c_text;
		}
		public void setOption_c_text(String option_c_text) {
			this.option_c_text = option_c_text;
		}
		public String getOption_d_text() {
			return option_d_text;
		}
		public void setOption_d_text(String option_d_text) {
			this.option_d_text = option_d_text;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		@Override
		 public String toString() {
		        return "QuestionSubmit [ qs = "+this.q_text+", ans=" +this.answer+",marks= "+this.marks+"]";
		 }
}
