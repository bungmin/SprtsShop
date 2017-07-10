package kr.co.domain;

public class CartDetailVO {
	private CartVO cartVo;
	private ProductVO productVo;
	
	public CartDetailVO() {
		// TODO Auto-generated constructor stub
	}
	

	public CartDetailVO(CartVO cartVo, ProductVO productVo) {
		super();
		this.cartVo = cartVo;
		this.productVo = productVo;
	}
	
	




	public CartVO getCartVo() {
		return cartVo;
	}


	public void setCartVo(CartVO cartVo) {
		this.cartVo = cartVo;
	}


	public ProductVO getProductVo() {
		return productVo;
	}


	public void setProductVo(ProductVO productVo) {
		this.productVo = productVo;
	}


	@Override
	public String toString() {
		return "CartDetailVO [cartVo=" + cartVo + ", productVo=" + productVo + "]";
	}
	
	

}
