package com.lyt.member.service;

import java.util.ArrayList;
import java.util.List;

import com.lyt.member.dao.LytMonthDao;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.entity.LytMonth;
import com.lyt.member.util.Page;

public class LytMonthService {
private LytMonthDao lytMonthDao;
public static Page page;// 页面
public LytMonthDao getLytMonthDao() {
	return lytMonthDao;
}

public void setLytMonthDao(LytMonthDao lytMonthDao) {
	this.lytMonthDao = lytMonthDao;
}








/**
 * queryByOrder
 */

public List<LytMonth> queryByOrder(Page page, String pageMethod,
		String order) {
	// 首次加载时，设置当前页为第一页
	int currentPage = page.getCurrentPage();

	if (currentPage == 0) {
		currentPage = 1;
	}

	// 查询全部数据，得到数据总行数

	int totalRows = lytMonthDao.queryAll().size();
	page = page.getPage(currentPage, pageMethod, totalRows);
	List list = new ArrayList<LytHuiyuan>();
	list = lytMonthDao.queryByOrder(order, page.getStartRow());

	this.page = page;

	return list;

}
}
