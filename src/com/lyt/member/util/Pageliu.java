package com.lyt.member.util;




/**
 * 为了增加程序的分页功能，特意建立共用的分页类
 */
public class Pageliu {
	static public final int PAGE_SIZE = 10;// 每页显示记录数
	private Integer totalRows;
	private Integer totalPages;
	public Integer getTotalPages() {
		return totalPages;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalPage(int totalrows){
		if(totalrows%PAGE_SIZE==0){
			 totalPages=totalrows/PAGE_SIZE;
			 
		 }else if(totalrows%PAGE_SIZE!=0){
			 totalPages=(totalrows/PAGE_SIZE)+1;
		 }
		 return totalPages;
	 }
}
