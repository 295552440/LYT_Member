package com.lyt.member.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lyt.member.dao.LytFanliDao;
import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;

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
			if(lytHuiyuan.getHycardId().equals(""))
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
	
	public List<LytFanli> queryByTypeHy(int type,String hycardId) {
		return lytFanliDao.queryByTypeHy(type, lytHuiyuanDao.queryByCardId(hycardId));
//		lytHuiyuanDao.queryByCardId(hycardId)
	}
	
}
