package com.lyt.member.service;

import java.util.List;

import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytHuiyuan;

public class LytHuiyuanService {

	private LytHuiyuanDao lytHuiyuanDao;

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
}
