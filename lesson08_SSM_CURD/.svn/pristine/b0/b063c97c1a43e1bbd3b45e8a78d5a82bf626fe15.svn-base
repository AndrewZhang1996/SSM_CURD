package com.etc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import com.etc.common.ServiceException;
import com.etc.pojo.UserPojo;
import com.etc.service.UserService;

/**
 * 这是用户模块
 * 	包括：登录。
 * @author Administrator
 *
 */

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("login.action")
	public String login(UserPojo user, Model mode, HttpServletRequest request) {
		
		try {
			service.checkUser(user);
			request.getSession().setAttribute("user", user);
		} catch (ServiceException e) {
			
			RequestContext rc = new RequestContext(request);
			mode.addAttribute("msg", rc.getMessage(e.getMessage()));
			return "login";
		}
		
		
		return "redirect:welcome.jsp";
	}
	
	@RequestMapping("regist.action")
	public String reigts(UserPojo user) {
		
		
		try {
			service.insert(user);
		} catch (ServiceException e) {
			return "regist";
		}
		
		return "login";
	}
	
	/**
	 * ajax
	 * @param user
	 * @return
	 */
	@RequestMapping("search.action")
	@ResponseBody
	public List<UserPojo> search(UserPojo user) {
		
		
		List<UserPojo> ulist = service.findByCondition(user);
		
		return ulist;
	}
	
	/**
	 * 更新页面的初始化
	 * @param id
	 * @return
	 */
	@RequestMapping("updateUserInfo.action")
	public String update(Integer id, Model mode) {
		
		UserPojo po = service.findById(id);
		mode.addAttribute("po", po);
		
		return "update";
	}
	
	/**
	 * 更新按钮按下时处理
	 * @param user
	 * @param mode
	 * @return
	 */
	@RequestMapping("update.action")
	public String update(UserPojo user, Model mode) {
		
		try {
			service.update(user);
		} catch (ServiceException e) {
			
			mode.addAttribute("msg", e.getMessage());
			return "forward:updateUserInfo.action";
		}
		
		
		return "search";
	}
	@RequestMapping("delete.action")
	public String delete(Integer id, Model mode) {
		
		service.delete(id);
		
		
		return "search";
	}
}
