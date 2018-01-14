package com.kkgame.adx.dsp.service;

import java.util.List;

import com.kkgame.adx.dsp.bean.DspVO;

public interface DspService {

	List<DspVO> selectAll(DspVO dspVO) throws Exception;

	void insertDsp(DspVO dspVO) throws Exception;

	void updateDsp(DspVO dspVO) throws Exception;

	DspVO selectDspById(DspVO dspVO) throws Exception;

	List<DspVO> selectIdName(DspVO dspVO) throws Exception;

	void updateDspStatus(DspVO dspVO) throws Exception;

}
