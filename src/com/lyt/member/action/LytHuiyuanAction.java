package com.lyt.member.action;

import java.util.List;


 
import com.lyt.member.entity.LytHuiyuan;
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
 * @return
 * @throws Exception
 */
	public String showMemberList() throws Exception {

		memberList = lytHuiyuanService.queryAllLytHuiyuan();
		return SUCCESS;

	}
	/**
	 * queryByOrder
	 */
	
	public String queryByOrder() throws Exception {
		// ��һ����ҳ��ʱpage=null����ֹ��ָ��
		
		
		page=(Page)session.get("page");
		
		if (page == null) {
			page = new Page();
			System.out.println("kong");
		}
		
		// ����ÿҳ��ʾ������
		Constant.setPAGE_SIZE(Constant.PAGE_SIZE_MemberList);
		
		
		System.out.println(page.getCurrentPage());
		System.out.println(page.getStartRow());
	
		memberList = lytHuiyuanService.queryByOrder(page, pageMethod, order);

		// ��ִ������page��ΪlytHuiyuanService�ľ�̬�����ٴ��ݸ�blogAction,��ʱ����ҳ��page
		page = lytHuiyuanService.page;
		// ִ����first,previous,next,last,refresh֮�󣬱��뽫pageMethod��գ��Ա�֤����queryʱ���ӵ�һҳ��ѯ
		/*pageMethod = null;

		state = null;
		searchBy = null;
		searchInput = null;*/
		queryMethod = "queryByOrder";
		session.put("page", page);
		return SUCCESS;

	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
