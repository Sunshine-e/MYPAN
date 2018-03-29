package com.ittahac.maker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptior implements HandlerInterceptor{

	/**
	 * 预处理回调方法
	 * @return
	 * true表示继续流程（可调用下一个拦截器或处理器）,
	 * false表示流程中断（不会继续调用其他的拦截器或处理器）。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
//		return false;
		return true;
	}

	/**
	 * 后处理回调方法,实现处理器的后处理（但在渲染视图之前）
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	/**
	 * 整个请求处理完毕回调方法，即在视图渲染完毕时回调
	 * 性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}
