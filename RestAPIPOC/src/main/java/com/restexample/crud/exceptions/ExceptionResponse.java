package com.restexample.crud.exceptions;

import java.util.List;

public class ExceptionResponse {

	 private String resMsg;
	 private String userid;
	 private List<String> errors;
	 
	    public ExceptionResponse() {
	    }

		public String getResMsg() {
			return resMsg;
		}

		public void setResMsg(String resMsg) {
			this.resMsg = resMsg;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}
	   
}
