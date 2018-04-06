package com.spgroup.friendmanagement.model;

public class SPGroupErrorResponse {
	
	private boolean failure;
	private String reason;
	public boolean isFailure() {
		return failure;
	}
	public void setFailure(boolean failure) {
		this.failure = failure;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
