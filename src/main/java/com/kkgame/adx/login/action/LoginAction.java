package com.kkgame.adx.login.action;

import java.util.Date;

import javax.servlet.http.HttpSession;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.login.service.LoginService;
import com.kkgame.adx.util.SendEmail;

public class LoginAction extends BaseAction {
	
	private SendEmail sendEmail;
	private LoginUser loginUser;
	private String id;
	private String errorMsg;
	private LoginService loginService;
	
	public String firstPage(){
		return "first";
	}
	
	public void login() {
		try {
			LoginUser result = loginService.getLoginUser(loginUser);
			if ("".equals(result) || null == result) {
				errorMsg = "Email or password invalid!";
				printMessage("-2");
				return;
			}
			int status = result.getStatus();
			if (status == 0) {
				errorMsg = "Account  is Reviewing";
				printMessage("-3");
			} else if(status == 2){
				errorMsg = "Account  is Deny";
				printMessage("-4");
			} else if(status == 3){
				errorMsg = "Account  is Lock";
				printMessage("-5");
			} else {
				this.setSession(PkigConstants.SESSION_USER, result);
				printMessage("1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}

	}
	
//
//	// 注册
//	public void register() throws IOException {
//		advertiser.setCompany(new String(advertiser.getCompany().getBytes("iso8859-1"), "UTF-8"));
//		advertiser.setName(new String(advertiser.getName().getBytes("iso8859-1"), "UTF-8"));
//		String roleType = advertiser.getRoleType();
//		if ("PB".equals(roleType)) {
//			publisherService.createPublisher(advertiser);
//		} else if ("AD".equals(roleType)) {
//			adverLoginService.create(advertiser);
//		}
//		printMessage("2");
//	}
//
	public String logout() {
		HttpSession session = getRequest().getSession();
		if (session != null) {
			session.removeAttribute(PkigConstants.SESSION_USER);
		}
		return "success";
	}
//
//	public String getRegister() {
//		return "success";
//	}
//
//	public String getMyProfile() {
//
//		HttpServletRequest request = ServletActionContext.getRequest();
//		LoginUser user = (LoginUser) request.getSession().getAttribute(PkigConstants.SESSION_USER);
//		int Id = user.getRoleId();
//		String role = user.getRoleType();
//		String id=this.getId();
//		if(id!=null){
//			advertiser = listAdvertiserService.getAdvertiserByID(Integer.valueOf(id));
//			if (advertiser != null) {
//				return "pendingShowAdvertiser";
//			} else {
//				return "false";
//			}
//		}
//		if ("AD".equals(role)) {
//			advertiser = listAdvertiserService.getAdvertiserByID(Id);
//			if (advertiser != null) {
//				return "advertiser";
//			} else {
//				return "false";
//			}
//		} else if ("PB".equals(role)) {
//			try {
//				publisher = publisherService.getPublisherByID(Id);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (publisher != null) {
//				return "publisher";
//			} else {
//				return "false";
//			}
//		} else if ("AM".equals(role) || "AMA".equals(role) || "AMP".equals(role) || "AMAM".equals(role) || "AMPM".equals(role)) {
//			employee = employeeService.getEmployeeByID(Id);
//			if (employee != null) {
//				return "employee";
//			} else {
//				return "false";
//			}
//		} else if ("SP".equals(role)) {
//			return "admin";
//		}else if ("PY".equals(role)) {
//			proxy = new Proxy();
//			proxy.setId(Id);
//			proxy=proxyService.getProxyByID(proxy);
//			return "proxy";
//		}
//		return "false";
//
//	}
//
//	public String getMyDashboard() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		LoginUser user = (LoginUser) request.getSession().getAttribute(PkigConstants.SESSION_USER);
//		int id = user.getRoleId();
//		String role = user.getRoleType();
//
//		// 获取当前月的天数
//		java.util.Calendar cal = java.util.Calendar.getInstance();
//		int maxDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		String da = sdf.format(new java.util.Date());
//		List<Object> date_list = new ArrayList<>();
//		for (int i = 1; i <= maxDay; i++) {
//			StringBuffer stringBuffer_temp = new StringBuffer();
//			stringBuffer_temp.append("'");
//			stringBuffer_temp.append(da);
//			stringBuffer_temp.append("-");
//			stringBuffer_temp.append(i);
//			stringBuffer_temp.append("'");
//			date_list.add(stringBuffer_temp);
//		}
//
//		if ("AD".equals(role)) {
//			advertiser = listAdvertiserService.getAdvertiserByID(id);
//
//			Double ba = advertiser.getBalance();
//			Double ttc=  advertiser.getTotalCost();
//			Double bt=ba-ttc;
//			DecimalFormat df = new DecimalFormat("0.00");
//			String num = df.format(bt);
//			advertiser.setBalance1(num);
//
//			Double tc = advertiser.getTodayCost();
//			DecimalFormat df1 = new DecimalFormat("0.00");
//			String num1 = df1.format(tc);
//			advertiser.setTodayCost1(num1);
//
//			Double mc = advertiser.getMonthCost();
//			DecimalFormat df2 = new DecimalFormat("0.00");
//			String num2 = df2.format(mc);
//			advertiser.setMonthCost1(num2);
//
//			List<Campaign_Stat> list = amAdvertiserService.getAm_Dashboard(id);
//			List<Object> dd_list = new ArrayList<>(maxDay);
//			List<Object> dcc_list = new ArrayList<>(maxDay);
//			List<Object> dc_list = new ArrayList<>(maxDay);
//
//			for (int i = 1; i <= maxDay; i++) {
//				dd_list.add(i);
//				dcc_list.add(0);
//				dc_list.add(0);
//			}
//
//			for (int i = 0; i < list.size(); i++) {
//				String date = list.get(i).getStatDate();
//				String date_sub = date.substring(date.length() - 2);
//				int date_int = Integer.valueOf(date_sub);
//				dcc_list.set(date_int - 1, list.get(i).getClickCount());
//				dc_list.set(date_int - 1, list.get(i).getFee());
//			}
//			advertiser.setDaily_Date(date_list);
//			advertiser.setDaily_ClickCount(dcc_list);
//			advertiser.setDaily_Cost(dc_list);
//
//			if (advertiser != null) {
//				return "advertiser";
//			} else {
//				return "false";
//			}
//		} else if ("PB".equals(role)) {
//			try {
//				publisher = publisherService.getPublisherByID(id);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			Double ba = publisher.getTodaySendRevenue();
//			DecimalFormat df = new DecimalFormat("0.00000");
//			String num = df.format(ba);
//			publisher.setTodaySendRevenueString(num);
//
//			Double tc = publisher.getMonthSendRevenue();
//			DecimalFormat df1 = new DecimalFormat("0.00000");
//			String num1 = df1.format(tc);
//			publisher.setMonthSendRevenueString(num1);
//
//			List<App_STAT> list = amPublisherService.getAm_Dashboard(id);
//
//			List<Object> dd_list = new ArrayList<>(maxDay);
//			List<Object> di_list = new ArrayList<>(maxDay);
//
//			for (int i = 1; i <= maxDay; i++) {
//				dd_list.add(i);
//				di_list.add(0);
//			}
//
//			for (int i = 0; i < list.size(); i++) {
//				String date = list.get(i).getStatDate();
//				String date_sub = date.substring(date.length() - 2);
//				int date_int = Integer.valueOf(date_sub);
//				di_list.set(date_int - 1, list.get(i).getFee());
//			}
//
//			publisher.setDaily_Date(date_list);
//			publisher.setDaily_Income(di_list);
//
//			if (publisher != null) {
//				return "publisher";
//			} else {
//				return "false";
//			}
//		} else if ("AMA".equals(role) || "AMP".equals(role) || "AMAM".equals(role) || "AM".equals(role) || "AMPM".equals(role)|| "AMAN".equals(role)) {
//			employee = employeeService.getEmployeeByID(id);
//			am_Dashboard = amEmployeeService.getAm_Dashboard(user);
//			if (employee != null) {
//				return "employee";
//			} else {
//				return "false";
//			}
//		}else if ("PY".equals(role)) {
//			proxy=new Proxy();
//			proxy.setId(id);
//			proxy=proxyService.getProxyByID(proxy);
//			am_Dashboard = amEmployeeService.getAm_Dashboard(user);
//			if (proxy != null) {
//				return "employee";
//			} else {
//				return "false";
//			}
//		} else if ("SP".equals(role)) {
//			am_Dashboard = amEmployeeService.getAm_Dashboard(user);
//			return "admin";
//		}
//		return "false";
//
//	}
//	
//	public void doResetPassword(){
//		boolean rs=false;
//		if(loginUser==null){
//			loginUser=new LoginUser();
//		}
//		try {
//			rs=adverLoginService.checkPassword(loginUser);
//			if(rs){
//					adverLoginService.resetPassword(loginUser);
//					printMessage("1");
//			}else{
//				printMessage("2");//2表示原密码错误
//			}
//		} catch (Exception e1) {
//			printMessage("-1");
//			e1.printStackTrace();
//		}
//	}
//	
//	public void doCheckEmail(){
//		HttpServletResponse response = ServletActionContext.getResponse();
//		// 设置返回数据为html文本格式
//		response.setContentType("text/html;charset=utf-8");
//		response.setHeader("pragma", "no-cache");
//		response.setHeader("cache-control", "no-cache");
//		Advertiser result = adverLoginService.checkEmail(advertiser);
//		if (result !=null) {
//			String re = "-1";
//			PrintWriter out;
//			try {
//				out = response.getWriter();
//				out.write(re);
//				out.flush();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
//
//	
//	
//	
//	// get & set 
//	public EmployeeService getEmployeeService() {
//		return employeeService;
//	}
//
//	public void setEmployeeService(EmployeeService employeeService) {
//		this.employeeService = employeeService;
//	}
//
//	public ListAdvertiserService getListAdvertiserService() {
//		return listAdvertiserService;
//	}
//
//	public void setListAdvertiserService(ListAdvertiserService listAdvertiserService) {
//		this.listAdvertiserService = listAdvertiserService;
//	}
//
//	public LoginUser getLoginUser() {
//		return loginUser;
//	}
//
//	public void setLoginUser(LoginUser loginUser) {
//		this.loginUser = loginUser;
//	}
//
//	public Advertiser getAdvertiser() {
//		return advertiser;
//	}
//
//	public void setAdvertiser(Advertiser advertiser) {
//		this.advertiser = advertiser;
//	}
//
//	public AdverLoginService getAdverLoginService() {
//		return adverLoginService;
//	}
//
//	public void setAdverLoginService(AdverLoginService adverLoginService) {
//		this.adverLoginService = adverLoginService;
//	}
//
//	public Publisher getPublisher() {
//		return publisher;
//	}
//
//	public void setPublisher(Publisher publisher) {
//		this.publisher = publisher;
//	}
//
//	public PublisherService getPublisherService() {
//		return publisherService;
//	}
//
//	public void setPublisherService(PublisherService publisherService) {
//		this.publisherService = publisherService;
//	}
//
//	public String getErrorMsg() {
//		return errorMsg;
//	}
//
//	public void setErrorMsg(String errorMsg) {
//		this.errorMsg = errorMsg;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public AmPublisherService getAmPublisherService() {
//		return amPublisherService;
//	}
//
//	public void setAmPublisherService(AmPublisherService amPublisherService) {
//		this.amPublisherService = amPublisherService;
//	}
//
//	public AmAdvertiserService getAmAdvertiserService() {
//		return amAdvertiserService;
//	}
//
//	public void setAmAdvertiserService(AmAdvertiserService amAdvertiserService) {
//		this.amAdvertiserService = amAdvertiserService;
//	}
//
//	public Am_Dashboard getAm_Dashboard() {
//		return am_Dashboard;
//	}
//
//	public void setAm_Dashboard(Am_Dashboard am_Dashboard) {
//		this.am_Dashboard = am_Dashboard;
//	}
//
//	public AmEmployeeService getAmEmployeeService() {
//		return amEmployeeService;
//	}
//
//	public void setAmEmployeeService(AmEmployeeService amEmployeeService) {
//		this.amEmployeeService = amEmployeeService;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public SendEmail getSendEmail() {
//		return sendEmail;
//	}
//
//	public void setSendEmail(SendEmail sendEmail) {
//		this.sendEmail = sendEmail;
//	}
//
//	public Proxy getProxy() {
//		return proxy;
//	}
//
//	public void setProxy(Proxy proxy) {
//		this.proxy = proxy;
//	}
//
//	public ProxyService getProxyService() {
//		return proxyService;
//	}
//
//	public void setProxyService(ProxyService proxyService) {
//		this.proxyService = proxyService;
//	}
//
//	public AdverService getAdverService() {
//		return adverService;
//	}
//
//	public void setAdverService(AdverService adverService) {
//		this.adverService = adverService;
//	}

	//get set
	public SendEmail getSendEmail() {
		return sendEmail;
	}
	public void setSendEmail(SendEmail sendEmail) {
		this.sendEmail = sendEmail;
	}
	public LoginUser getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
