package com.js.base.action;

import java.util.Date;
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

import com.js.base.service.IRoleService;
import com.js.base.vo.SysRoleBean;
import com.js.commons.paginator.Page;
import com.js.commons.util.DateStyle;
import com.js.commons.util.DateUtil;

@Controller
@RequestMapping("")
public class RolesAction {
	private static Logger logger = Logger.getLogger(RolesAction.class);
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;

	@RequestMapping(value = "/roleList", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	JSONObject roleQueryList(Model model, HttpServletRequest req)
			throws Exception {
		SysRoleBean parm = new SysRoleBean();
		parm.setRole_no(req.getParameter("role_no"));
		Page page = new Page();
		page.setCurrentPage(StringUtils.isBlank(req.getParameter("page")) ? 1
				: Integer.parseInt(req.getParameter("page")));
		page.setShowCount(StringUtils.isBlank(req.getParameter("rows")) ? 1
				: Integer.parseInt(req.getParameter("rows")));
		parm.setPage(page);
		List<SysRoleBean> list = roleService.getRoleList(parm);

		JSONArray json = new JSONArray();
		for (SysRoleBean role : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("role_no", role.getRole_no());
			jsonObject.put("role_name", role.getRole_name());
			jsonObject.put("role_sts", role.getRole_sts());
			json.add(jsonObject);
		}

		JSONObject datas = new JSONObject();
		datas.put("rows", json);
		datas.put("total", page.getTotalResult());
		return JSONObject.fromObject(datas);
	}


	@RequestMapping(value = "/roleAdd", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	String roleAdd(Model model, HttpServletRequest req,
			@ModelAttribute("form") SysRoleBean parm) throws Exception {
		String role_no=roleService.getMaxRoleNo();
		if(StringUtils.isBlank(role_no)){
			role_no="0";
		}
		long max_role_no=Long.parseLong(role_no)+1;
		parm.setRole_no(max_role_no+"");
		try {
			parm.setOp_no("admin");
			parm.setTx_date(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
			roleService.insertRole(parm);
			return "1";
		} catch (Exception e) {
			return "0";
		}
	}
	
	@RequestMapping(value = "/roleDetail", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String roleDetails(Model model, HttpServletRequest req)
			throws Exception {
		String role_no = req.getParameter("role_no");
		SysRoleBean detail = roleService.getRoleDetails(role_no);

		model.addAttribute("command", detail);
		return "base/roleDetail";
	}

	@RequestMapping(value = "/roleUpdate", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody String roleUpdate(Model model,HttpServletRequest req) {
		try {
			String role_no=req.getParameter("role_no");
			String role_name=req.getParameter("role_name");
			SysRoleBean role=new SysRoleBean();
			role.setRole_no(role_no);
			role.setRole_name(role_name);
			roleService.updateRole(role);
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("error", "更新失败！");
		}
//		model.addAttribute("command", user);
		return "0";
	}
	
	@RequestMapping(value = "/roleDelete", method = { RequestMethod.GET,
			RequestMethod.POST })
			public @ResponseBody String roleDelete(Model model,HttpServletRequest req) {
		try {
			String role_no=req.getParameter("role_no");
			SysRoleBean role=new SysRoleBean();
			role.setRole_no(role_no);
			roleService.deleteRole(role);
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("error", "更新失败！");
		}
//		model.addAttribute("command", user);
		return "0";
	}

}
