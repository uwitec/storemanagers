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
 * 功能描述： 实现现session 与 user关联
 * @修改日志：
 *
 */

public class LoginSessionListener implements HttpSessionListener {
	// 保存 sessionId和userName 的映射(sessionid,userName)
	public static Map<String, String> hUserName = new ConcurrentHashMap<String, String>();
	// 集合对象,保存session 对象的引用(sessionid,session)
	public static Map<String, HttpSession> htsession = new ConcurrentHashMap<String, HttpSession>();
	// 保存用户操作员代码与session id 的关联
	public static Map<String, Integer> mpOper = new ConcurrentHashMap<String, Integer>();

	/**
	 * 
	 * 功能描述：以下是实现HttpSessionListener中的方法 
	 * @author fww
	 * @date Sep 1, 2008
	 * @修改日志：
	 */
	public void sessionCreated(HttpSessionEvent se) {

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		//当前操作员的在线状态，销毁session。
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
     * 功能描述：将第一个已经登录的用户踢下线调用的方法
     * @param session
     * @param nUserName
     * @author shaoxinlong
     * @date Jan 17th 2011
     * @return  boolean 该用户是否已经登录的标志
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
					//if (session.getId().equals(((HttpSession) htsession.get(key)).getId())) {//是同一台机子登录
						 htsession.remove(key); //直接就把MAP的当前记录给清了
					     hUserName.remove(key);
					     ses.invalidate();
					     //hUserName.put(session.getId(), nUserName);
					     //htsession.put(session.getId(), session);
//					}
//					else{   //不是同一台机子登录 先把前面的用户T了 然后把新用户的记录放进MAP
//					htsession.remove(key);
//					hUserName.remove(key);
//					ses.invalidate(); //把前面的那个操作员session销毁
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
	 * 功能描述：-用于判断用户是否已经登录以及相应的处理方法
	 * 
	 * @param sUserName登录的用户名称
	 * @param session
	 * @author fww
	 * 
	 * @date Sep 1, 2008
	 * @return boolean-该用户是否已经登录过的标志
	 * @修改日志：
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
			// 如果该用户没登录过，直接添加现在的sessionID和username
			flag = false;
			hUserName.put(session.getId(), sUserName);
			htsession.put(session.getId(), session);
		}
		return flag;
	}

	/**
	 * 
	 * 功能描述：-用于判断用户是否在线
	 * 
	 * @param sUserName登录的用户名称
	 * @param session
	 * @author fww
	 * @date Sep 1, 2008
	 * @return boolean-该用户是否在线的标志
	 * @修改日志：
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
	 * 功能描述：
	 * 
	 * @param session
	 * @param sUserName登录的用户名称
	 * @return boolean-该用户是否在线的标志
	 * @author fww
	 * @date Sep 16, 2008
	 * @修改日志：
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
	 * 功能描述： 用于判断用户是否在线
	 * 
	 * @param session
	 * @param sUserName
	 *            登录的用户名称
	 * @return boolean-该用户是否在线的标志
	 * @author fww
	 * @date Sep 16, 2008
	 * @修改日志：
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
	 * 功能描述：用于判断用户是否在线
	 * 
	 * @param sessionid
	 * @return boolean-该用户是否在线的标志
	 * @author fww
	 * @date Sep 16, 2008
	 * @修改日志：
	 */

	public static HttpSession getSessionBySessionId(String sessionid) {
		HttpSession session = (HttpSession) htsession.get(sessionid);
		return session;
	}
}
