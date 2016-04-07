/**
 * 
 */
package com.make.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.make.bean.UserBean;


/**
 * @类名称：SystemInterceptor
 * @类描述：拦截器
 * @创建时间：2015-8-27 上午10:08:39
 * @修改人：Administrator
 * @修改时间：2015-8-27 上午10:08:39
 * @修改备注：
 * @version
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {
	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器（如我们上一章的Controller实现）；
	 * 返回值：true表示继续流程（如调用下一个拦截器或处理器）； false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器
	 * ，此时我们需要通过response来产生响应；
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("进入系统拦截器--------Begin");
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		log.info("进入系统拦截器,请求地址：--------" + requestUrl);

		if (requestUrl.indexOf("/login") >= 0 || requestUrl.indexOf("/logout") >= 0 || requestUrl.indexOf("/app") >= 0) {
			return true;
		}
		if (request.getSession() == null) {
			log.info("拦截器判断Session超时，不能继续流程，需要重新登录-----------NO");
			response.sendRedirect("index.jsp");
			return false;
		} else {
			UserBean user = (UserBean) request.getSession().getAttribute("userInfo");
			if (user != null) {
				log.info("拦截器判断用户已登录，可以继续流程-----------OK");
				return true;
			} else {
				log.info("拦截器判断用户未登录，不能继续流程-----------NO");
				response.sendRedirect("index.jsp");
				return false;
			}
		}

	}

	/**
	 * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）
	 * 对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理
	 * ，类似于try-catch-finally中的finally，
	 * 但仅调用处理器执行链中preHandle返回true的拦截器的afterCompletion。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}
