package com.js.commons.paginator;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.js.commons.JStr;

public class Paginator implements Serializable {
	private static final long serialVersionUID = 192837094237987492L;
	// 每页条数
	private int pageSize;
	// 总页数
	private int pageTotal;
	// 当前第几页
	private int pageNum;
	// 总记录数
	private int cntTotal;
	// 是否重新计算页数
	private boolean rePage;

	private Paginator() {
		pageSize = 10;
		pageTotal = 0;
		pageNum = 1;
		cntTotal = 0;
		rePage = true;
	}

	public static Paginator create(HttpServletRequest request) {
		if (request == null) {
			return new Paginator();
		}
		Paginator p = new Paginator();
		String _pageNum = request.getParameter("pageNum");
		String _pageSize = request.getParameter("pageSize");
		if (!JStr.isEmpty(_pageNum)) {
			int num = Integer.parseInt(_pageNum);
			p.setPageNum(num);
		}
		if (!JStr.isEmpty(_pageSize)) {
			int size = Integer.parseInt(_pageSize);
			p.setPageSize(size);
		}
		return p;
	}

	private void initPage() {
		if (cntTotal > 0) {
			if (cntTotal % pageSize == 0) {
				pageTotal = cntTotal / pageSize;
			} else {
				pageTotal = cntTotal / pageSize + 1;
			}
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCntTotal() {
		return cntTotal;
	}

	public void setCntTotal(int cntTotal) {
		this.cntTotal = cntTotal;
		if (this.rePage) {
			initPage();
		}
	}

	public boolean isRePage() {
		return rePage;
	}

	public void setRePage(boolean rePage) {
		this.rePage = rePage;
	}
}
