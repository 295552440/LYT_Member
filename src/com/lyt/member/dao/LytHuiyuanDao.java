package com.lyt.member.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

 
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.util.Constant;

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
		String hql = "from LytHuiyuan";
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
	/**
	 * queryByOrder
	 */
	public List<LytHuiyuan> queryByOrder(String order, int startRow) {
		String hql = "from LytHuiyuan ";// Ĭ��

		if ("date_desc".equals(order)) {
			hql = "from LytHuiyuan ORDER BY applyTime desc";
		} else if ("date".equals(order)) {
			hql = "from LytHuiyuan ORDER BY applyTime";
		} else if ("id_desc".equals(order)) {
			hql = "from LytHuiyuan ORDER BY hycardId desc";
		} else if ("id".equals(order)) {
			hql = "from LytHuiyuan ORDER BY hycardId";
		}

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		// ����ȡ��һ����Χ�ڵ����ݣ��������ݷ�ҳ��ʾ
		query.setFirstResult(startRow);// ���ý������һ�����ݵ�������ע�⣺��0�п�ʼ����
		query.setMaxResults(Constant.PAGE_SIZE);// ����ÿҳ��ʾ����
		return query.list();
	}

}
