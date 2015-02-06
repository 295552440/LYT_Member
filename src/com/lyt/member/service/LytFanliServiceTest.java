//package com.lyt.member.service;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.lyt.member.dao.LytFanliDao;
//import com.lyt.member.entity.LytFanli;
//
//public class LytFanliServiceTest {
//
//
//	@Test
//	public void testQueryAll() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext(
//		"com/lyt/member/config/spring.xml");
//		LytFanliDao lytFanliDao = (LytFanliDao) ac.getBean("lytFanliDao");
//		String hql = "from LytFanli as l  ORDER BY fanliTime desc";
//		List<LytFanli> lytFanlis = lytFanliDao.queryAll(hql);
//		for(LytFanli lytFanli :lytFanlis){
//			System.out.println(lytFanli.getId());
//			System.out.println(lytFanli.getFanliMoney());
//		}
//	}
//
//	@Test
//	public void testQueryByType() {
//		List<LytFanli> lytFanlis = lytFanliDao.queryByType(1);
//		for(LytFanli lytFanli :lytFanlis){
//			System.out.println(lytFanli.getId());
//			System.out.println(lytFanli.getFanliMoney());
//		}
//	}
//
//}
