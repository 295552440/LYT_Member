package com.lyt.member.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.lyt.member.dao.LytFanliDao;
import com.lyt.member.dao.LytHuiyuanDao;
import com.lyt.member.dao.LytMonthDao;
import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.entity.LytMonth;
import com.lyt.member.util.Pageliu;

public class LytFanliService {

	@Resource(name = "lytFanliDao")
	private LytFanliDao lytFanliDao;
	@Resource(name = "lytHuiyuanDao")
	private LytHuiyuanDao lytHuiyuanDao;
	private LytMonthDao lytMonthDao;

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

	public LytMonthDao getLytMonthDao() {
		return lytMonthDao;
	}

	public void setLytMonthDao(LytMonthDao lytMonthDao) {
		this.lytMonthDao = lytMonthDao;
	}

	public boolean addFanli(LytHuiyuan hy) {
		try {
			String id = hy.getId();
			LytHuiyuan lytHuiyuan = lytHuiyuanDao.queryById(id);
			if (lytHuiyuan.getHycardId() == null)
				return false;
			else {
				LytFanli lytFanli = new LytFanli();
				lytFanli.setLytHuiyuanByTjrId(lytHuiyuanDao
						.queryByCardId(lytHuiyuan.getTjrId()));
				lytFanli.setLytHuiyuanByBtjrId(lytHuiyuanDao
						.queryByCardId(lytHuiyuan.getHycardId()));
				lytFanli.setTjTime(lytHuiyuan.getApplyTime());
				double money = 0;
				String hyLevel = lytHuiyuan.getHyLevel();
				if (hyLevel.equals("钻卡")) {
					money = 1000;
				} else if (hyLevel.equals("金卡")) {
					money = 500;
				} else if (hyLevel.equals("银卡")) {
					money = 100;
				}
				lytFanli.setFanliMoney(money);
				lytFanli.setFanliType(0);
				lytFanliDao.addFanli(lytFanli);
				this.addLytMonth(lytHuiyuan);
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
		} else {
			hql = "from LytFanli ";
		}
		return lytFanliDao.queryAll(hql);
	}

	/**
	 * 动态多条件查询加分页
	 * 
	 * @param type
	 * @param hycardId
	 * @param fanliState
	 * @param currentPage
	 * @return
	 */
	public List<LytFanli> queryByTypeHy(Integer type, String hycardId,
			Integer fanliState, Integer currentPage) {
		currentPage = (currentPage - 1) * Pageliu.PAGE_SIZE;
		System.out.println(fanliState + "'" + type + "'" + hycardId);

		return lytFanliDao.queryByC(fanliState, type, hycardId, currentPage,
				Pageliu.PAGE_SIZE);
	}

	/**
	 * 分页的总行数
	 * 
	 * @param type
	 * @param hycardId
	 * @param fanliState
	 * @return
	 */
	public int queryByTotalRows(Integer type, String hycardId,
			Integer fanliState) {
		int totalRows = lytFanliDao
				.queryByTotalRows(fanliState, type, hycardId);
		return totalRows;
	}

	private void addLytMonth(LytHuiyuan lytHuiyuan) {
		LytMonth lytMonth = new LytMonth();
		List<LytMonth> list = lytMonthDao.queryByCardId(lytHuiyuan.getTjrId());
		int num = list.size();
		boolean flag = false;
		if (num == 0) {
			lytMonth.setTjrCardId(lytHuiyuan.getTjrId());
			lytMonth.setTjTime(lytHuiyuan.getApplyTime());
			lytMonth.setTjRenshu(1);
			lytMonth.setFanLimoney(0.00);
			lytMonthDao.addLytMonth(lytMonth);
		} else if (num > 0) {
			Iterator<LytMonth> it = list.iterator();
			while (it.hasNext()) {
				LytMonth lytMonth0 = it.next();
				String str0 = lytMonth0.getTjTime().toString().substring(0, 7);
				System.out.println(str0);
				String str1 = lytHuiyuan.getApplyTime().toString()
						.substring(0, 7);
				if (str0.equals(str1)) {
					flag = true;
					lytMonth = lytMonth0;
					if (lytMonth0.getTjRenshu() >= 50
							&& lytMonth0.getTjRenshu() < 100) {
						lytMonth.setFanLimoney(1000.00);
					} else if (lytMonth0.getTjRenshu() >= 100) {
						lytMonth.setFanLimoney(3000.00);
					}
					break;
				}
			}
			if (flag) {
				int count = lytMonth.getTjRenshu();
				lytMonth.setTjRenshu(++count);
				lytMonthDao.updateRenShu(lytMonth);
			} else {
				lytMonth.setTjrCardId(lytHuiyuan.getTjrId());
				lytMonth.setTjTime(lytHuiyuan.getApplyTime());
				lytMonth.setTjRenshu(1);
				lytMonth.setFanLimoney(0.00);
				lytMonthDao.addLytMonth(lytMonth);
			}
		}
	}

	/**
	 * 更新返利状态
	 * 
	 * @param flid
	 * @return
	 */
	public boolean updateState(String flid) {
		return lytFanliDao.updateState(flid);
	}

}
