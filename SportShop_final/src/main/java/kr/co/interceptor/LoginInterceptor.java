package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.domain.LoginDTO;
import kr.co.domain.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private final String LOGIN="login";
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		
		/*로그인이라는 키를 가지고 있는냐*/
		if(session.getAttribute(LOGIN) != null){		/*로그인을 한 상태*/			
			/*로그인을 했는데 또 다시 로그인을 하는 거는 새로운 아이디로 로그인을 하겠따 그래서 attrivute 지움..*/
			session.removeAttribute(LOGIN);			
		}		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session =request.getSession();
		
		
		/*문자로 되어있으면 getModel, 객체로 되어있으면 getModelMap*/
		ModelMap modelMap =modelAndView.getModelMap();		
		Object userVo= modelMap.get("userVO");		
		

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(userVo);
		
		UserVO vo = (UserVO)userVo;
				
//		System.out.println(userVo.);
		
		if(userVo != null){
			
			session.setAttribute(LOGIN, userVo);
		
			Object dest =session.getAttribute("dest");
		//	String path = dest !=null?(String)dest:"/";
			
			String path = "";
			
		
			if(vo.getPosition().equalsIgnoreCase("user")){
				path = dest !=null?(String)dest:"/";				
			}else if(vo.getPosition().equalsIgnoreCase("admin")){
				path = dest !=null?(String)dest:"/admin";				
			}else if(vo.getPosition().equalsIgnoreCase("ceo")){
				path = dest !=null?(String)dest:"/ceo";				
			}
			
			session.removeAttribute("dest");				
			response.sendRedirect(path);
			
			
			
			

			

			
/*			System.out.println(userVo.getPosition());*/
			
		/*	if(userVo.getPosition() == "user"){
			
				
			}else if(userVo.getPosition() == "admin"){
				String path = dest !=null?(String)dest:"/admin";
				session.removeAttribute("dest");				
				response.sendRedirect(path);
				
			}*/
			
			
		}

	}

	

}
