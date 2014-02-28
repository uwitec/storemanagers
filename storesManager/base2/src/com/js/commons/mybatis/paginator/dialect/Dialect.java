package com.js.commons.mybatis.paginator.dialect;

import java.util.List;

import org.springframework.core.annotation.Order;

public class Dialect {
	public boolean supportsLimit() {
		return false;
	}

	public boolean supportsLimitOffset() {
		return supportsLimit();
	}

	/**
	 * ��sql��ɷ�ҳsql���,ֱ��ʹ��offset,limit��ֵ��Ϊռλ��.</br> Դ����Ϊ:
	 * getLimitString(sql,offset,String.valueOf(offset),limit,String.valueOf(limit))
	 */
	public String getLimitString(String sql, int offset, int limit) {
		return getLimitString(sql, offset, Integer.toString(offset), limit, Integer.toString(limit));
	}

	/**
	 * ��sql��ɷ�ҳsql���,�ṩ��offset��limitʹ��ռλ��(placeholder)�滻.
	 * 
	 * <pre>
	 * ��mysql
	 * dialect.getLimitString(&quot;select * from user&quot;, 12, &quot;:offset&quot;,0,&quot;:limit&quot;) ������
	 * select * from user limit :offset,:limit
	 * </pre>
	 * 
	 * @return ����ռλ���ķ�ҳsql
	 */
	public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
		throw new UnsupportedOperationException("paged queries not supported");
	}

	/**
	 * ��sqlת��Ϊ�ܼ�¼��SQL
	 * 
	 * @param sql
	 *            SQL���
	 * @return �ܼ�¼����sql
	 */
	public String getCountString(String sql) {
		return "select count(1) from (" + sql + ") tmp_count";
	}

	/**
	 * ��sqlת��Ϊ�������SQL
	 * 
	 * @param sql
	 *            SQL���
	 * @return �ܼ�¼����sql
	 */
	public String getSortString(String sql, List<Order> orders) {
		if (orders == null || orders.isEmpty()) {
			return sql;
		}

		StringBuffer buffer = new StringBuffer("select * from (").append(sql).append(") temp_order order by ");
		for (Order order : orders) {
			if (order != null) {
				buffer.append(order.toString()).append(", ");
			}

		}
		buffer.delete(buffer.length() - 2, buffer.length());
		return buffer.toString();
	}
}
