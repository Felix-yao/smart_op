package com.kkgame.adx.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

public class PkigConstants {
	public static ServletContext PKIG_WEB_CONTEXT = null;

	/**
	 * 鍒嗛〉-姣忛〉鏄剧ず鏉℃暟
	 */
	public static final int PAGE_SIZE = 50;
	/**
	 * 鍒嗛〉-椤垫暟
	 */
	public static final int PAGE_NUM = 1;
	/**
	 * 鍒嗛〉-姣忛〉鏄剧ず鐨勬潯鏁發ist
	 */
	public static final String PAGE_SIZE_LIST = "15,20,35,50,100";
	/**
	 * 椤圭洰鏍圭洰褰�
	 */
	public static String PKIG_WEB_ROOT = "";
	
	
	public final static int SETTLE_METHOD_WEEK=1;// 鍛ㄧ粨
	public final static int SETTLE_METHOD_MONTH=2;//鏈堢粨
	
	public final static String ROOT_PATH = "RootPath";
	
	 public final static String SESSION_USER = "SESSION_USER";
	 public final static String ROLE_CUSTOMER = "ROLE_CUSTOMER";
	 public final static String ROLE_PUBLISHER = "PB";
	 public final static String ROLE_AM_PUBLISHER = "AMP";
	 public final static String ROLE_MANAGER_PUBLISHER = "AMPM";
	 public final static String ROLE_AM_ADVER = "AMA";
	 public final static String ROLE_MANAGER_ADVER = "AMAM";
	 public final static String ROLE_PROXY = "PY";
	 public final static String ROLE_AM_ALL = "AMT";
	 public final static String ROLE_ADVER = "AD";
	 public final static String ROLE_ADMIN = "SP";
	 public final static String ROLE_AMAN = "AMAN";
	 public final static String ROLE_AM = "AM";
	 
	 public static Map<String, Object> ONLINE_USER = new HashMap<String, Object>();
	 
	 public static final String RESPONSE_ERROR = "-1";
	 
	 /*************************瀹㈡埛甯搁噺**********************************/
		/**
	     * 瀹㈡埛鐘舵��-鏂板缓
	     */		
		public static final int CUSTOMER_STATUS_NEW = 0;
		/**
	     * 瀹㈡埛鐘舵��-寰呭
	     */		
		public static final int CUSTOMER_STATUS_WAIT_CONFIRM = 1;
		/**
	     * 瀹㈡埛鐘舵��-鎷撳睍涓�
	     */		
		public static final int CUSTOMER_STATUS_DEVING = 2;
		/**
	     * 瀹㈡埛鐘舵��-瀹℃牳涓嶉�氳繃
	     */		
		public static final int CUSTOMER_STATUS_NO_PASS = 3;
		/**
	     * 瀹㈡埛鐘舵��-绛剧害
	     */		
		public static final int CUSTOMER_STATUS_SIGN_UP = 4;
		/**
	     * 瀹㈡埛鐘舵��-浠ｇ悊鏀惧純
	     */		
		public static final int CUSTOMER_STATUS_ABANDON = 5;
		
		/**
	     * 瀹㈡埛鐘舵��-鏀跺洖鎷撳睍鏉�
	     */		
		public static final int CUSTOMER_STATUS_CALL_BACK = 6;
		/**
	     * 瀹㈡埛鐘舵��-宸茶繃鏈�
	     */		
		public static final int CUSTOMER_STATUS_OVERDUE = 7;
		/**
	     * 瀹㈡埛鐘舵��-寤舵湡
	     */		  
		public static final int CUSTOMER_STATUS_DEFERRED = 8;
		/**
	     * 瀹㈡埛寤舵湡鐘舵��-鍚屾剰寤舵湡
	     */		  
		public static final int CUSTOMERS_DEFERRED_AGREE = 80;
		/**
	     * 瀹㈡埛寤舵湡鐘舵��-涓嶅悓鎰忓欢鏈�
	     */		  
		public static final int CUSTOMER_DEFERRED_DISAGREE = 81;
		/**
	     * 瀹㈡埛鐘舵��-闂茬疆
	     */		  
		public static final int CUSTOMER_STATUS_IDLE = 9;
		
		/**
	     * 瀹㈡埛鐘舵��-绉讳氦
	     */		  
		public static final int CUSTOMER_STATUS_DEVOLVE = 10;
		/**
	     * 瀹㈡埛绉讳氦鐘舵��-鍚屾剰绉讳氦
	     */		  
		public static final int CUSTOMER_DEVOLVE_AGREE = 100;
		
		/**
	     * 瀹㈡埛绉讳氦鐘舵��-涓嶅悓鎰忕Щ浜�
	     */		  
		public static final int CUSTOMER_DEVOLVE_DISAGREE = 101;
		
		/**
	     * 瀹㈡埛绉讳氦鐘舵��-鍙栨秷绉讳氦
	     */		  
		public static final int CUSTOMER_DEVOLVE_CANCEL = 102;
		

		/**
	     * 瀹㈡埛鐘舵��-鎵�鏈夌姸鎬�
	     * 鏌ヨ鐘舵��
	     */		
		public static final int CUSTOMER_STATUS_ALL = 99;
		
		public static final String POST_URL = "http://advhz.kokgc.com/inter/UserRegister!data.action";

		public static final String POST_REGISTER_URL = "http://advhz.kokgc.com/inter/UserRegister!data.action";

		public static final String POST_DIVIDE_URL = "http://advhz.kokgc.com/inter/UserDivide!data.action";
		
//		public static final String BIG_DATA_URL = "http://104.250.136.138:5555/";
		public static final String BIG_DATA_URL = "http://192.168.1.29:5555/";
		
		public static final String  VSOYOU_URL = "http://api.huntmobi.com/inf/adsync/kok_ssp.htm";
		
		public static final String SSP_URL = "http://ssp.mobikok.com/";//正式项目地址
//		public static final String SSP_URL = "http://192.168.1.246:8083/ssp/";//测试项目地址
//		public static final String SSP_URL = "http://localhost:8080/kok_adv_ssp_op/";//本地项目地址
		
		public static final String SSP_FILE_PATH ="/home/kok/app/ssp/ssp_op/ROOT/upload/";//正式服务器图片文件地址
//		public static final String SSP_FILE_PATH ="/home/ck/app/ssp/kok_ssp_op/ROOT/upload/";//测试服务器图片文件地址
		
//		public static final String SSP_FILE_URL = "http://192.168.1.246:8083/ssp/upload/";//测试图片请求地址
		public static final String SSP_FILE_URL = "http://ssp.bbisbw.com/upload/";//正式图片请求地址
}
