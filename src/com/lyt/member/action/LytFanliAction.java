package com.lyt.member.action;

import java.util.List;

import javassist.expr.NewArray;

import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.service.LytFanliService;
import com.lyt.member.service.LytHuiyuanService;
import com.opensymphony.xwork2.ActionContext;

public class LytFanliAction extends BaseAction {

	private LytFanliService lytFanliService;
	private LytHuiyuanService lytHuiyuanService;
	

	public void setLytHuiyuanService(LytHuiyuanService lytHuiyuanService) {
		this.lytHuiyuanService = lytHuiyuanService;
	}

	public LytFanliService getLytFanliService() {
		return lytFanliService;
	}

	public void setLytFanliService(LytFanliService lytFanliService) {
		this.lytFanliService = lytFanliService;
	}
	
//	Exception ex = (Exception) ActionContext.getContext() .getValueStack().findValue("exception"); 
	 
	private List<LytFanli> lytFanlis;
	private Integer fanliType;
	private String hycardId;
	private Integer fanliState;
	private LytHuiyuan lytHuiyuan = new LytHuiyuan();


	public LytHuiyuan getLytHuiyuan() {
		return lytHuiyuan;
	}

	public void setLytHuiyuan(LytHuiyuan lytHuiyuan) {
		this.lytHuiyuan = lytHuiyuan;
	}

	public Integer getFanliType() {
		return fanliType;
	}

	public void setFanliType(Integer fanliType) {
		this.fanliType = fanliType;
	}

	public Integer getFanliState() {
		return fanliState;
	}

	public void setFanliState(Integer fanliState) {
		this.fanliState = fanliState;
	}

	public List<LytFanli> getLytFanlis() {
		return lytFanlis;
	}

	public void setLytFanlis(List<LytFanli> lytFanlis) {
		this.lytFanlis = lytFanlis;
	}


	public String getHycardId() {
		return hycardId;
	}

	public void setHycardId(String hycardId) {
		this.hycardId = hycardId;
	}

	/**
	 * 通过会员id,返利的类型，返利的状态，查
	 * @return
	 */
	public String queryByTypeHy() {
		lytFanlis = lytFanliService.queryByTypeHy(fanliType, hycardId,fanliState);
		lytHuiyuan = lytHuiyuanService.queryByCardId(hycardId);
		return SUCCESS;
		
	}
}
