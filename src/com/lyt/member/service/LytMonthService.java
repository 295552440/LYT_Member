package com.lyt.member.service;

import com.lyt.member.dao.LytMonthDao;

public class LytMonthService {
private LytMonthDao lytMonthDao;

public LytMonthDao getLytMonthDao() {
	return lytMonthDao;
}

public void setLytMonthDao(LytMonthDao lytMonthDao) {
	this.lytMonthDao = lytMonthDao;
}

}
