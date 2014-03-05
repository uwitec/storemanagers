package com.js.base.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.js.base.service.ILoginService;
import com.js.base.vo.LoginBean;
import com.js.base.vo.SysUserBean;
import com.js.commons.interceptor.LoginSessionListener;
import com.js.commons.util.Const;

@Controller
@RequestMapping("")
public class LoginAction {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	@RequestMapping(value = "/userLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model,@ModelAttribute("form") LoginBean loginForm,HttpServletRequest req) throws Exception {
		if(null==loginForm||(null!=loginForm&&StringUtils.isBlank(loginForm.getUserName()))){
			return "login";	
		}
		SysUserBean bean = loginService.getUser("000000");
		req.getSession().setAttribute(Const.SESSION_USER,bean);
		if (bean == null) {
			logger.info("Login:�ò�������");
		} else {
			logger.info("Login:" + bean.getUser_no());
		}
		return "main";
	}
}
