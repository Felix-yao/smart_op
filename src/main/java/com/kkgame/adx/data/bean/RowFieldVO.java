package com.kkgame.adx.data.bean;

public class RowFieldVO {

	/**
	 * 0: 不显示，1：显示
	 */
	private int isShowDate = 0;
	private int isShowPublisher = 0;
	private int isShowApp = 0;
	private int isShowCountry = 0 ;
	private int isShowCarrier = 0;
	private int isShowAm = 0;
	private int isShowAdType = 0;
	private int isShowDsp = 0;
	private int isShowType = 0;
	private int isShowSize = 0;
	private int isShowADPosition = 0;
	private int isShowWidth = 0;
	private int isShowHeight = 0;
	

	public static final int ROW_FIELD_DATE = 1;
	public static final int ROW_FIELD_PUBLISHER = 2;
	public static final int ROW_FIELD_APP = 3;
	public static final int ROW_FIELD_COUNTRY = 4;
	public static final int ROW_FIELD_CARRIER=5;
	public static final int ROW_FIELD_AM = 6;
	public static final int ROW_FIELD_ADTYPE =7;
	public static final int ROW_FIELD_DSP = 8;
	public static final int ROW_FIELD_TYPE = 9;
	public static final int ROW_FIELD_SIZE = 10;
	public static final int ROW_FIELD_ADPOSITION = 11;
	public static final int ROW_FIELD_WIDTH = 12;
	public static final int ROW_FIELD_HEIGHT = 13;

	public void setShowRowField(String[] rowFields){
		for (String rowField : rowFields) {
			int rowValue = Integer.valueOf(rowField);
			if (rowValue == RowFieldVO.ROW_FIELD_DATE) {
				isShowDate = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_COUNTRY) {
				isShowCountry = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_CARRIER) {
				isShowCarrier = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_PUBLISHER) {
				isShowPublisher = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_APP) {
				isShowApp = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_AM) {
				isShowAm = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_ADTYPE) {
				isShowAdType = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_DSP) {
				isShowDsp = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_TYPE) {
				isShowType = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_SIZE) {
				isShowSize = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_ADPOSITION) {
				isShowADPosition = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_WIDTH) {
				isShowWidth = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_HEIGHT) {
				isShowHeight = 1;
			}
			
		}
	}

	
	public int getIsShowWidth() {
		return isShowWidth;
	}

	public void setIsShowWidth(int isShowWidth) {
		this.isShowWidth = isShowWidth;
	}


	public int getIsShowHeight() {
		return isShowHeight;
	}


	public void setIsShowHeight(int isShowHeight) {
		this.isShowHeight = isShowHeight;
	}


	public int getIsShowADPosition() {
		return isShowADPosition;
	}

	public void setIsShowADPosition(int isShowADPosition) {
		this.isShowADPosition = isShowADPosition;
	}

	public int getIsShowType() {
		return isShowType;
	}

	public void setIsShowType(int isShowType) {
		this.isShowType = isShowType;
	}

	public int getIsShowSize() {
		return isShowSize;
	}

	public void setIsShowSize(int isShowSize) {
		this.isShowSize = isShowSize;
	}

	public int getIsShowDate() {
		return isShowDate;
	}

	public void setIsShowDate(int isShowDate) {
		this.isShowDate = isShowDate;
	}

	public int getIsShowPublisher() {
		return isShowPublisher;
	}

	public void setIsShowPublisher(int isShowPublisher) {
		this.isShowPublisher = isShowPublisher;
	}

	public int getIsShowApp() {
		return isShowApp;
	}

	public void setIsShowApp(int isShowApp) {
		this.isShowApp = isShowApp;
	}

	public int getIsShowCountry() {
		return isShowCountry;
	}

	public void setIsShowCountry(int isShowCountry) {
		this.isShowCountry = isShowCountry;
	}

	public int getIsShowCarrier() {
		return isShowCarrier;
	}

	public void setIsShowCarrier(int isShowCarrier) {
		this.isShowCarrier = isShowCarrier;
	}

	public int getIsShowAm() {
		return isShowAm;
	}

	public void setIsShowAm(int isShowAm) {
		this.isShowAm = isShowAm;
	}

	public int getIsShowAdType() {
		return isShowAdType;
	}

	public void setIsShowAdType(int isShowAdType) {
		this.isShowAdType = isShowAdType;
	}

	public int getIsShowDsp() {
		return isShowDsp;
	}

	public void setIsShowDsp(int isShowDsp) {
		this.isShowDsp = isShowDsp;
	}

}
