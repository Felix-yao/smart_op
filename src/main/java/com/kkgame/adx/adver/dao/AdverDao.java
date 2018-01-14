package com.kkgame.adx.adver.dao;

import java.util.List;

import com.kkgame.adx.adver.bean.AdverVO;

public interface AdverDao {

	List<AdverVO> selectAll(AdverVO adverVO);

	void updateAdverStatus(AdverVO adverVO);

	AdverVO selectAdverById(AdverVO adverVO);

	void insertAdver(AdverVO adverVO);

	void updateAdver(AdverVO adverVO);

}
