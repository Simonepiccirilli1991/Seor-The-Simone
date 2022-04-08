package com.the.simone.seor.model.response;

import com.the.simone.seor.model.BaseResponse;

public class GoogleCaptchaResponse extends BaseResponse{

	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
