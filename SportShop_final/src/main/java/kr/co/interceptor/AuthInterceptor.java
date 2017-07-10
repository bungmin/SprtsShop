package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session =request.getSession();
		
		if(session.getAttribute("login")== null){	//로그인이 안된 상태냐 물어보는거
			
			
			saveDest(request);
			
			response.sendRedirect("/user/login");
			return false;		//더이상 인터셉터가 적용되지 않게끔
		}	
		
		/*true이면 다음 인터셉터가 적용 될수 있게*/
		return true;		
	}

	
	private void saveDest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String uri =request.getRequestURI();
		String query = request.getQueryString();
		
		if(query==null || query.equals("null")){
			query="";
		}else{
			query="?"+query;
		}
		
		if(request.getMethod().equals("GET")){
			request.getSession().setAttribute("dest", uri+query);
		}		
		
		/*원래 uri로 가기위해서*/
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		//super.postHandle(request, response, handler, modelAndView);
	}
}
