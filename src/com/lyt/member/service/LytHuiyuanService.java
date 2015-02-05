package com.lyt.member.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;




import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.util.Page;

public class LytHuiyuanService {

	private LytHuiyuanDao lytHuiyuanDao;
	public static Page page;// 页面
	public LytHuiyuanDao getLytHuiyuanDao() {
		return lytHuiyuanDao;
	}

	public void setLytHuiyuanDao(LytHuiyuanDao lytHuiyuanDao) {
		this.lytHuiyuanDao = lytHuiyuanDao;
	}
	
	public List<LytHuiyuan> queryAllLytHuiyuan(){
		return lytHuiyuanDao.queryAllLytHuiyuan();
	}
	
	
	
	/**
	 * queryByOrder
	 */

	public List<LytHuiyuan> queryByOrder(Page page, String pageMethod, String order) {
		// 首次加载时，设置当前页为第一页
		int currentPage = page.getCurrentPage();

		if (currentPage == 0) {
			currentPage = 1;
		}

		// 查询全部数据，得到数据总行数

		int totalRows = lytHuiyuanDao.queryAllLytHuiyuan().size();
		page = page.getPage(currentPage, pageMethod, totalRows);
		List list = new ArrayList<LytHuiyuan>();
		list = lytHuiyuanDao.queryByOrder(order, page.getStartRow());

		// 将执行完后的page作为photoService的静态变量再传递给photoAction,及时更新页面page
		this.page = page;

		return list;

	}

	
	/**
	 * queryByState
	 */
	public List<LytHuiyuan> queryByState(Page page, String pageMethod, String state) {
		// 首次加载时，设置当前页为第一页
		int currentPage = page.getCurrentPage();
		if (currentPage == 0) {
			currentPage = 1;
		}
		// 查询全部数据，得到数据总行数
		int totalRows = lytHuiyuanDao.querySize(state, null).size();

		page = page.getPage(currentPage, pageMethod, totalRows);
		List list = new ArrayList<LytHuiyuan>();

		list = lytHuiyuanDao.queryByState(state, page.getStartRow());

		// 将执行完后的page作为photoService的静态变量再传递给photoAction,及时更新页面page
		this.page = page;
		return list;

	}
	
	/**
	 * queryBySearch
	 */
	public List<LytHuiyuan> queryBySearch(Page page, String pageMethod,
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
		int totalRows = lytHuiyuanDao.querySize(searchBy, searchInput).size();

		page = page.getPage(currentPage, pageMethod, totalRows);
		List list = new ArrayList<LytHuiyuan>();
		list = lytHuiyuanDao.queryBySearch(searchBy, searchInput, page.getStartRow());

		// 将执行完后的page作为photoService的静态变量再传递给photoAction,及时更新页面page
		this.page = page;

		return list;

	}
	
	
	
	
	
}
