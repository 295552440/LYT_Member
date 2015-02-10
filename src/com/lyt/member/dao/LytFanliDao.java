package com.lyt.member.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.lyt.member.entity.LytFanli;
@Transactional
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
	public List<LytFanli> queryByTypeHy(Integer type,String hycardId) {
		Session session = sessionFactory.getCurrentSession();
			String hql = "from LytFanli as l where l.fanliType = ? and l.lytHuiyuanByTjrId.hycardId =? ORDER BY fanliTime desc";
			@SuppressWarnings("unchecked")
			List<LytFanli> lytFanlis = session.createQuery(hql)
				.setInteger(0, type)
				.setString(1,  hycardId)
				.list();
			
			
			return lytFanlis;
	}
	
	/**
	 * 动态条件查询加分页
	 * @param fanliState
	 * @param type
	 * @param hycardId
	 * @param first
	 * @param maxr
	 * @return
	 */
	public List<LytFanli> queryByC(Integer fanliState,Integer type,String hycardId,Integer first,Integer maxr) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx= session.beginTransaction();
//			String hql = "from LytFanli as l where l.fanliType = ? and l.lytHuiyuanByTjrId.hycardId =? ORDER BY fanliTime desc";
			Criteria criteria = session.createCriteria(LytFanli.class);
			
		

				if (hycardId.equals("all")) {
					
				}else {
					
					criteria.createCriteria("lytHuiyuanByTjrId").add(Restrictions.eq("hycardId", hycardId));
				}

			
			if (type != null) {
				criteria.add(Restrictions.eq("fanliType", type));
			}
			if(fanliState != null){
				criteria.add(Restrictions.eq("fanliState", fanliState));
			}
			criteria.setFirstResult(first);
			criteria.setMaxResults(maxr);
			List<LytFanli> lytFanlis = criteria.list();
			
			
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
	/**
	 * 分页的总记录数
	 * @param fanliState
	 * @param type
	 * @param hycardId
	 * @return
	 */
	public int queryByTotalRows(Integer fanliState,Integer type,String hycardId) {
		Session session = sessionFactory.getCurrentSession();
		try {
//			String hql = "from LytFanli as l where l.fanliType = ? and l.lytHuiyuanByTjrId.hycardId =? ORDER BY fanliTime desc";
			Criteria criteria = session.createCriteria(LytFanli.class);
			

			if (!"all".equals(hycardId)) {
				criteria.createCriteria("lytHuiyuanByTjrId").add(
						Restrictions.eq("hycardId", hycardId));
			}

			if (type != null) {
				criteria.add(Restrictions.eq("fanliType", type));
			}
			if(fanliState != null){
				criteria.add(Restrictions.eq("fanliState", fanliState));
			}
			int count = criteria.list().size();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 更新返利状态
	 * @param flid
	 * @return
	 */
	public boolean updateState(String flid) {
		try {
			
			LytFanli lytFanli = hibernateTemplate.get(LytFanli.class, flid);
			if (lytFanli.getFanliState()==0) {
				lytFanli.setFanliState(1);
			}else if (lytFanli.getFanliState()==1) {
				lytFanli.setFanliState(0);
			}
			hibernateTemplate.update(lytFanli);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

}
