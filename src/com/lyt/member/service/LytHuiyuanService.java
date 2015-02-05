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
	public static Page page;// ҳ��
	public LytHuiyuanDao getLytHuiyuanDao() {
		return lytHuiyuanDao;
	}

	public void setLytHuiyuanDao(LytHuiyuanDao lytHuiyuanDao) {
		this.lytHuiyuanDao = lytHuiyuanDao;
	}
	
	public List<LytHuiyuan> queryAllLytHuiyuan(){
		return lytHuiyuanDao.queryAllLytHuiyuan();
	}
	
	public LytHuiyuan queryById(String id){
		return lytHuiyuanDao.queryById(id);
	}
	public LytHuiyuan queryByName(String name){
		return lytHuiyuanDao.queryByName(name);
	}
	public String addLytHuiyuan(LytHuiyuan lytHuiyuan) {
		String message = null;
		try {
			if (lytHuiyuan.getHyState().equals(0))
				message = "�������ύ����ȴ����ͨ��";
			else if (lytHuiyuan.getHyState().equals(1)) {
				String cardId = new SimpleDateFormat("yyyyMMddHHmmss").format(
						new Date().getTime()).concat(Constant.getRandomNum(2));
				if (lytHuiyuan.getHyLevel() == "�꿨") {
					lytHuiyuan.setHycardId("DC".concat(cardId));
				} else if (lytHuiyuan.getHyLevel() == "��") {
					lytHuiyuan.setHycardId("GC".concat(cardId));
				} else if (lytHuiyuan.getHyLevel() == "��") {
					lytHuiyuan.setHycardId("SC".concat(cardId));
				} else {
					// return "ϵͳ��ʶ���Ա���������ԣ�";
					return "1";
				}
				message = lytHuiyuan.getHycardId();
			}
			lytHuiyuanDao.addLytHuiyuan(lytHuiyuan);

		} catch (Exception e) {
			System.out.println(e.toString());
			// message = "ϵͳ����δ֪�������Ժ����ԣ�";
			message = "2";
		} finally {
			return message;
		}
	}
	
	
	/**
	 * queryByOrder
	 */

	public List<LytHuiyuan> queryByOrder(Page page, String pageMethod, String order) {
		// �״μ���ʱ�����õ�ǰҳΪ��һҳ
		int currentPage = page.getCurrentPage();

		if (currentPage == 0) {
			currentPage = 1;
		}

		// ��ѯȫ����ݣ��õ����������

		int totalRows = lytHuiyuanDao.queryAllLytHuiyuan().size();
		page = page.getPage(currentPage, pageMethod, totalRows);
		List list = new ArrayList<LytHuiyuan>();
		list = lytHuiyuanDao.queryByOrder(order, page.getStartRow());

		// ��ִ������page��ΪphotoService�ľ�̬�����ٴ��ݸ�photoAction,��ʱ����ҳ��page
		this.page = page;

		return list;

	}

	
	/**
	 * queryByState
	 */
	public List<LytHuiyuan> queryByState(Page page, String pageMethod, String state) {
		// �״μ���ʱ�����õ�ǰҳΪ��һҳ
		int currentPage = page.getCurrentPage();
		if (currentPage == 0) {
			currentPage = 1;
		}
		// ��ѯȫ����ݣ��õ����������
		int totalRows = lytHuiyuanDao.querySize(state, null).size();

		page = page.getPage(currentPage, pageMethod, totalRows);
		List list = new ArrayList<LytHuiyuan>();

		list = lytHuiyuanDao.queryByState(state, page.getStartRow());

		// ��ִ������page��ΪphotoService�ľ�̬�����ٴ��ݸ�photoAction,��ʱ����ҳ��page
		this.page = page;
		return list;

	}
	
	/**
	 * queryBySearch
	 */
	public List<LytHuiyuan> queryBySearch(Page page, String pageMethod,
			String searchBy, String searchInput) {
		// �״μ���ʱ�����õ�ǰҳΪ��һҳ
		int currentPage = page.getCurrentPage();
		if (currentPage == 0) {
			currentPage = 1;
		}

		if (searchInput != null) {
			searchInput = searchInput.trim();
			// �ַ�ת��
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

		// ��ִ������page��ΪphotoService�ľ�̬�����ٴ��ݸ�photoAction,��ʱ����ҳ��page
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
	
}
