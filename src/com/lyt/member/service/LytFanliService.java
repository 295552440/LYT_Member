package com.lyt.member.service;

import java.util.List;

import com.lyt.member.dao.LytFanliDao;
import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.util.Pageliu;

public class LytFanliService {

	private LytFanliDao lytFanliDao;
	private LytHuiyuanDao lytHuiyuanDao;

	public LytFanliDao getLytFanliDao() {
		return lytFanliDao;
	}

	public void setLytFanliDao(LytFanliDao lytFanliDao) {
		this.lytFanliDao = lytFanliDao;
	}
	
	public LytHuiyuanDao getLytHuiyuanDao() {
		return lytHuiyuanDao;
	}

	public void setLytHuiyuanDao(LytHuiyuanDao lytHuiyuanDao) {
		this.lytHuiyuanDao = lytHuiyuanDao;
	}

	public boolean addFanli(LytHuiyuan lytHuiyuan) {
		try {
			if(lytHuiyuan.getHycardId()==null)
				return false;
			else {
				LytFanli lytFanli  = new LytFanli();
				lytFanli.setLytHuiyuanByTjrId(lytHuiyuanDao.queryByCardId(lytHuiyuan.getTjrId()));
				lytFanli.setLytHuiyuanByBtjrId(lytHuiyuanDao.queryByCardId(lytHuiyuan.getHycardId()));
				lytFanliDao.addFanli(lytFanli);
				return true;
			}
		} catch (Exception e) {
			System.out.println("LytFanliService:addFanli" + e.toString());
			return false;
		}
	}

	public List<LytFanli> queryAll(String shunxu) {
		String hql = "";
		if (shunxu == "desc") {
			hql = "from LytFanli as l  ORDER BY fanliTime desc";
		}else {
			hql = "from LytFanli ";
		}
		return lytFanliDao.queryAll(hql);
	}
	
	public List<LytFanli> queryByTypeHy(Integer type,String hycardId,Integer fanliState,Integer currentPage) {
		currentPage = (currentPage-1)*Pageliu.PAGE_SIZE;
		return lytFanliDao.queryByC(fanliState, type, hycardId,currentPage,Pageliu.PAGE_SIZE);
	}
	public int queryByTotalRows(Integer type,String hycardId,Integer fanliState) {
		int totalRows = lytFanliDao.queryByTotalRows(fanliState, type, hycardId);
		return totalRows;
	}
	public boolean updateState(Integer flid) {
		return lytFanliDao.updateState(flid);
	}
	
}
