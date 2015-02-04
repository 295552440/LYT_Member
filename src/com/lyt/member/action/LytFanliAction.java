package com.lyt.member.action;

import com.lyt.member.service.LytFanliService;
import com.opensymphony.xwork2.ActionContext;

public class LytFanliAction extends BaseAction {

	private LytFanliService lytFanliService;

	public LytFanliService getLytFanliService() {
		return lytFanliService;
	}

	public void setLytFanliService(LytFanliService lytFanliService) {
		this.lytFanliService = lytFanliService;
	}
	
	 Exception ex = (Exception) ActionContext.getContext() .getValueStack().findValue("exception");   
}
