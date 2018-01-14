<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<option value="0">
	-- Country--
</option>
<s:iterator value="countryList" status="stat">
<option value="${id}">
	${name}
</option>
</s:iterator>