package com.the.simone.seor.command;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.the.simone.seor.base.command.BaseCommand;
import com.the.simone.seor.model.request.CheckPinRequest;
import com.the.simone.seor.model.response.CheckPinResponse;
import com.the.simone.seor.service.CheckPinService;



@Component
@Scope("prototype")
public class CheckPinCommand extends BaseCommand<CheckPinRequest, CheckPinResponse>{
	
	
	public CheckPinCommand(CheckPinRequest iRequest) {
		super(iRequest);
	}
	
	String action = iRequest.getAction();
	
		
	//TODO implementare constanti e exception
	public CheckPinResponse doExecute() throws Exception{
	
		switch  (super.iRequest.getAction()){
		
		case "CheckPin" :
			return super.getResponse(CheckPinService.class);
		
			default:
				return super.getResponse(CheckPinService.class);
		}
	}
}
