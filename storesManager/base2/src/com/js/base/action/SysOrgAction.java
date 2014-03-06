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

import com.js.base.service.ISysOrgService;
import com.js.base.vo.LoginBean;
import com.js.base.vo.SysOrgBean;
import com.js.commons.paginator.Page;

@Controller
@RequestMapping("")
public class SysOrgAction {
	private static Logger logger = Logger.getLogger(UsersAction.class);
	@Autowired
	@Qualifier("sysOrgService")
	private ISysOrgService sysOrgService;

	@RequestMapping(value = "/orgList", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	String orgQueryList(Model model, HttpServletRequest req) throws Exception {
		SysOrgBean parm = new SysOrgBean();
		List<SysOrgBean> list = sysOrgService.getSysOrgList(parm);
		System.out.println("abc");
		JSONArray json = new JSONArray();
		for (SysOrgBean org : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", org.getOrg_no());
			jsonObject.put("parentId", org.getOrg_upno());
			jsonObject.put("name", org.getOrg_name());
			json.add(jsonObject);
		}
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping(value = "/orgAdd", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	String orgAdd(Model model, HttpServletRequest req,
			@ModelAttribute("form") SysOrgBean parm) throws Exception {
		int sum=sysOrgService.insertOrg(parm);
		if(sum==1){
			return "success";
		}else{
			return "error";
		}
	}

}
