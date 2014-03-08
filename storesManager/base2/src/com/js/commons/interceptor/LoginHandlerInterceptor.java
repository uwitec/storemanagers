package com.js.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.js.base.vo.SysUserBean;
import com.js.commons.exception.AuthorizationException;
import com.js.commons.util.Const;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.matches(Const.NO_INTERCEPTOR_PATH)){
			return true;
		}else{
			HttpSession session = request.getSession();
			SysUserBean user = (SysUserBean)session.getAttribute(Const.SESSION_USER);
			if(user!=null){
				return true;
			}else{
				 throw new AuthorizationException("由于您长时间未操作，请重新登录！");
			}
		}
	}
	
}
