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
import org.springframework.web.bind.annotation.ResponseBody;

import com.js.base.service.IUsersService;
import com.js.base.vo.LoginBean;
import com.js.base.vo.SysUserBean;
import com.js.commons.paginator.Page;

@Controller
@RequestMapping("")
public class UsersAction {
	private static Logger logger = Logger.getLogger(UsersAction.class);
	@Autowired
	@Qualifier("usersService")
	private IUsersService usersService;

	@RequestMapping(value = "/userList", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	JSONObject userQueryList(Model model, HttpServletRequest req)
			throws Exception {
		SysUserBean parm = new SysUserBean();
		parm.setUser_name(req.getParameter("user_name"));
		parm.setDep_no(req.getParameter("dep_no"));
		Page page = new Page();
		System.out.println(req.getParameter("randnum"));
		System.out.println(req.getParameter("page"));
		System.out.println(req.getParameter("rows"));
		page.setCurrentPage(StringUtils.isBlank(req.getParameter("page")) ? 1
				: Integer.parseInt(req.getParameter("page")));
		page.setShowCount(StringUtils.isBlank(req.getParameter("rows")) ? 1
				: Integer.parseInt(req.getParameter("rows")));
		parm.setPage(page);
		List<SysUserBean> list = usersService.getUser(parm);

		JSONArray json = new JSONArray();
		for (SysUserBean user : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("user_no", user.getUser_no());
			jsonObject.put("user_name", user.getUser_name());
			jsonObject.put("dep_no", user.getDep_no());
			jsonObject.put("role_no", user.getRole_no());
			jsonObject.put("user_sts", user.getUser_sts());
			json.add(jsonObject);
		}

		JSONObject datas = new JSONObject();
		datas.put("rows", json);
		datas.put("total", 11);
		return JSONObject.fromObject(datas);
	}

	@RequestMapping(value = "/userDetail", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String userDetails(Model model, HttpServletRequest req)
			throws Exception {
		String user_no = req.getParameter("user_no");
		SysUserBean detail = usersService.getUserDetails(user_no);

		model.addAttribute("command", detail);
		return "base/userDetail";
	}

	@RequestMapping(value = "/userUpdate", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String userUpdate(Model model,
			@ModelAttribute("form") SysUserBean user) {
		try {
			usersService.updateUsers(user);
//			model.addAttribute("error", "更新成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("error", "更新失败！");
		}
//		model.addAttribute("command", user);
		return "base/userList";
	}

}
