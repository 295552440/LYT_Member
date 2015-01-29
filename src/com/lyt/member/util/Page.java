package com.lyt.member.util;

/**
 * 为了增加程序的分页功能，特意建立共用的分页类
 */
public class Page {
	private int totalRows; // 总行�?总记录数)
	private int pageSize = Constant.PAGE_SIZE; // 每页显示的行�?
	private int currentPage; // 当前页号
	private int totalPages; // 总页�?
	private int startRow; // 当前页在数据库中的起始行

	public Page() {
	}

	/**
	 * 构�?方法
	 * 
	 * @param totalRows
	 * @param currentPage
	 * @param startRow
	 */
	public Page(int totalRows, int currentPage, int startRow) {

		this.totalRows = totalRows;
		this.currentPage = currentPage;
		this.startRow = startRow;
		this.totalPages = totalRows / pageSize;
		int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPages++;
		}
	}

	// 显示第一�?
	public void first() {
		currentPage = 1;
		startRow = 0;
	}

	// 上一�?
	public void previous() {
		if (currentPage == 1) {
			return;
		}

		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}

	// 下一�?
	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}

	// �?���?��
	public void last() {
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}

	// 跳转到某�?��
	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		// 如果输入的数大于总页数，则跳转至�?���?��
		if (currentPage > totalPages) {
			last();
		}
		if (currentPage <=0) {
			first();
		}
		
		
	}

	/**
	 * 页面业务方法
	 * 
	 * @param currentPage当前�?
	 * @param pagerMethod对当前页的操�?
	 * @param totalRows数据库中总行�?
	 * @return返回页面
	 */
	public Page getPage(int currentPage, String pageMethod, int totalRows) {
		// 定义page对象，用于传到页�?
		Page page = null;

		// 没有pageMethod，则是首次查询，跳到第一�?
		if (pageMethod == null) {
			page = new Page(totalRows, 1, 0);
		}

		// 获取当前执行的方法，首页，前�?��，后�?��，尾页�?
		if (pageMethod != null) {
			startRow = (currentPage - 1) * pageSize;
			page = new Page(totalRows, currentPage, startRow);

			if (pageMethod.equals("first")) {
				page.first();
			} else if (pageMethod.equals("previous")) {
				page.previous();
			} else if (pageMethod.equals("next")) {
				page.next();
			} else if (pageMethod.equals("last")) {
				page.last();
			} else if (pageMethod.equals("refresh")) {
				page.refresh(currentPage);
			}else if (pageMethod.equals("delete")) {
				page.refresh(currentPage);
			}
		}
		return page;
	}

	// **********************************************************
	public int getStartRow() {
		return startRow;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

}
