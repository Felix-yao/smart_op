package com.kkgame.adx.tag.service;

import java.util.List;

import com.kkgame.adx.tag.bean.CountryVO;
import com.kkgame.adx.tag.bean.NameVO;
import com.kkgame.adx.tag.bean.Select2VO;

public interface SystemService {

	List<NameVO> getAllAmList(NameVO nameVO) throws Exception;
	List<CountryVO> getCountryList() throws Exception;
	List<NameVO> getAllIAB1List() throws Exception;
	List<NameVO> getIAB2List(NameVO nameVO) throws Exception;
	//select2
	List<Select2VO> getDspSelect2(NameVO nameVO) throws Exception;
	List<Select2VO> getPublisherSelect2(NameVO nameVO) throws Exception;
	List<Select2VO> getAppSelect2(NameVO nameVO) throws Exception;
	List<Select2VO> getADPositionSelect2(NameVO nameVO) throws Exception;
	List<Select2VO> getCountrySelect2(NameVO nameVO) throws Exception;
}
