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


	private Page page;// 页面
	private String pageMethod;// 用于接收页面传来的“上一页、下一页”等参数
	private String queryMethod;// 用于接收查询方法
	private String order;// 按顺序查询
	private String state;// 按状态查询
	private String searchBy;// 按搜索查询
	private String searchInput;// 接收页面传来搜索参数
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

		// 第一次访问页面时page=null，防止空指针

		
		if (page == null) {
			page = new Page();

		}
		if (order == null) {
			order = (String) session.get("order");
		}

		// 设置每页显示的条数

		Constant.setPAGE_SIZE(Constant.PAGE_SIZE_MemberList);

		memberList = lytHuiyuanService.queryByOrder(page, pageMethod, order);


		// 将执行完后的page作为lytHuiyuanService的静态变量再传递给blogAction,及时更新页面page

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

		// 第一访问页面时page=null，防止空指针

		if (page == null) {
			page = new Page();

			System.out.println("kong");
		}
		if (state == null) {
			state = (String) session.get("state");
		}

		// 设置每页显示的条数

		Constant.setPAGE_SIZE(Constant.PAGE_SIZE_MemberList);

		memberList = lytHuiyuanService.queryByState(page, pageMethod, state);


		// 将执行完后的page作为blogService的静态变量再传递给blogAction,及时更新页面page

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

		// 第一访问页面时page=null，防止空指针

		if (page == null) {
			page = new Page();
		}
		if (searchBy == null) {
			searchBy = (String) session.get("searchBy");
		}
		if (searchInput == null) {
			searchInput = (String) session.get("searchInput");
		}

		// 设置每页显示的条数

		Constant.setPAGE_SIZE(Constant.PAGE_SIZE_MemberList);
		memberList = lytHuiyuanService.queryBySearch(page, pageMethod,
				searchBy, searchInput);


		// 将执行完后的page作为blogService的静态变量再传递给blogAction,及时更新页面page

		page = lytHuiyuanService.page;

		// 执行完first,previous,next,last,refresh之后，必须将pageMethod清空，以保证重新query时，从第一页查询


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

		pageMethod = "555";// 防止page被刷新为0
		// 判断条件，返回原来的页面

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
	
	public String adminAddLytHuiyuan() {
		lytHuiyuan.setHyState(1);
		message = lytHuiyuanService.addLytHuiyuan(lytHuiyuan);
		lytFanliService.addFanli(lytHuiyuan);
		if (message.equals("1")) {

			message = "系统不识别会员级别，请重试！";

			return INPUT;
		} else if (message.equals("2")) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String lytHuiyuanApply() {
		lytHuiyuan.setHyState(0);
		message = lytHuiyuanService.addLytHuiyuan(lytHuiyuan);
		lytFanliService.addFanli(lytHuiyuan);
		if (message.equals("1")) {
			
			message = "系统不识别会员级别，请重试！";

			return INPUT;
		} else if (message.equals("2")) {
			return ERROR;
		}
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
