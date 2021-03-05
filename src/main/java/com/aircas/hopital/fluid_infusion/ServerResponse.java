package com.aircas.hopital.fluid_infusion;

public class ServerResponse {
	private Long timestamp;
	private String message;
	private Object data;
	private Integer status;
	
	public ServerResponse(String message, Object data) {
		super();
		this.timestamp = Tools.getTimeStamp();
		this.setMessage(message);;
		this.data = data;
//		this.status = status;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		if (this.message.equals("OK")){
			this.status = 0;
		}
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
