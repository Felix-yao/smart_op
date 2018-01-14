<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<option value="0">
	-- Am--
</option>
<s:iterator value="amList" status="stat">
<option value="${id}">
	${name}
</option>
</s:iterator>