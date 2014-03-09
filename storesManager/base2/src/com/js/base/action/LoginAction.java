package com.js.base.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.js.base.service.IRoleAuthService;
import com.js.base.vo.LoginBean;
import com.js.base.vo.RoleMenuBean;
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
	
	@Autowired
	@Qualifier("roleAuthService")
	private IRoleAuthService roleAuthService;

	@RequestMapping(value = "/userLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model,@ModelAttribute("form") LoginBean loginForm,HttpServletRequest req) throws Exception {
		if(null==loginForm||(null!=loginForm&&StringUtils.isBlank(loginForm.getUserNo()))){
			return "login";	
		}
		SysUserBean user=new SysUserBean();
		user.setUser_no(loginForm.getUserNo());
		user.setPass_word(loginForm.getPassWord());
		SysUserBean bean = loginService.getUser(user);
		if (bean == null) {
			logger.info("Login:用不不存在");
		} else {
			req.getSession().setAttribute(Const.SESSION_USER,bean);
			req.getSession().setAttribute(Const.SESSION_ROLE_RIGHTS, this.roleMenuJson(bean.getRole_no()));
			logger.info("Login:" + bean.getUser_no());
		}
		return "main";
	}
	
	public String roleMenuJson(String role_no) throws Exception{
		RoleMenuBean parm = new RoleMenuBean();
		parm.setRole_no(role_no);
		List<RoleMenuBean> list = roleAuthService.getRoleMenuList(parm);
		JSONArray json = new JSONArray();
		for (RoleMenuBean menu : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", menu.getMenu_no());
			jsonObject.put("pId", menu.getMenu_upno());
			jsonObject.put("name", menu.getMenu_name());
			jsonObject.put("file", menu.getMenu_url());
			json.add(jsonObject);
		}
		System.out.println(json.toString());
		return json.toString();
	}
}
