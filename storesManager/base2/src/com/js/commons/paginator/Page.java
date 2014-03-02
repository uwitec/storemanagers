package com.js.commons.paginator;

public class Page {
	private int showCount = 10; // ÿҳ��ʾ��¼��
	private int totalPage; // ��ҳ��
	private int totalResult; // �ܼ�¼��
	private int currentPage; // ��ǰҳ
	private int currentResult; // ��ǰ��¼��ʼ����
	private boolean entityOrField; // true:��Ҫ��ҳ�ĵط�������Ĳ�������Pageʵ�壻false:��Ҫ��ҳ�ĵط�������Ĳ����������ʵ��ӵ��Page����
	private String pageStr; // ����ҳ����ʾ�ĵײ���ҳ��������ϸ����getPageStr();

	public int getTotalPage() {
		if (totalResult % showCount == 0)
			totalPage = totalResult / showCount;
		else
			totalPage = totalResult / showCount + 1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		if (currentPage > getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageStr() {
		StringBuffer sb = new StringBuffer();
		if (totalResult > 0) {
			sb.append(" <ul>\n");
			if (currentPage == 1) {
				sb.append(" <li class=\"pageinfo\">��ҳ</li>\n");
				sb.append(" <li class=\"pageinfo\">��ҳ</li>\n");
			} else {
				sb.append(" <li><a href=\"#@\" onclick=\"nextPage(1)\">��ҳ</a></li>\n");
				sb.append(" <li><a href=\"#@\" onclick=\"nextPage("
						+ (currentPage - 1) + ")\">��ҳ</a></li>\n");
			}
			int showTag = 3; // ��ҳ��ǩ��ʾ����
			int startTag = 1;
			if (currentPage > showTag) {
				startTag = currentPage - 1;
			}
			int endTag = startTag + showTag - 1;
			for (int i = startTag; i <= totalPage && i <= endTag; i++) {
				if (currentPage == i)
					sb.append("<li class=\"current\">" + i + "</li>\n");
				else
					sb.append(" <li><a href=\"#@\" onclick=\"nextPage(" + i
							+ ")\">" + i + "</a></li>\n");
			}
			if (currentPage == totalPage) {
				sb.append(" <li class=\"pageinfo\">��ҳ</li>\n");
				sb.append(" <li class=\"pageinfo\">βҳ</li>\n");
			} else {
				sb.append(" <li><a href=\"#@\" onclick=\"nextPage("
						+ (currentPage + 1) + ")\">��ҳ</a></li>\n");
				sb.append(" <li><a href=\"#@\" onclick=\"nextPage(" + totalPage
						+ ")\">βҳ</a></li>\n");
			}
			sb.append(" <li class=\"pageinfo\">��" + currentPage + "ҳ</li>\n");
			sb.append(" <li class=\"pageinfo\">��" + totalPage + "ҳ</li>\n");
			sb.append("</ul>\n");
			sb.append("<script type=\"text/javascript\">\n");
			sb.append("function nextPage(page){");
			sb.append(" if(true && document.forms[0]){\n");
			sb.append("     var url = document.forms[0].getAttribute(\"action\");\n");
			sb.append("     if(url.indexOf('?')>-1){url += \"&"
					+ (entityOrField ? "currentPage" : "page.currentPage")
					+ "=\";}\n");
			sb.append("     else{url += \"?"
					+ (entityOrField ? "currentPage" : "page.currentPage")
					+ "=\";}\n");
			sb.append("     document.forms[0].action = url+page;\n");
			sb.append("     document.forms[0].submit();\n");
			sb.append(" }else{\n");
			sb.append("     var url = document.location+';\n");
			sb.append("     if(url.indexOf('?')>-1){\n");
			sb.append("         if(url.indexOf('currentPage')>-1){\n");
			sb.append("             var reg = /currentPage=\\d*/g;\n");
			sb.append("             url = url.replace(reg,'currentPage=');\n");
			sb.append("         }else{\n");
			sb.append("             url += \"&"
					+ (entityOrField ? "currentPage" : "page.currentPage")
					+ "=\";\n");
			sb.append("         }\n");
			sb.append("     }else{url += \"?"
					+ (entityOrField ? "currentPage" : "page.currentPage")
					+ "=\";}\n");
			sb.append("     document.location = url + page;\n");
			sb.append(" }\n");
			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStr = sb.toString();
		return pageStr;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getShowCount();
		if (currentResult < 0)
			currentResult = 0;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public boolean isEntityOrField() {
		return entityOrField;
	}

	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}
}