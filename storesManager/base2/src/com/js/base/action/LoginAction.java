package com.js.base.action;

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

@Controller
@RequestMapping("")
public class LoginAction {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	@RequestMapping(value = "/userLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model,@ModelAttribute("form") LoginBean loginForm) throws Exception {
		SysUserBean bean = loginService.getUser("000000");
		if (bean == null) {
			logger.info("Login:用不不存在");
		} else {
			logger.info("Login:" + bean.getUser_no());
		}
		return "main";
	}
}
