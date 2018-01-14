package com.kkgame.adx.order.service;

import java.util.List;

import com.kkgame.adx.order.bean.SilverVO;

public interface SilverService {
	
	List<SilverVO> listSilveVO(SilverVO silverVO) throws Exception;
	
	void updateLogisticsNumber(SilverVO silverVO) throws Exception;
	
	void updateStatus(SilverVO silverVO) throws Exception;
	
	SilverVO getSilverVO(SilverVO silverVO) throws Exception;
	
}
