package com.lyt.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Array;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyt.member.dao.LytFanliDao;
import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;

public class LytFanliServiceTest {


	ApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/lyt/member/config/spring.xml");
	LytFanliDao lytFanliDao = (LytFanliDao) ac.getBean("lytFanliDao");
	LytHuiyuanDao lytHuiyuanDao = (LytHuiyuanDao) ac
	.getBean("lytHuiyuanDao");
	@Test
	public void testQueryAll() {
		String hql = "from LytFanli as l  ORDER BY fanliTime desc";
//		List<LytFanli> lytFanlis = lytFanliDao.queryByTypeHy(1, lytHuiyuanDao.queryById("06"));
		List<LytFanli> lytFanlis = lytFanliDao.queryByTypeHy(1, "31000");
		System.out.println(lytFanlis);
		for(LytFanli lytFanli :lytFanlis){
			System.out.println(lytFanli.getId());
			System.out.println(lytFanli.getFanliMoney());
		}
	}

	@Test
	public void testQueryByType() {
		List<LytFanli> lytFanlis = new ArrayList<LytFanli>();
		lytFanlis= lytFanliDao.queryAll(null);
		System.out.println(lytFanlis);
		for(LytFanli lytFanli :lytFanlis){
			System.out.println(lytFanli.getId());
			System.out.println(lytFanli.getFanliMoney());
		}
	}
	@Test
	public void testQueryByName() {
		LytHuiyuan lytHuiyuan = new LytHuiyuan();
		lytHuiyuan= lytHuiyuanDao.queryByName("la");
			System.out.println(lytHuiyuan.getId());
			System.out.println(lytHuiyuan.getHyname());
	}

}
