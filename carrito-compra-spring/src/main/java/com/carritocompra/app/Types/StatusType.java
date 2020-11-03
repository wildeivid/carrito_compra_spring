package com.carritocompra.app.Types;

public enum StatusType {
	
	PENDING(0, "PENDING"),
	COMPLETED(1, "COMPLETED");
	
	private int idStatus;
	private String status;

	private StatusType(int idStatus, String status) {
		this.idStatus = idStatus;
		this.status = status;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
