package com.lyt.member.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.service.LytHuiyuanService;

public class LytHuiyuanAction extends BaseAction {

	private LytHuiyuanService lytHuiyuanService;
	private List<LytHuiyuan> memberList;

	public LytHuiyuanService getLytHuiyuanService() {
		return lytHuiyuanService;
	}

	public void setLytHuiyuanService(LytHuiyuanService lytHuiyuanService) {
		this.lytHuiyuanService = lytHuiyuanService;
	}

	public List<LytHuiyuan> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<LytHuiyuan> memberList) {
		this.memberList = memberList;
	}

	public String showMemberList() throws Exception {

		memberList = lytHuiyuanService.queryAllLytHuiyuan();
		return SUCCESS;

	}
	
	//用户查询
	
	private String cardId;
	private String name;
	private String huiyuanid;
	private LytHuiyuan LytHuiyuan;
	private Set<LytFanli> setLytFanlis = new HashSet<LytFanli>();
	

	public Set<LytFanli> getSetLytFanlis() {
		return setLytFanlis;
	}

	public void setSetLytFanlis(Set<LytFanli> setLytFanlis) {
		this.setLytFanlis = setLytFanlis;
	}

	public LytHuiyuan getLytHuiyuan() {
		return LytHuiyuan;
	}

	public void setLytHuiyuan(LytHuiyuan lytHuiyuan) {
		LytHuiyuan = lytHuiyuan;
	}

	public String getHuiyuanid() {
		return huiyuanid;
	}

	public void setHuiyuanid(String huiyuanid) {
		this.huiyuanid = huiyuanid;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 通过名字查询会员
	 * @return
	 */
	public String queryByName() {
		
		LytHuiyuan = lytHuiyuanService.queryByName(name);
		return SUCCESS;
		
	}
	/**
	 * 通过id查询会员
	 * @return
	 */
	public String queryById() {
		System.out.println("id:"+huiyuanid);
		LytHuiyuan = lytHuiyuanService.queryById(huiyuanid);
		Set<LytFanli> setLytFanlis = new HashSet<LytFanli>();
		setLytFanlis= LytHuiyuan.getLytFanlisForTjrId();
		for(LytFanli lytFanli :setLytFanlis){
		System.out.println(lytFanli.getId());
		}
		return SUCCESS;
		
	}
	/**
	 * 通过卡号查询会员
	 * @return
	 */
	public String queryByCardId() {
		
//		lytHuiyuanService.queryBy(cardId);
		return SUCCESS;
		
	}

}
