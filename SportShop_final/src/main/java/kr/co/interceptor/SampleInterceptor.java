package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter{

	
	
	/*testA실행 되기직전에 실행*/
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("############################");
		System.out.println("preHandle()");
		
		/*return false하면.다른 핸들러 실행 안하겠따..
				true하면 다른 핸들러도 실행하겠따*/
		
		return true;
	}
	
	
	/*testA실행 된 후 실행*/

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("############################");
		System.out.println("postHandle()");
		
		/*return false하면.다른 핸들러 실행 안하겠따..
				true하면 다른 핸들러도 실행하겠따*/
		
		
	}
	
	
	

}
