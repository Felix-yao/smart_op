package com.kkgame.adx.order.dao;

import java.util.List;

import com.kkgame.adx.order.bean.SilverVO;

public interface SilverDao {
	
	List<SilverVO> listSilveVO(SilverVO silverVO) throws Exception;
	
	void updateLogisticsNumber(SilverVO silverVO) throws Exception;
	
	void updateStatus(SilverVO silverVO) throws Exception;
	
	SilverVO getSilverVO(SilverVO silverVO) throws Exception;

}
