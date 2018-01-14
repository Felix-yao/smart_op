package com.kkgame.adx.tag.action;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.tag.bean.UserVO;
import com.kkgame.adx.util.CheckUtilities;

@SuppressWarnings("serial")
public class RoleEqualTag extends BodyTagSupport {
	/**
	Tag.EVAL_BODY_INCLUDE 包含主体内容
    Tag.SKIP_BODY     不包含主体内容
    Tag.EVAL_PAGE      包含后面的页面内容 
    Tag.SKIP_PAGE     不包含主体的内容 
	**/
	
	private String roleName;
	
	@Override
	public int doStartTag() throws JspException {
		HttpSession session = this.pageContext.getSession();
		if(CheckUtilities.isEmptyString(roleName)){
			return SKIP_BODY;
		}
		LoginUser us = (LoginUser)session.getAttribute(PkigConstants.SESSION_USER);
		if(us == null){
			return SKIP_BODY;
		}
		String[] roles = this.roleName.split(",");
		boolean flag = false; 
		for(String role:roles) {
			if(role.equals(us.getRoleType())) {
				flag = true;
			}
		}		
		if(flag){
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}