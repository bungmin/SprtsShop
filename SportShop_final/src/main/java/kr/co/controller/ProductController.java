package kr.co.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.CartVO;
import kr.co.domain.Criteria;
import kr.co.domain.LoginDTO;
import kr.co.domain.OrderInfoVO;
import kr.co.domain.OwnerPageVO;
import kr.co.domain.PageMaker;
import kr.co.domain.ProductVO;
import kr.co.domain.UserInfoVO;
import kr.co.domain.UserVO;
import kr.co.service.CartService;
import kr.co.service.OrderInfoService;
import kr.co.service.ProductService;
import kr.co.service.UserService;
import kr.co.util.UploadFileUtils;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private ProductService service;

	@Inject
	private CartService cart_service;
	
	@Inject
	private UserService user_service;

	@Inject
	private OrderInfoService order_info_service;
	
	@RequestMapping(value="/insertProduct", 
			method=RequestMethod.GET)
	public void insetProductGet() throws Exception {
		
	
		
		
		
	}
	
	
	@RequestMapping(value="/listCriteriaAdmin", method=RequestMethod.GET)
	public void ListAllCriteriaProduct(@ModelAttribute("cri")Criteria cri,Model model) throws Exception { 
		
		System.out.println("++++++++++++++++++++");
		System.out.println(cri);
		List<ProductVO> list = service.listCriteriaAdmin(cri);

		model.addAttribute("listAllProduct", list);		
		int totalCount = service.totalCount();
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setCri(cri);	
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("pageMaker", pageMaker);

		
	}
	
	
	
	@RequestMapping(value="/insertProduct", method=RequestMethod.POST)
	public String insetProductPOST(ProductVO vo, MultipartFile file1, MultipartFile file2, RedirectAttributes rttr) throws Exception { 
		
		

			int pno = service.getPno(); 
			vo.setPno(pno);

			
			String uploaded_p_img_1=UploadFileUtils.uploadFile(uploadPath, file1.getOriginalFilename(), file1.getBytes(), "main");
			String uploaded_p_img_2=UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(), file2.getBytes(), "sub");
			vo.setP_img_1(uploaded_p_img_1);
			vo.setP_img_2(uploaded_p_img_2);
			service.insertProduct(vo); 

	
		
		
		
		return "redirect:/product/listCriteriaAdmin"; 
	}

	//
	@RequestMapping(value="/listAllProduct", method=RequestMethod.GET)
	public void ListAllProduct(Model model) throws Exception { 
		
		
		List<ProductVO> listAllProduct = service.ListAllProduct();
		
		model.addAttribute("listAllProduct", listAllProduct);  
		 
	}

		@RequestMapping(value="/updateProduct", method=RequestMethod.GET)
		public void ListAllProduct(@RequestParam("pno") int pno, Model model) throws Exception { 
			
			ProductVO p_vo = service.readProduct(pno);
			
			model.addAttribute("p_vo", p_vo);	
		}
		@RequestMapping(value="/updateProduct", method=RequestMethod.POST) //상품수정
		public String ListAllProduct(ProductVO vo , MultipartFile file1, MultipartFile file2) throws Exception { 
			System.out.println(vo+"******************************");
			
			String uploaded_p_img_1=UploadFileUtils.uploadFile(uploadPath, file1.getOriginalFilename(), file1.getBytes(), "main");
			String uploaded_p_img_2=UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(), file2.getBytes(), "sub");
			vo.setP_img_1(uploaded_p_img_1);
			vo.setP_img_2(uploaded_p_img_2);
			
			service.updateProduct(vo);
				
			return "redirect:/product/listCriteriaAdmin";
		}
		
		
		@RequestMapping(value="/deleteProduct", method=RequestMethod.GET) //상품삭제
		public String DeleteProduct(@RequestParam("pno") int pno) throws Exception { 
			
			service.deleteProduct(pno);
				
			return "redirect:/product/listCriteriaAdmin";
		}
		
		
		
		@RequestMapping(value="/purchaseProductPage", method=RequestMethod.GET)
		public void PurchaseProduct(@RequestParam("pno") Integer pno, Model model, int count, String id, HttpServletRequest request) throws Exception {					
						
			
			float mileage_rate = (float) 0.003; //마일리지 적립률 3퍼센트
			
			HttpSession session =request.getSession();
			
			UserVO vo =(UserVO) session.getAttribute("login");
			
			
			System.out.println("ddddd");
			System.out.println(vo);
			UserInfoVO user_info_vo =user_service.userInfo(vo.getId());
			
			model.addAttribute("user_info_vo", user_info_vo);
			//즉시구매시
			if (pno != 0 && count != 0) { // pno!=0 와 count !=0 으로 잡은 이유는! 즉시 구매 버튼에서 이 컨트롤러로 넘어 올때 이 숫자들을 가져오기 때문이데 
			ProductVO p_vo = service.readProduct(pno); //
			float getP =  p_vo.getP_price();
			float perNum = p_vo.getP_discount_rate();
			float rate = perNum/100; 
			float t_discountedPrice = (getP * (1-rate));	
			int discountedPrice=(int) (Math.floor(t_discountedPrice * Math.pow(10, -1))/Math.pow(10, -1));
			int discount = (int) (getP * rate); 
			int mileage = (int) (discountedPrice * mileage_rate); 
									
			p_vo.setDiscountedPrice(discountedPrice * count);
			p_vo.setDiscount(discount * count);
			p_vo.setMileage(mileage * count);
			p_vo.setCount(count);
			
			System.out.println(count+"0000000000000000000000000000000");
			
			model.addAttribute("p_vo", p_vo);
			} 
			
			if (pno == 0 && count == 0) { // pno == 0 과 count ==0 인 단하나의 이유는! 카트에서 이쪽으로 넘오 올때 이값을 0으로 고정시켜 보내기 때문이다. *pno, count 값을 파라미터로 불러올때 오류가 나기 때문에  뭐라도 가져와야 한다*
				List<CartVO> clist = cart_service.listAllCart(id); //카트에 답겨진 pno, count 값을 받아오기 위해 카트 목록에 있는 데이터 호출
					
				Map<Integer, Integer> pnoMap = new HashMap<Integer, Integer>(); // pno값을 받을 맵 설정
				Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(); //count값을 받을 맵 설정
				for (int i = 0; i < clist.size(); i++) { 
					int c_pno = clist.get(i).getPno(); // 카트테이블에서 빼온 pno 값을 맵에다 for 문으로 저장
					 pnoMap.put(i, c_pno);
											
				}
				for (int i = 0; i < clist.size(); i++) { // 카트테이블에서 빼온 count 값을 맵에다 for문으로 저장.
					int c_count = clist.get(i).getCount();
					countMap.put(i, c_count);
					
				}
				
				
				int ppno = 0; //ppno는 pno의 새로운 이름
				List<ProductVO> list = new ArrayList<ProductVO>(); // 최종 상품 정보를 총괄하는 리스트 작성
				
				for (int i = 0; i < pnoMap.size(); i++) {
					ppno = pnoMap.get(i);
					
					ProductVO p_vo = service.readProduct(ppno); //ppno로 각각의 상품 정보를 상품 DB에서 호출함
					list.add(p_vo); //리스트에 저장
					list.get(i).setCount(countMap.get(i)); // 저장하자마자 count 값을 저장해주어 서로의 정보를 맞춰준다. ****단 순서를 맞춰주는것이 중요!*****
					
				}
									
				//리스트에 담긴 최종 정보중 할인된가격, 획들할 마일리지, 할인받는 가격을 계산하여 다시 리스트에 넣어주는 작업을 진행한다.
				
				int totalPrice = 0;
				int totalDiscount = 0;
				int totalMileage = 0;
				
				for (int i = 0; i < list.size(); i++) {
					
					float getP =  list.get(i).getP_price();
					float perNum = list.get(i).getP_discount_rate();
					float rate = perNum/100;
					
					
					
					float t_discountedPrice = (getP * (1-rate)); //1원단위 버림 계산 전 할인된가격
					int discountedPrice=(int) (Math.floor(t_discountedPrice * Math.pow(10, -1))/Math.pow(10, -1)); //1원단위 버림 적용된 할인된 가격
					int discount = (int) (getP * rate); // 할인 받을 가격
					int mileage = (int) (discountedPrice * mileage_rate); // 받을 적립금
					int inListCount = list.get(i).getCount();
					
					
					
					
					list.get(i).setDiscountedPrice(discountedPrice * inListCount);
					list.get(i).setDiscount(discount * inListCount);
					list.get(i).setMileage(mileage * inListCount);
					
					totalPrice += list.get(i).getDiscountedPrice();
					totalDiscount += list.get(i).getDiscount();
					totalMileage += list.get(i).getMileage();
					
					// Json 구분자를 넣어준다!
					list.get(i).setSeperatorNum(i);

					
				}
								
					ProductVO PurPage_vo = new ProductVO(); //구매 페이지를 위한 객체일뿐 다른데서는 절대로 쓰이지 않는다.
					PurPage_vo.setTotalPrice(totalPrice);
					PurPage_vo.setTotalDiscount(totalDiscount);
					PurPage_vo.setTotalMileage(totalMileage);
					
									
					model.addAttribute("PurPage_vo", PurPage_vo);
					model.addAttribute("list", list);
						
			} 
		}
		
		// 6월 29일 추가
		@ResponseBody
		@RequestMapping(value="/singleOrderInfoHistory", method=RequestMethod.POST)
		public ResponseEntity<String> SingleOrderInfoHistory(@RequestBody OrderInfoVO vo) throws Exception{ //즉시구매결제
			ResponseEntity<String> entity = null;
			
			if (vo != null) {
				OrderInfoVO oVO = vo;
				int ono = order_info_service.getOno();
				oVO.setOno(ono);
				order_info_service.insertOrderInfo(oVO);
				System.out.println(vo + "0000000000000000000000000000");
				
				ProductVO vo2 = new ProductVO();
				
				
				vo2.setP_amount(vo.getO_amount());
				vo2.setPno(vo.getPno());
				service.amountBalance(vo2);
				
				//-------------------------------------
				
		
			}
			
			try {
			  entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			  
			  
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				
				}
			
			
			return entity;
			
			
			
			
			
		}
		
		@ResponseBody
		@RequestMapping(value="/cartOrderInfoHistory", method=RequestMethod.POST, produces = "application/json; charset=utf8")
		public int CartOrderInfoHistory(@RequestBody List<OrderInfoVO> list) throws Exception{ //카트구매결제
			
			
			/*ResponseEntity<Integer> entity = null;*/
			OrderInfoVO oVO = new OrderInfoVO();
			String id = list.get(0).getId();
			int ono = 0;
			int maxOno = 0;
			if (list != null) {
				ono = order_info_service.getOno();
				
				maxOno = ono + list.size()-1;
				
				for (int i = 0; i < list.size(); i++) {
				
				oVO = list.get(i);
			
				oVO.setOno(ono+i);
				
								
				order_info_service.insertOrderInfo(oVO);
				
				
				ProductVO vo2 = new ProductVO();				
				
				vo2.setP_amount(list.get(i).getO_amount());
				vo2.setPno(list.get(i).getPno());
				service.amountBalance(vo2);
				
				//Thread.sleep(50);
				}
			}
			
			try {
				/*entity = new ResponseEntity<Integer>(maxOno , HttpStatus.OK);*/
				
				cart_service.deleteAfterPurchase(id); // 구매 완료후 카트 비우기
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				/*entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);*/
			}
			
			
			return maxOno;
			
		}
		
		
	
		@RequestMapping(value="/OrderListValues", method=RequestMethod.PUT)
		public ResponseEntity<String> CartOrderInfoHistory2(@RequestBody OrderInfoVO oVO) throws Exception{
			//------------------------배송지  DB저장-----------------------------						
			int i;
			ResponseEntity<String> entity = null;
			
		
			/*마일리지 추가 부분.
			UserInfoVO vo = new UserInfoVO();
			
			vo.setId(oVO.getId());
			vo.setMileage(oVO.getTotalMileage());		
			
			user_service.addMileage(vo);
			*/
			System.out.println("++++++++++");
			
			
			int count = oVO.getCount();
			int ono = order_info_service.getOno() - 1;
				
			for (i = ono ; i > ono - count ; i--) {
				oVO.setOno(i);					
				order_info_service.insertOrderInfo2(oVO); //update
				
				Thread.sleep(50);
			}
			
			
			
			//------------------------경영진 매출정보 DB 저장-----------------------------------------------------
			
			// 7월 4일
			/*OwnerPageVO opvo = new OwnerPageVO();
			opvo.setRevenue(oVO.getTotalPrice());
			opvo.setUnusedmileage(oVO.getTotalMileage());
			opvo.setUsedmileage(oVO.getUseMileage());
			opvo.setDiscount(oVO.getTotalDiscount());
			service.updateOwnerPage(opvo);
			
			
			
			
			*/
			
			

			// 7월 4일
			OwnerPageVO opvo = new OwnerPageVO();
			int opnum = service.getOpnum();
			
			opvo.setOpnum(opnum); 
			opvo.setRevenue(oVO.getTotalPrice());
			opvo.setUnusedmileage(oVO.getTotalMileage());
			opvo.setUsedmileage(oVO.getUseMileage());
			opvo.setDiscount(oVO.getTotalDiscount());
			System.out.println(opvo+"000000000000000000000000000");
			
			service.insertOwnerPage(opvo); //1차정보 삽입
			
			if (opnum == 1) { //혹시 몰라 초기화 시킴
				
				opvo.setStack_revenue(0);	
				opvo.setStack_discount(0);
				opvo.setStack_usedmileage(0);
				opvo.setStack_unusedmileage(0);
				service.insertOwnerPage2(opvo);
				}
			
			
			
			if (opnum != 1) { //2번 이상부터 아래 적용
			
				OwnerPageVO opvo_beta = service.getBeforeInfo(opnum - 1);		
				System.out.println(opvo_beta+"************************************");
				
				int stack_revenue = opvo_beta.getStack_revenue();
				int stack_discount = opvo_beta.getStack_discount();
				int stack_usedmileage = opvo_beta.getStack_usedmileage();
				int stack_unusedmileage = opvo_beta.getStack_unusedmileage();
				

				opvo.setStack_revenue(stack_revenue);
				opvo.setStack_discount(stack_discount);
				opvo.setStack_usedmileage(stack_usedmileage);
				opvo.setStack_unusedmileage(stack_unusedmileage);
				service.insertOwnerPage2(opvo); //2차정보 삽입
				
				
				
			}
			
			
			
			
			
			try {
				
				
				
				
				
				
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			
		
			return entity;
		}
		
		
		@RequestMapping(value="/userInfoValue", method=RequestMethod.PUT)
		public ResponseEntity<String> userInfoValue(@RequestBody UserInfoVO vo) throws Exception{
			//------------------------배송지  DB저장-----------------------------						
				ResponseEntity<String> entity = null;			
			
			try {
				System.out.println("+++++++++++++");
				
				System.out.println(vo);
				System.out.println("+++++++++++++");
				
				user_service.addMileage(vo);
				user_service.minusCash(vo);				
				user_service.minusMileage(vo);
				
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			
		
			return entity;
		}
		
		
		
		@RequestMapping(value="/ReceiptPage", method=RequestMethod.GET, produces = "application/text; charset=utf8")
		public void ReceiptPage() throws Exception{
			
			
	
	
	
		}
}