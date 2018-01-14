package com.kkgame.adx.publisher.service.impl;

import java.util.List;

import com.kkgame.adx.publisher.bean.PublisherVO;
import com.kkgame.adx.publisher.dao.PublisherDao;
import com.kkgame.adx.publisher.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {
	
	private PublisherDao publisherDao;
	
	public PublisherDao getPublisherDao() {
		return publisherDao;
	}

	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	@Override
	public void createPublisher(PublisherVO publisherVO) throws Exception {
		publisherDao.createPublisher(publisherVO);
	}

	@Override
	public void updatePublisher(PublisherVO publisherVO) throws Exception {
		publisherDao.updatePublisher(publisherVO);
	}

	@Override
	public List<PublisherVO> getPublisherVOList(PublisherVO publisherVO) throws Exception {
		return publisherDao.getPublisherVOList(publisherVO);
	}

	@Override
	public void updatePublisherStatus(PublisherVO publisherVO) throws Exception {
		publisherDao.updatePublisherStatus(publisherVO);
	}

	@Override
	public PublisherVO getPublisherVO(PublisherVO publisherVO) throws Exception {
		return publisherDao.getPublisherVO(publisherVO);
	}

}
