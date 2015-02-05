package com.lyt.member.dao;

import com.lyt.member.entity.LytFanli;

public class LytFanliDao extends BaseDao {

	
	
	
	public boolean addFanli(LytFanli lytFanli) {
		try {
			hibernateTemplate.save(lytFanli);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
}
