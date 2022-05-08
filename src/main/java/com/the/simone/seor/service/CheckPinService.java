package com.the.simone.seor.service;

import org.springframework.stereotype.Service;

import com.the.simone.seor.command.abstrac.ActionService;
import com.the.simone.seor.model.request.CheckPinRequest;
import com.the.simone.seor.model.response.CheckPinResponse;

@Service
public class CheckPinService extends ActionService<CheckPinRequest, CheckPinResponse>{

	@Override
	public CheckPinResponse call(CheckPinRequest iRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
