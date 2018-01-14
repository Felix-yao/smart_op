package com.kkgame.adx.dsp.dao;

import java.util.List;

import com.kkgame.adx.dsp.bean.DspVO;

public interface DspDao {

	List<DspVO> selectAll(DspVO dspVO);

	void insertDsp(DspVO dspVO);

	void updateDsp(DspVO dspVO);

	DspVO selectDspById(DspVO dspVO);

	List<DspVO> selectIdName(DspVO dspVO);

	void updateDspStatus(DspVO dspVO);

}
