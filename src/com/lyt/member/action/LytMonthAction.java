package com.lyt.member.action;

import com.lyt.member.service.LytMonthService;

public class LytMonthAction extends BaseAction {
private LytMonthService lytMonthService;

public LytMonthService getLytMonthService() {
	return lytMonthService;
}

public void setLytMonthService(LytMonthService lytMonthService) {
	this.lytMonthService = lytMonthService;
}

}
