package com.mybatis.common.vo;

public class PageInfo {
	private int totalRecord;	// 현재 총 게시글의 갯수 (26) 
	private int nowPage;		// 현재 페이지(즉, 사용자가 요청한 페이지)
	private int numPerPage;		// 현재 페이지에 보여줄 게시글의 최대갯수  (5)
	private int pagePerBlock;	// 페이지 하단에 보여질 페이징바의 페이지 최대갯수 (5)
	 
	private int totalPage;		// 가장 마지막 페이지(총 페이지 수) => 6
	private int startPage;		// 하단에 페이징바의 시작 페이지
	private int endPage;		// 하단에 페이징바의 끝 페이지
	
	public PageInfo() {
	}
	
	public PageInfo(int totalRecord, int nowPage, int numPerPage, int pagePerBlock, int totalPage, int startPage,
			int endPage) {
		this.totalRecord = totalRecord;
		this.nowPage = nowPage;
		this.numPerPage = numPerPage;
		this.pagePerBlock = pagePerBlock;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PageInfo [totalRecord=" + totalRecord + ", nowPage=" + nowPage + ", numPerPage=" + numPerPage
				+ ", pagePerBlock=" + pagePerBlock + ", totalPage=" + totalPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + "]";
	}
}
