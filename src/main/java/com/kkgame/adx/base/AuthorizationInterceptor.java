package com.kkgame.adx.base;

import org.apache.struts2.ServletActionContext;

import com.kkgame.adx.login.action.LoginAction;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.tag.action.SystemAction;
import com.kkgame.adx.util.CalendarFormat;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//import com.kkgame.feeop.user.action.LoginAction;
//import com.kkgame.feeop.user.bean.UserVO;
//import com.kkgame.feeop.util.CalendarFormat;

/**
 * 登陆超时INTECEPTOR
 * @author rayi
 *
 */
@SuppressWarnings("serial")
public class AuthorizationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Object action = arg0.getAction();
		if(action instanceof LoginAction) {
			return arg0.invoke();
		}
		if(action instanceof SystemAction) {
			return arg0.invoke();
		}
		LoginUser userVO = null;
		javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
		if(null!=session) {
			userVO = (LoginUser) session.getAttribute(PkigConstants.SESSION_USER);
		}
		if(null != userVO) {
			if(!PkigConstants.ONLINE_USER.containsKey(userVO.getEmail())) {
				PkigConstants.ONLINE_USER.put(userVO.getEmail(), CalendarFormat.getNow());
			}
			return arg0.invoke();
		}else {
			return "loginout";
		}
	}
}
