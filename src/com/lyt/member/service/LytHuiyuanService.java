package com.lyt.member.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.util.Constant;
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

	public List<LytHuiyuan> queryAllLytHuiyuan() {
		return lytHuiyuanDao.queryAllLytHuiyuan();
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public LytHuiyuan queryById(String id){
		return lytHuiyuanDao.queryById(id);
	}
	/**
	 * 根据会员名字查询
	 * @param name
	 * @return
	 */
	public LytHuiyuan queryByName(String name){
		return lytHuiyuanDao.queryByName(name);
	}

	/**
	 * 根据卡号查询
	 * @param name
	 * @return
	 */
	public LytHuiyuan queryByCardId(String hycardId){
		return lytHuiyuanDao.queryByCardId(hycardId);
	}
	
	@SuppressWarnings("finally")
	public String addLytHuiyuan(LytHuiyuan lytHuiyuan) {
		String message = null;
		try {
			if (lytHuiyuan.getHyState().equals(0))
				message = "申请已提交，请等待审核通过。";
			else if (lytHuiyuan.getHyState().equals(1)) {
				String cardId = new SimpleDateFormat("yyyyMMddHHmmss").format(
						new Date().getTime()).concat(Constant.getRandomNum(2));
				if (lytHuiyuan.getHyLevel().equals("钻卡")) {
					lytHuiyuan.setHycardId("DC".concat(cardId));
				} else if (lytHuiyuan.getHyLevel().equals("金卡")) {
					lytHuiyuan.setHycardId("GC".concat(cardId));
				} else if (lytHuiyuan.getHyLevel().equals("银卡")) {
					lytHuiyuan.setHycardId("SC".concat(cardId));
				} else {
					// return "系统不识别会员级别，请重试！";
					return "1";
				}
				message = lytHuiyuan.getHycardId();
			}
			lytHuiyuanDao.addLytHuiyuan(lytHuiyuan);

		} catch (Exception e) {
			System.out.println(e.toString());
			// message = "系统出现未知错误，请稍后重试！";
			message = "2";
		} finally {
			return message;
		}
	}

	/**
	 * queryByOrder
	 */

	public List<LytHuiyuan> queryByOrder(Page page, String pageMethod,
			String order) {
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

		this.page = page;

		return list;

	}

	/**
	 * queryByState
	 */
	public List<LytHuiyuan> queryByState(Page page, String pageMethod,
			String state) {
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
		list = lytHuiyuanDao.queryBySearch(searchBy, searchInput,
				page.getStartRow());

		// 将执行完后的page作为photoService的静态变量再传递给photoAction,及时更新页面page
		this.page = page;

		return list;

	}

	/**
	 * updateState
	 */
	public List<LytHuiyuan> updateState(LytHuiyuan hy) {

		String id = hy.getId();
		LytHuiyuan hyQuery = lytHuiyuanDao.queryById(id);

		if (hyQuery.getHyState() == 0) {
			hyQuery.setHyState(1);
		} else {
			hyQuery.setHyState(0);
		}

		lytHuiyuanDao.updateLytHuiyuan(hyQuery);
		return null;

	}

	public List<LytHuiyuan> delete(LytHuiyuan hy) {

		String id = hy.getId();
		LytHuiyuan hyQuery = lytHuiyuanDao.queryById(id);

		lytHuiyuanDao.deleteLytHuiyuan(hyQuery);

		return null;

	}
}
