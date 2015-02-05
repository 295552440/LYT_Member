package com.lyt.member.service;

import java.util.Set;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;

public class LytHuiyuanServiceTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/lyt/member/config/spring.xml");

	@Test
	public void testQueryAllLytHuiyuan() {
		LytHuiyuanDao lytHuiyuanDao = (LytHuiyuanDao) ac
				.getBean("lytHuiyuanDao");
		// List<LytHuiyuan> ls = lytHuiyuanDao.queryAllLytHuiyuan();
		LytHuiyuan lytHuiyuan = lytHuiyuanDao.queryById("06");
		Set<LytFanli> lytFanlis = lytHuiyuan.getLytFanlisForTjrId();

		if (lytFanlis.isEmpty()) {
			System.out.println("null");
		}
		for (LytFanli lytFanli : lytFanlis) {
			System.out.println(lytFanli.getId());
			System.out.println(lytFanli.getFanliMoney());
		}
	}

	@Test
	public void testQueryById() {
		LytHuiyuanDao lytHuiyuanDao = (LytHuiyuanDao) ac
				.getBean("lytHuiyuanDao");
		LytHuiyuan lytHuiyuan = new LytHuiyuan();
		lytHuiyuan = lytHuiyuanDao.queryById("15");
		System.out.println("--" + lytHuiyuan.getTjrId());

	}

}
