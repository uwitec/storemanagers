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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.js.base.service.IRoleAuthService;
import com.js.base.vo.RoleMenuBean;

@Controller
@RequestMapping("")
public class RoleAuthSettingAction {
	private static Logger logger = Logger.getLogger(UsersAction.class);
	@Autowired
	@Qualifier("roleAuthService")
	private IRoleAuthService roleAuthService;

	@RequestMapping(value = "/roleAuthList", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	String roleAuthQueryList(Model model, HttpServletRequest req) throws Exception {
		RoleMenuBean parm = new RoleMenuBean();
		parm.setRole_no("1");
		List<RoleMenuBean> list = roleAuthService.getRoleMenuList(parm);
		JSONArray json = new JSONArray();
		for (RoleMenuBean menu : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", menu.getMenu_no());
			jsonObject.put("parentId", menu.getMenu_upno());
			jsonObject.put("name", menu.getMenu_name());
			if(StringUtils.isBlank(menu.getIsChecked())){
				jsonObject.put("checked", "");
			}else{
				jsonObject.put("checked", "true");
			}
			json.add(jsonObject);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	@RequestMapping(value = "/roleAuthUpdate", method = { RequestMethod.GET,
			RequestMethod.POST })
			public @ResponseBody
			String roleAuthUpdate(Model model, HttpServletRequest req) throws Exception {
		try {
			String json=req.getParameter("json");
			roleAuthService.updateRoleMenu("1", json);
			return "1";
		} catch (Exception e) {
			logger.debug(e);
			return "0";
		}
	}

}
