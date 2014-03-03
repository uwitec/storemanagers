package com.js.commons.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
 * 
 * ���������� ʵ����session �� user����
 * @�޸���־��
 *
 */

public class LoginSessionListener implements HttpSessionListener {
	// ���� sessionId��userName ��ӳ��(sessionid,userName)
	public static Map<String, String> hUserName = new ConcurrentHashMap<String, String>();
	// ���϶���,����session ���������(sessionid,session)
	public static Map<String, HttpSession> htsession = new ConcurrentHashMap<String, HttpSession>();
	// �����û�����Ա������session id �Ĺ���
	public static Map<String, Integer> mpOper = new ConcurrentHashMap<String, Integer>();

	/**
	 * 
	 * ����������������ʵ��HttpSessionListener�еķ��� 
	 * @author fww
	 * @date Sep 1, 2008
	 * @�޸���־��
	 */
	public void sessionCreated(HttpSessionEvent se) {

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		//��ǰ����Ա������״̬������session��
		hUserName.remove(se.getSession().getId());
		htsession.remove(se.getSession().getId());
		se.getSession().invalidate();

//		String sessID = se.getSession().getId();     
//		mpOper.remove(sessID);                       
	}
	public static void putSessionMap(HttpSession session, String nUserName){
		hUserName.put(session.getId(), nUserName);
		htsession.put(session.getId(), session);
	}
	
	
	
	
    /**
     * ��������������һ���Ѿ���¼���û������ߵ��õķ���
     * @param session
     * @param nUserName
     * @author shaoxinlong
     * @date Jan 17th 2011
     * @return  boolean ���û��Ƿ��Ѿ���¼�ı�־
     */
	public static boolean kickFirstOper(HttpSession session, String nUserName){
		boolean flag=false;
		if (hUserName.containsValue(nUserName)) {
			flag = true;
			Iterator iter = hUserName.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (((String) val).equals(nUserName)) {
					iter.remove();
					HttpSession ses = (HttpSession) htsession.get(key);
					//if (session.getId().equals(((HttpSession) htsession.get(key)).getId())) {//��ͬһ̨���ӵ�¼
						 htsession.remove(key); //ֱ�ӾͰ�MAP�ĵ�ǰ��¼������
					     hUserName.remove(key);
					     ses.invalidate();
					     //hUserName.put(session.getId(), nUserName);
					     //htsession.put(session.getId(), session);
//					}
//					else{   //����ͬһ̨���ӵ�¼ �Ȱ�ǰ����û�T�� Ȼ������û��ļ�¼�Ž�MAP
//					htsession.remove(key);
//					hUserName.remove(key);
//					ses.invalidate(); //��ǰ����Ǹ�����Աsession����
//					hUserName.put(session.getId(), nUserName);
//					htsession.put(session.getId(), session);
//					
//					}
					break;
				}
			}
			
		}
		return flag;
	}
	
	
	
	
	/**
	 * 
	 * ����������-�����ж��û��Ƿ��Ѿ���¼�Լ���Ӧ�Ĵ�����
	 * 
	 * @param sUserName��¼���û�����
	 * @param session
	 * @author fww
	 * 
	 * @date Sep 1, 2008
	 * @return boolean-���û��Ƿ��Ѿ���¼���ı�־
	 * @�޸���־��
	 */
	
	@SuppressWarnings("unchecked")
	public static boolean isAlreadyEnter(HttpSession session, String sUserName) {
		boolean flag = false;
		if (hUserName.containsValue(sUserName)) {
			flag = true;
			Iterator iter = hUserName.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (((String) val).equals(sUserName)) {
					iter.remove();
					HttpSession ses = (HttpSession) htsession.get(key);
					htsession.remove(key);
					ses.invalidate();
					break;
				}
			}
			hUserName.put(session.getId(), sUserName);
			htsession.put(session.getId(), session);
		} else {
			// ������û�û��¼����ֱ��������ڵ�sessionID��username
			flag = false;
			hUserName.put(session.getId(), sUserName);
			htsession.put(session.getId(), session);
		}
		return flag;
	}

	/**
	 * 
	 * ����������-�����ж��û��Ƿ�����
	 * 
	 * @param sUserName��¼���û�����
	 * @param session
	 * @author fww
	 * @date Sep 1, 2008
	 * @return boolean-���û��Ƿ����ߵı�־
	 * @�޸���־��
	 */
	public static boolean isOnline(String sUserName) {
		boolean flag = false;
		if (hUserName.containsValue(sUserName)) {
			flag = true;
		} else {
			flag = false;
			//hUserName.put(session.getId(), sUserName);
			//htsession.put(session.getId(), session);
		}
		return flag;
	}

	/**
	 * 
	 * ����������
	 * 
	 * @param session
	 * @param sUserName��¼���û�����
	 * @return boolean-���û��Ƿ����ߵı�־
	 * @author fww
	 * @date Sep 16, 2008
	 * @�޸���־��
	 */

	public static boolean isAddSessionToMap(HttpSession session,
			String sUserName) {
		boolean flag = false;
		if (hUserName.containsValue(sUserName)) {
			flag = true;
		} else {
			flag = false;
			hUserName.put(session.getId(), sUserName);
			htsession.put(session.getId(), session);
		}
		return flag;
	}

	/**
	 * 
	 * ���������� �����ж��û��Ƿ�����
	 * 
	 * @param session
	 * @param sUserName
	 *            ��¼���û�����
	 * @return boolean-���û��Ƿ����ߵı�־
	 * @author fww
	 * @date Sep 16, 2008
	 * @�޸���־��
	 */

	@SuppressWarnings("unchecked")
	public static boolean doRemove(HttpSession session, String sUserName) {
		boolean flag = false;
		if (hUserName.containsValue(sUserName)) {
			flag = true;
			Iterator iter = hUserName.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (((String) val).equals(sUserName)) {
					HttpSession ses = (HttpSession) htsession.get(key);
					hUserName.remove(key);
					htsession.remove(key);
					
					
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * ���������������ж��û��Ƿ�����
	 * 
	 * @param sessionid
	 * @return boolean-���û��Ƿ����ߵı�־
	 * @author fww
	 * @date Sep 16, 2008
	 * @�޸���־��
	 */

	public static HttpSession getSessionBySessionId(String sessionid) {
		HttpSession session = (HttpSession) htsession.get(sessionid);
		return session;
	}
}
