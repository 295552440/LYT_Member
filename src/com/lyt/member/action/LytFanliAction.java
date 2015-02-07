package com.lyt.member.action;

import java.util.List;

import com.lyt.member.entity.LytFanli;
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
	 
	private int fanliType;
	private String hycardId;
	private List<LytFanli> lytFanlis;
	public List<LytFanli> getLytFanlis() {
		return lytFanlis;
	}

	public void setLytFanlis(List<LytFanli> lytFanlis) {
		this.lytFanlis = lytFanlis;
	}

	public int getFanliType() {
		return fanliType;
	}

	public void setFanliType(int fanliType) {
		this.fanliType = fanliType;
	}

	public String getHycardId() {
		return hycardId;
	}

	public void setHycardId(String hycardId) {
		this.hycardId = hycardId;
	}

	public String queryByTypeHy() {
		lytFanlis = lytFanliService.queryByTypeHy(fanliType, hycardId);
		return SUCCESS;
		
	}
}
