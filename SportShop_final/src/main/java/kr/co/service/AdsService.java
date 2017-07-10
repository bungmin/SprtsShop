package kr.co.service;

import java.util.List;

import kr.co.domain.AdsVO;

public interface AdsService {
	
	public abstract int getAno() throws Exception;
	
	public abstract void insertAds(AdsVO vo) throws Exception; 
	
	public abstract List<AdsVO> listads() throws Exception;
	
	public abstract List<AdsVO> registerdListAds() throws Exception;
	
	public abstract void delete(int ano) throws Exception; 
	
	public abstract void registerAds(int ano) throws Exception;
	
	public abstract void deleteAds(int ano) throws Exception;
	
	public abstract void addReadCnt(int ano) throws Exception;
	
	public abstract AdsVO readAds(int ano) throws Exception;

	public abstract void update(AdsVO vo) throws Exception;

}
