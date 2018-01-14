<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:bean id="Option" name="com.kkgame.adx.tag.action.Option"/>
<%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/datepicker3.css">
</head>
<body>
 <!-- Begin page -->
 <div id="wrapper">
 
    <%@ include file="/pages/main/main.jsp" %> 
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="page-title-box">
                                    <h4 class="page-title">Dsp Report</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Report
                                        </li>
                                        <li class="active">
                                            Dsp Report
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box table-responsive" style="height:auto;">
                                    <h4 class="m-t-0 header-title"><b>search</b></h4>
                                    <div class="row">
			                            <div class="col-sm-12" style="width: 80%;padding-left: 20%;">
			                                <form class="form-horizontal">
			                                    <div class="form-group">
			                                        <label for="exampleInputName2" class="col-md-3 control-label">Date</label>
			                                        <div class="col-md-8">
				                                        <div class="form-control" style="padding:0">
									                  		<div style="width:46%;float:left;height:100%;">
										                  		<input type="text" name="billSearchVO.startTime" id="startDate" readonly="true" style="padding-left:10px;border-radius: 0;width:100%;height:100%;border:1px solid #d2d6de;border-bottom:none;border-top:none;border-left:none;">
									                  		</div>
									                  		<span style="float:left;height:100%;padding-top:7px;background-color: #64c5b1 !important;color:white;">
															   &nbsp;  &nbsp;to&nbsp; &nbsp; 
									                  		</span>
									                  		<div style="overflow:hidden;height:100%;">
															<input type="text" name="billSearchVO.endTime" id="endDate" readonly="true" style="padding-left:10px;border-radius: 0;width:100%;height:100%;border:1px solid #d2d6de;border-bottom:none;border-top:none;border-right:none;">		
									                  		</div>
									                  	</div>
			                                        </div>
			                                    </div>
			                                    <div class="form-group">
			                                        <label for="exampleInputEmail2" class="col-md-3 control-label">Country</label>
			                                        <div class="col-md-8">
			                                        	<s:select id="countryId" list="countryList" listKey="id" listValue="name" cssClass="form-control select2" headerKey="0" headerValue="--All--" ></s:select>
			                                        </div>
			                                    </div>
			                                    <role:RoleEqual roleName="SP,AM,AMA">
				                                    <div class="form-group">
				                                        <label for="exampleInputEmail2" class="col-md-3 control-label">DSP</label>
				                                        <div class="col-md-8">
				                                        	<s:select id="dspId" list="dspList" listKey="id" listValue="name" cssClass="form-control select2" headerKey="0" headerValue="--All--" ></s:select>
				                                        </div>
				                                    </div>
			                                    </role:RoleEqual>
			                                    <div class="form-group">
			                                        <label for="exampleInputEmail2" class="col-md-3 control-label">Type</label>
			                                        <div class="col-md-8">
			                                        	<s:select id="offerType" list="#Option.offerCategory" listKey="key" listValue="value" cssClass="form-control select2" headerKey="0" headerValue="--All--" ></s:select>
			                                        </div>
			                                    </div>
			                                    <div class="form-group">
			                                        <label for="exampleInputEmail2" class="col-md-3 control-label">Width</label>
			                                        <div class="col-md-8">
			                                        	<s:select id="width" list="#{'300':'300','320':'320'}" cssClass="form-control select2" headerKey="0" headerValue="--All--" ></s:select>
			                                        </div>
			                                    </div>
			                                    <div class="form-group">
			                                        <label for="exampleInputEmail2" class="col-md-3 control-label">Height</label>
			                                        <div class="col-md-8">
			                                        	<s:select id="height" list="#{'50':'50','250':'250','480':'480'}" cssClass="form-control select2" headerKey="0" headerValue="--All--" ></s:select>
			                                        </div>
			                                    </div>
			                                    <div class="form-group">
			                                        <label for="exampleInputEmail2" class="col-md-3 control-label">Rows</label>
			                                        <div class="col-md-9 form-inline" style="padding-left:0;">
					                                   <div class="checkbox checkbox-custom checkbox-circle">
		                                                    <input id="datebox" type="checkbox" checked="checked" name="dspdataVO.rowFields" value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_DATE"/>">
		                                                    <label for="datebox">
		                                                        Date
		                                                    </label>
		                                                </div>
					                                   <div class="checkbox checkbox-custom checkbox-circle">
		                                                    <input id="countrybox" type="checkbox" name="dspdataVO.rowFields" value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_COUNTRY"/>">
		                                                    <label for="countrybox">
		                                                        Country
		                                                    </label>
		                                                </div>
		                                                <role:RoleEqual roleName="SP,AM,AMA">
					                                   <div class="checkbox checkbox-custom checkbox-circle">
		                                                    <input id="dspbox" type="checkbox" name="dspdataVO.rowFields" value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_DSP"/>">
		                                                    <label for="dspbox">
		                                                        DSP
		                                                    </label>
		                                                </div>
		                                                </role:RoleEqual>
					                                   <div class="checkbox checkbox-custom checkbox-circle">
		                                                    <input id="typebox" type="checkbox" name="dspdataVO.rowFields" value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_TYPE"/>">
		                                                    <label for="typebox">
		                                                        Type
		                                                    </label>
		                                                </div>
					                                   <div class="checkbox checkbox-custom checkbox-circle">
		                                                    <input id="widthbox" type="checkbox" name="dspdataVO.rowFields" value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_WIDTH"/>">
		                                                    <label for="widthbox">
		                                                        Width
		                                                    </label>
		                                                </div>
					                                   <div class="checkbox checkbox-custom checkbox-circle">
		                                                    <input id="heightbox" type="checkbox" name="dspdataVO.rowFields" value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_HEIGHT"/>">
		                                                    <label for="heightbox">
		                                                        Height
		                                                    </label>
		                                                </div>
			                                        </div>
			                                    </div>
                                                <div class="form-group" style="text-align: center;">
                                                    <button type="button" onclick="search()" class="btn btn-custom waves-light waves-effect btn-md">
	                                                   search
	                                                </button>
                                                    <button type="button" onclick="resetForm()" class="btn btn-default waves-effect btn-md">
	                                                   reset
	                                                </button>
                                                </div>
			                                    
			                                </form>
			                            </div>
			                        </div>
                                </div>
                            </div>
                        </div>
                        <!-- datatable -->
						<div class="row" id="dataList">
							
						</div>
									
                        
                        
                        <!-- ä¸­å¿åå®¹  end-->
                    </div> <!-- container -->
                </div> <!-- content -->
            </div>
