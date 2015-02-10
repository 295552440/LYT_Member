package com.lyt.member.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lyt.member.dao.LytMonthDao;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.entity.LytMonth;
import com.lyt.member.util.Constant;
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

	/**
	 * queryByState
	 */
	public List<LytMonth> queryByState(Page page, String pageMethod,
			String state) {
		// 首次加载时，设置当前页为第一页
		int currentPage = page.getCurrentPage();
		if (currentPage == 0) {
			currentPage = 1;
		}
		// 查询全部数据，得到数据总行数
		int totalRows = lytMonthDao.querySize(state, null).size();

		page = page.getPage(currentPage, pageMethod, totalRows);
		List list = new ArrayList<LytMonth>();

		list = lytMonthDao.queryByState(state, page.getStartRow());

		// 将执行完后的page作为photoService的静态变量再传递给photoAction,及时更新页面page
		this.page = page;
		return list;

	}

	/**
	 * queryBySearch
	 */
	public List<LytMonth> queryBySearch(Page page, String pageMethod,
			String searchBy, String searchInput) {
		// 首次加载时，设置当前页为第一页
		int currentPage = page.getCurrentPage();
		if (currentPage == 0) {
			currentPage = 1;
		}

		if (searchInput != null) {
			searchInput = searchInput.trim();
			// 字符转码
			try {
				searchInput = new String(searchInput.getBytes("iso-8859-1"),
						"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			searchInput = "";
		}
		int totalRows = lytMonthDao.querySize(searchBy, searchInput).size();

		page = page.getPage(currentPage, pageMethod, totalRows);
		List list = new ArrayList<LytMonth>();
		list = lytMonthDao.queryBySearch(searchBy, searchInput,
				page.getStartRow());

		// 将执行完后的page作为photoService的静态变量再传递给photoAction,及时更新页面page
		this.page = page;

		return list;

	}

	public List<LytMonth> queryByCardId(String cardId) {
		return lytMonthDao.queryByCardId(cardId);
	}

	public void addLytMonth(LytMonth lytMonth) {
		lytMonthDao.addLytMonth(lytMonth);
	}

}
