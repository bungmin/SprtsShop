package kr.co.persistence;

import java.util.List;

import kr.co.domain.AttachVO;
import kr.co.domain.BoardVO;
import kr.co.domain.ProductCriteria;
import kr.co.domain.ProductSearchCriteria;

public interface AttchDAO {

	public abstract List<AttachVO> getAttach(int bno) throws Exception;
	
	

}