</div>
<script src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
$("#menu-5,#menu-5 a").addClass("active");
$("#menu-5 ul").addClass("in");
$("#menu-5-1,#menu-5-1 a").addClass("active");
$(function(){
	$(".select2").select2();
	var dateNow = getNowFormatDate();
	$('#endDate,#startDate').datepicker({
	      autoclose: true,
	  	  format:'yyyy-mm-dd',
	      setDate:dateNow
	    });
	$("#endDate,#startDate").datepicker("setDate", dateNow);
})
function search(){
	var url = "<%=request.getContextPath()%>/data/dsplist";
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var dspId = 0
	<role:RoleEqual roleName="SP,AM,AMA">
		dspId=$("#dspId").val();
	</role:RoleEqual>
	var countryId=$("#countryId").val();
	var type = $("#type").val();
	var size = $("#size").val();
	var chk_value="";
  	$('input[name="dspdataVO.rowFields"]:checked').each(function(){ 
   		chk_value+=$(this).val();
   		chk_value+=",";
  	});
  	if(chk_value=="") {
  		showInfoToastMiddle("rows invalid！");
		return false;
  	} 
	jQuery("#dataList").html("");
	jQuery.post(url,{"dspDataVO.rowFielString":chk_value},
	function(response){
		if(response=="-1") {
			showInfoToastMiddle("error","system error");				
		} else {
			jQuery("#dataList").html(jQuery.trim(response));
		}			
	});
}
function resetForm(){
	var dateNow = getNowFormatDate();
	$("#endDate,#startDate").datepicker("setDate", dateNow);
}
var  banner = new Array();
<s:iterator value="#Option.offerSize" status="stat"  >
	var str = new Array();
	str.push('<s:property value="key"/>');
	str.push('<s:property value="value" escape="false"/>');
	banner.push(str);
</s:iterator>
$("#offerType").change(function(){
	var offer_offerType = $("#offerType").val();
	var offer_size = document.getElementById("size");
 	$("#size").val("0");
 	removeOptions(offer_size);
	if(offer_offerType==1) {
		offer_size.options[0] = new Option("--All--",0);
		var index = 0;
		for(var i=0;i<banner.length;i++){
			index +=1;
			offer_size.options[index] = new Option(banner[i][1],banner[i][0]);
		}
	} else {
		offer_size.options[0] = new Option("--All--",0);
		//将id置为 0		
	}
}) 

function removeOptions(form){
	if(form.options.length>0){
		for(var i=(form.options.length-1);i>=0;i--){
			var o=form.options[i];
			form.options[i] = null;
		}	
	}
}
</script>
</body>
</html>