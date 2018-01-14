package com.kkgame.adx.publisher.service;

import java.util.List;

import com.kkgame.adx.publisher.bean.PublisherVO;

public interface PublisherService {
	
	void createPublisher(PublisherVO publisherVO) throws Exception;
	void updatePublisher(PublisherVO publisherVO) throws Exception;
	List<PublisherVO> getPublisherVOList(PublisherVO publisherVO) throws Exception;
	void updatePublisherStatus(PublisherVO publisherVO) throws Exception;
	PublisherVO getPublisherVO(PublisherVO publisherVO) throws Exception;

}
