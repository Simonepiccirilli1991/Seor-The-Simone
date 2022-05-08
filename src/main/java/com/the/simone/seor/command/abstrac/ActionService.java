package com.the.simone.seor.command.abstrac;

import com.the.simone.seor.model.command.ActionRequest;
import com.the.simone.seor.model.command.ActionResponse;

public abstract class ActionService<I extends ActionRequest,O extends ActionResponse> {
	public abstract O call(I iRequest);
}
