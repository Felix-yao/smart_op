package com.kkgame.adx.adver.service;

import java.util.List;

import com.kkgame.adx.adver.bean.AdverVO;

public interface AdverService {

	List<AdverVO> selectAll(AdverVO adverVO) throws Exception;

	void updateAdverStatus(AdverVO adverVO) throws Exception;

	AdverVO selectAdverById(AdverVO adverVO) throws Exception;

	void insertAdver(AdverVO adverVO) throws Exception;

	void updateAdver(AdverVO adverVO) throws Exception;

}
