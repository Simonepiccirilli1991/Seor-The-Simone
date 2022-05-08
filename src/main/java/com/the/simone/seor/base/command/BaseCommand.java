package com.the.simone.seor.base.command;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.the.simone.seor.command.abstrac.ActionService;
import com.the.simone.seor.model.command.ActionRequest;
import com.the.simone.seor.model.command.ActionResponse;


public class BaseCommand<I extends ActionRequest, O extends ActionResponse> {
	

	@Autowired
	private BeanFactory beanFactory;
	
	// Parametri di input per il service
	protected I iRequest;

	protected boolean canExecute() {
		return this.iRequest != null;
	}
	
	public BaseCommand(I iRequest){
		this.iRequest = iRequest;
	}
	
	public final <T extends ActionService<I, O>> O getResponse(Class<T> serviceClass)  {

		return beanFactory.getBean(serviceClass).call(iRequest);
	}
	

}
