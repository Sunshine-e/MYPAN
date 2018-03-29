package com.ittahac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ittahac.util.JsonUtil;

public abstract class BaseController {
	
	public final static String STATUS = "status";
	public final static String SUCCESS = "success";
	public final static String ERROR = "error";
	public final static String FAIL = "fail";
	
	public final static String SUCCESS_CODE = "1";
	public final static String ERROR_CODE = "-1";
	public final static String FAIL_CODE = "0";
	
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	protected HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	protected ModelAndView getBaseView (String view) {
		ModelAndView mv = new ModelAndView(view);
		mv.addObject("contextPath", this.getRequest().getContextPath());
		return mv;
	}
	
	protected void putJsonIntoResponse (Object content) {
		try {
			this.getResponse().setContentType("application/json;charset=UTF-8");
			this.getResponse().setCharacterEncoding("UTF-8");
			this.getResponse().getWriter().print(JsonUtil.toJson(content));
			this.getResponse().getWriter().flush();
			this.getResponse().getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void putHtmlIntoResponse (String content) {
		try {
			this.getResponse().setContentType("text/html;charset=UTF-8");
			this.getResponse().setCharacterEncoding("UTF-8");
			this.getResponse().getWriter().print(content);
			this.getResponse().getWriter().flush();
			this.getResponse().getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("error")
	public ModelAndView errorPage(@RequestParam("message") String message) {
		ModelAndView mv = this.getBaseView("error");
		mv.addObject("message", message);
		return mv;
	}
	
	
}
