<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="form-group">
    <label class="col-md-2 control-label">快递单号</label>
    <div class="col-md-8">
        <input type="text" id="logisticsNumber" class="form-control" placeholder="快递单号" value='<s:property value="silverVO.logisticsNumber"/>'>
        <input id="silverVOId" type="hidden" value='<s:property value="silverVO.id"/>'>
    </div>
</div>