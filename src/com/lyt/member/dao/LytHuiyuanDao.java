package com.lyt.member.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.lyt.member.entity.LytHuiyuan;

@Transactional
public class LytHuiyuanDao extends BaseDao {
	public boolean addLytHuiyuan(LytHuiyuan lytHuiyuan) {
		sessionFactory.getCurrentSession().save(lytHuiyuan);
		return true;
	}

	public boolean deleteLytHuiyuan(LytHuiyuan lytHuiyuan) {
		sessionFactory.getCurrentSession().delete(lytHuiyuan);
		return true;
	}

	public boolean updateLytHuiyuan(LytHuiyuan lytHuiyuan) {
		sessionFactory.getCurrentSession().update(lytHuiyuan);
		return true;
	}

	public List<LytHuiyuan> queryAllLytHuiyuan() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from LytHuiyuan ORDER BY applyTime desc";// ��������
		Query query = session.createQuery(hql);
		return query.list();
	}

	public LytHuiyuan queryById(String id) {
		LytHuiyuan lytHuiyuan = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from LytHuiyuan as l where l.id=?";
		Query query = session.createQuery(hql);
		query.setString(0, id);
		lytHuiyuan = (LytHuiyuan) query.uniqueResult();
		return lytHuiyuan;
	}
	public LytHuiyuan queryByName(String name) {
		LytHuiyuan lytHuiyuan = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from LytHuiyuan as l where l.hyname=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		lytHuiyuan = (LytHuiyuan) query.uniqueResult();
		return lytHuiyuan;
	}
}
