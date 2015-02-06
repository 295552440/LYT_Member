package com.lyt.member.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;

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
	
	/**
	 * 查询所有
	 * @param hql
	 * @return
	 */
	public List<LytFanli> queryAll(String hql) {
		return hibernateTemplate.find(hql);
	}

	/**
	 * 根据类型排序查询
	 * @param type
	 * @return
	 */
	public List<LytFanli> queryByType(int fanliState) {
		return hibernateTemplate
				.find("from LytFanli as l where l.fanliState= ? ORDER BY fanliTime desc",
						fanliState);
		
	}
	
	/**
	 * 通过用户卡号，和类型查询返利信息
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<LytFanli> queryByTypeHy(int type,String hyid) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx= session.beginTransaction();
			String hql = "from LytFanli as l where l.fanliType = ? and l.lytHuiyuanByTjrId.id =? ORDER BY fanliTime desc";
			List<LytFanli> lytFanlis = session.createQuery(hql)
				.setInteger(0, type)
				.setString(1,  hyid)
				.list();
			
			
			tx.commit();
			return lytFanlis;
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			session.close();
		}
		
	}

}
