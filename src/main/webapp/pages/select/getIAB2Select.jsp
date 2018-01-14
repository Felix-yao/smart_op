<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<option value="0">
	-- IAB2 --
</option>
<s:iterator value="iab1List" status="stat">
<option value="${name1}">
	${name}
</option>
</s:iterator>