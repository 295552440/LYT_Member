package com.lyt.member.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;

public class LytHuiyuanServiceTest {

	
//	private String id;
//	private LytHuiyuan lytHuiyuanByBtjrId;
//	private LytHuiyuan lytHuiyuanByTjrId;
//	private Timestamp tjTime;
//	private Integer fanliState;
//	private Double fanliMoney;
//	private Integer fanliType;
//	private Timestamp fanliTime;
	@Test
	public void testQueryAllLytHuiyuan() {
		 ApplicationContext ac = new ClassPathXmlApplicationContext("/LYT_Member/src/com/lyt/member/config/spring.xml");  
		 LytHuiyuanDao lytHuiyuanDao= (LytHuiyuanDao) ac.getBean("lytHuiyuanDao");  
	     List<LytHuiyuan> ls = lytHuiyuanDao.queryAllLytHuiyuan();
		System.out.println(ls);
	}

	@Test
	public void testQueryById() {
		LytHuiyuanDao lytHuiyuanDao= new LytHuiyuanDao();
		LytHuiyuan lytHuiyuan = new LytHuiyuan();
		lytHuiyuan = lytHuiyuanDao.queryById("15");
		System.out.println("-----"+lytHuiyuan.getId());
		System.out.println("--"+lytHuiyuan.getTjrId());
		
	}

}
