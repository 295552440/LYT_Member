package com.lyt.member.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.lyt.member.entity.LytFanli;
import com.lyt.member.entity.LytHuiyuan;
import com.lyt.member.service.LytFanliService;
import com.lyt.member.service.LytHuiyuanService;
import com.lyt.member.util.Constant;
import com.lyt.member.util.Page;

public class LytHuiyuanAction extends BaseAction {

	private LytHuiyuanService lytHuiyuanService;
	private List<LytHuiyuan> memberList;


	private Page page;// ҳ��
	private String pageMethod;// ���ڽ���ҳ�洫���ġ���һҳ����һҳ���Ȳ���
	private String queryMethod;// ���ڽ��ղ�ѯ����
	private String order;// ��˳���ѯ
	private String state;// ��״̬��ѯ
	private String searchBy;// ��������ѯ
	private String searchInput;// ����ҳ�洫����������
	private Integer currentPage;

	
	private String message;
	private LytHuiyuan lytHuiyuan;
	private LytFanliService lytFanliService;
	
	
	
	
	
	
	
	
	
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LytHuiyuan getLytHuiyuan() {
		return lytHuiyuan;
	}

	public void setLytHuiyuan(LytHuiyuan lytHuiyuan) {
		this.lytHuiyuan = lytHuiyuan;
	}

	public LytFanliService getLytFanliService() {
		return lytFanliService;
	}

	public void setLytFanliService(LytFanliService lytFanliService) {
		this.lytFanliService = lytFanliService;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getPageMethod() {
		return pageMethod;
	}

	public void setPageMethod(String pageMethod) {
		this.pageMethod = pageMethod;
	}

	public String getQueryMethod() {
		return queryMethod;
	}

	public void setQueryMethod(String queryMethod) {
		this.queryMethod = queryMethod;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

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

	/**
	 * queryAll
	 * 
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * queryByOrder
	 */

	public String queryByOrder() throws Exception {

		page = (Page) session.get("page");
		if (currentPage != null) {
			page.setCurrentPage(currentPage);
		}
		// ��һ�η���ҳ��ʱpage=null����ֹ��ָ��
		if (page == null) {
			page = new Page();

		}
		if (order == null) {
			order = (String) session.get("order");
		}
		// ����ÿҳ��ʾ������
		Constant.setPAGE_SIZE(Constant.PAGE_SIZE_MemberList);

		memberList = lytHuiyuanService.queryByOrder(page, pageMethod, order);

		// ��ִ������page��ΪlytHuiyuanService�ľ�̬�����ٴ��ݸ�blogAction,��ʱ����ҳ��page
		page = lytHuiyuanService.page;
		queryMethod = "queryByOrder";
		session.put("page", page);
		session.put("order", order);
		session.remove("searchInput");
		session.remove("searchBy");
		session.remove("state");
		return SUCCESS;

	}

	/**
	 * queryByState
	 */
	public String queryByState() throws Exception {
		page = (Page) session.get("page");
		if (currentPage != null) {
			page.setCurrentPage(currentPage);
		}
		// ��һ����ҳ��ʱpage=null����ֹ��ָ��
		if (page == null) {
			page = new Page();

			System.out.println("kong");
		}
		if (state == null) {
			state = (String) session.get("state");
		}
		// ����ÿҳ��ʾ������
		Constant.setPAGE_SIZE(Constant.PAGE_SIZE_MemberList);

		memberList = lytHuiyuanService.queryByState(page, pageMethod, state);

		// ��ִ������page��ΪblogService�ľ�̬�����ٴ��ݸ�blogAction,��ʱ����ҳ��page
		page = lytHuiyuanService.page;
		queryMethod = "queryByState";
		session.put("page", page);
		session.put("state", state);
		session.remove("order");
		session.remove("searchInput");
		session.remove("searchBy");
		return SUCCESS;

	}

	/**
	 * queryBySearch
	 */
	public String queryBySearch() throws Exception {
		page = (Page) session.get("page");
		if (currentPage != null) {
			page.setCurrentPage(currentPage);
		}
		// ��һ����ҳ��ʱpage=null����ֹ��ָ��
		if (page == null) {
			page = new Page();
		}
		if (searchBy == null) {
			searchBy = (String) session.get("searchBy");
		}
		if (searchInput == null) {
			searchInput = (String) session.get("searchInput");
		}
		// ����ÿҳ��ʾ������
		Constant.setPAGE_SIZE(Constant.PAGE_SIZE_MemberList);
		memberList = lytHuiyuanService.queryBySearch(page, pageMethod,
				searchBy, searchInput);

		// ��ִ������page��ΪblogService�ľ�̬�����ٴ��ݸ�blogAction,��ʱ����ҳ��page
		page = lytHuiyuanService.page;
		// ִ����first,previous,next,last,refresh֮�󣬱��뽫pageMethod��գ��Ա�֤����queryʱ���ӵ�һҳ��ѯ

		queryMethod = "queryBySearch";
		session.put("page", page);
		session.put("searchBy", searchBy);
		session.put("searchInput", searchInput);
		session.remove("state");
		session.remove("order");
		return SUCCESS;

	}

	/**
	 * updateState
	 * 
	 * @return
	 */
	public String updateState() throws Exception {

		lytHuiyuanService.updateState(lytHuiyuan);
		pageMethod = "555";// ��ֹpage��ˢ��Ϊ0
		// �ж�����������ԭ����ҳ��
		if (session.get("order") != null) {
			return queryByOrder();
		}
		if (session.get("state") != null) {
			return queryByState();
		}
		if (session.get("searchBy") != null) {
			return queryBySearch();
		}

		return SUCCESS;

	}

	
	public String addLytHuiyuan() {
		message = lytHuiyuanService.addLytHuiyuan(lytHuiyuan);
		lytFanliService.addFanli(lytHuiyuan);
		if (message.equals("1")) {
			message = "ϵͳ��ʶ���Ա���������ԣ�";
			return INPUT;
		} else if (message.equals("2")) {
			return ERROR;
		}
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
