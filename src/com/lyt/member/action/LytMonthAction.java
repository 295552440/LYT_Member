package com.lyt.member.action;

import java.util.List;

import com.lyt.member.entity.LytMonth;
import com.lyt.member.service.LytMonthService;
import com.lyt.member.util.Constant;
import com.lyt.member.util.Page;

public class LytMonthAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LytMonthService lytMonthService;
	private List<LytMonth> list;
	private LytMonth lytMonth;
	private Page page;// 页面
	private String pageMethod;// 用于接收页面传来的“上一页、下一页”等参数
	private String queryMethod;// 用于接收查询方法
	private String order;// 按顺序查询
	private String state;// 按状态查询
	private String searchBy;// 按搜索查询
	private String searchInput;// 接收页面传来搜索参数
	private Integer currentPage;

	
	
	public LytMonth getLytMonth() {
		return lytMonth;
	}

	public void setLytMonth(LytMonth lytMonth) {
		this.lytMonth = lytMonth;
	}

	public List<LytMonth> getList() {
		return list;
	}

	public void setList(List<LytMonth> list) {
		this.list = list;
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

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public LytMonthService getLytMonthService() {
		return lytMonthService;
	}

	public void setLytMonthService(LytMonthService lytMonthService) {
		this.lytMonthService = lytMonthService;
	}

	// queryMonthByOrder

	public String queryMonthByOrder() throws Exception {

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

		list = lytMonthService.queryByOrder(page, pageMethod, order);
        list=lytMonthService.addNameToList(list);
		// 将执行完后的page作为lytHuiyuanService的静态变量再传递给blogAction,及时更新页面page

		page = lytMonthService.page;
		queryMethod = "queryMonthByOrder";
		session.put("page", page);
		session.put("order", order);
		session.remove("searchInput");
		session.remove("searchBy");
		session.remove("state");
		return SUCCESS;

	}

	/**
	 * queryMonthByState
	 */
	public String queryMonthByState() throws Exception {
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

		list = lytMonthService.queryByState(page, pageMethod, state);
		 list=lytMonthService.addNameToList(list);
		// 将执行完后的page作为blogService的静态变量再传递给blogAction,及时更新页面page

		page = lytMonthService.page;
		queryMethod = "queryMonthByState";
		session.put("page", page);
		session.put("state", state);
		session.remove("order");
		session.remove("searchInput");
		session.remove("searchBy");
		return SUCCESS;

	}

	/**
	 * queryMonthBySearch
	 */
	public String queryMonthBySearch() throws Exception {

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

	
		list = lytMonthService.queryBySearch(page, pageMethod, searchBy,
				searchInput);
		 list=lytMonthService.addNameToList(list);
		// 将执行完后的page作为blogService的静态变量再传递给blogAction,及时更新页面page

		page = lytMonthService.page;

		// 执行完first,previous,next,last,refresh之后，必须将pageMethod清空，以保证重新query时，从第一页查询

		queryMethod = "queryMonthBySearch";
		session.put("page", page);
		session.put("searchBy", searchBy);
		session.put("searchInput", searchInput);
		session.remove("state");
		session.remove("order");
		return SUCCESS;

	}
//updateMonthState
	
	/**
	 * updateMonthState
	 * 
	 * @return
	 */
	public String updateMonthState() throws Exception {

		lytMonthService.updateState(lytMonth);
		

		pageMethod = "555";// 防止page被刷新为0
		// 判断条件，返回原来的页面

		if (session.get("order") != null) {
			return queryMonthByOrder();
		}
		if (session.get("state") != null) {
			return queryMonthByState();
		}
		if (session.get("searchBy") != null) {
			return queryMonthBySearch();
		}

		return SUCCESS;

	}
	
	
	
}
