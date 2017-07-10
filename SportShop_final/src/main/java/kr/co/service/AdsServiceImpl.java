package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.AdsVO;
import kr.co.persistence.AdsDAO;

@Service
public class AdsServiceImpl implements AdsService {
	
	@Inject
	AdsDAO dao;
	
	@Override
	public int getAno() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAno();
	}

	@Override
	public void insertAds(AdsVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		
		dao.insertAds(vo);
		
	}

	@Override
	public List<AdsVO> listads() throws Exception {
		// TODO Auto-generated method stub
		return dao.listads();
	}

	@Override
	public void delete(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		dao.delete(ano);
		
	}

	@Override
	public void registerAds(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		dao.registerAds(ano);
		
	}

	@Override
	public void deleteAds(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		dao.deleteAds(ano);
		
	}

	@Override
	public List<AdsVO> registerdListAds() throws Exception {
		// TODO Auto-generated method stub
		return dao.registerdListAds();
	}

	@Override
	public void addReadCnt(int ano) throws Exception {
		// TODO Auto-generated method stub
		
		dao.addReadCnt(ano);
		
	}

	@Override
	public AdsVO readAds(int ano) throws Exception {
		// TODO Auto-generated method stub
		return dao.readAds(ano);
	}

	@Override
	public void update(AdsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
		
	}
	
	

	
	

	
	
	
}
