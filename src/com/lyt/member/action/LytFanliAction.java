package com.lyt.member.action;

import java.util.List;

import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.service.LytFanliService;
import com.lyt.member.service.LytHuiyuanService;
import com.lyt.member.util.Pageliu;

public class LytFanliAction extends BaseAction {

	private LytFanliService lytFanliService;
	private LytHuiyuanService lytHuiyuanService;
	

	public void setLytHuiyuanService(LytHuiyuanService lytHuiyuanService) {
		this.lytHuiyuanService = lytHuiyuanService;
	}

	public LytFanliService getLytFanliService() {
		return lytFanliService;
	}

	public void setLytFanliService(LytFanliService lytFanliService) {
		this.lytFanliService = lytFanliService;
	}
	
//	Exception ex = (Exception) ActionContext.getContext() .getValueStack().findValue("exception"); 
	 
	private List<LytFanli> lytFanlis;
	private Integer fanliType;
	private String hycardId;
	private Integer fanliState;
	private LytHuiyuan lytHuiyuan = new LytHuiyuan();


	public LytHuiyuan getLytHuiyuan() {
		return lytHuiyuan;
	}

	public void setLytHuiyuan(LytHuiyuan lytHuiyuan) {
		this.lytHuiyuan = lytHuiyuan;
	}

	public Integer getFanliType() {
		return fanliType;
	}

	public void setFanliType(Integer fanliType) {
		this.fanliType = fanliType;
	}

	public Integer getFanliState() {
		return fanliState;
	}

	public void setFanliState(Integer fanliState) {
		this.fanliState = fanliState;
	}

	public List<LytFanli> getLytFanlis() {
		return lytFanlis;
	}

	public void setLytFanlis(List<LytFanli> lytFanlis) {
		this.lytFanlis = lytFanlis;
	}


	public String getHycardId() {
		return hycardId;
	}

	public void setHycardId(String hycardId) {
		this.hycardId = hycardId;
	}

	static private Integer currentPage=1;
	private Pageliu pageliu = new Pageliu();
	public Pageliu getPageliu() {
		return pageliu;
	}

	public void setPageliu(Pageliu pageliu) {
		this.pageliu = pageliu;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	/**
	 * 通过会员id,返利的类型，返利的状态，第一次查询
	 * @return
	 */
	public String queryByTypeHy() {
		
	
			session.put("fanliType", fanliType);
			session.put("hycardId", hycardId);
			session.put("fanliState", fanliState);
		lytHuiyuan = lytHuiyuanService.queryByCardId(hycardId);
		lytFanlis = lytFanliService.queryByTypeHy(fanliType, hycardId,fanliState,1);
		int count = lytFanliService.queryByTotalRows(fanliType, hycardId, fanliState);
		pageliu.setTotalRows(count);
		pageliu.setTotalPages(pageliu.getTotalPage(count));
		
		return SUCCESS;
		
	}
	/**
	 * 带查询条件加上分页
	 * @return
	 */
	public String queryByTypeHyPage() {
		if (session.get("hycardId")!=null) {
			hycardId =  (String) session.get("hycardId");
			fanliType =  (Integer) session.get("fanliType");
			fanliState =   (Integer) session.get("fanliState");
		}
			
		lytHuiyuan = lytHuiyuanService.queryByCardId(hycardId);
		lytFanlis = lytFanliService.queryByTypeHy(fanliType, hycardId,fanliState,currentPage);
		int count = lytFanliService.queryByTotalRows(fanliType, hycardId, fanliState);
		pageliu.setTotalRows(count);
		pageliu.setTotalPages(pageliu.getTotalPage(count));
		
		return SUCCESS;
		
	}
	
	private String flid;
	
	public String getFlid() {
		return flid;
	}

	public void setFlid(String flid) {
		this.flid = flid;
	}

	/**
	 * 带分页加条件去更新
	 * @return
	 */
	public String queryByTypeHyPageUp() {
		if (session.get("hycardId")!=null) {
			hycardId =  (String) session.get("hycardId");
			fanliType =  (Integer) session.get("fanliType");
			fanliState =   (Integer) session.get("fanliState");
		}
		
		lytHuiyuan = lytHuiyuanService.queryByCardId(hycardId);
		if (lytFanliService.updateState(flid)) {
			
			lytFanlis = lytFanliService.queryByTypeHy(fanliType, hycardId,fanliState,currentPage);
			int count = lytFanliService.queryByTotalRows(fanliType, hycardId, fanliState);
			pageliu.setTotalRows(count);
			pageliu.setTotalPages(pageliu.getTotalPage(count));
		}
		
		return SUCCESS;
		
	}
}
