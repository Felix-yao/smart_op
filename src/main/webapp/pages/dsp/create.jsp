<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:bean id="Option" name="com.kkgame.adx.tag.action.Option"/>
<%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%>
<%-- <%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
<%--     <link href="<%=request.getContextPath()%>/css/select2.min.css" rel="stylesheet" type="text/css" /> --%>
<%--     <link href="<%=request.getContextPath()%>/css/bootstrap-tagsinput.css" rel="stylesheet" /> --%>
<%--     <link href="<%=request.getContextPath()%>/css/bootstrap-select.min.css" rel="stylesheet" /> --%>
    
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
                                    <h4 class="page-title"><s:if test="dspVO.id > 0">Update Dsp</s:if>
                                        	<s:else>Create Dsp</s:else></h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Dsp
                                        </li>
                                        <li class="active">
                                        	<s:if test="dspVO.id > 0">Update Dsp</s:if>
                                        	<s:else>Create Dsp</s:else>
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-12">
                                <div class="card-box">
                                    <h4 class="m-t-0 header-title"><b><s:if test="dspVO.id > 0">Update</s:if>
                                        	<s:else>Create</s:else></b></h4>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="p-20">
                                                <form class="form-horizontal" >
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Name</label>
                                                        <div class="col-md-8">
                                                        	<input type="hidden" id="id" value="${dspVO.id }">
                                                            <input type="text" id="name" class="form-control" placeholder="Name" value="${dspVO.name }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Company</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="company" class="form-control" placeholder="Company" value="${dspVO.company }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Email</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="email" class="form-control" placeholder="Email" value="${dspVO.email }" <s:if test="dspVO.id > 0">style="cursor:default;" disabled</s:if>>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Password</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="password" class="form-control" placeholder="Password" value="${dspVO.password }" >
                                                        </div>
                                                    </div>
                                                    <role:RoleEqual roleName="SP,AM">
	                                                    <div class="form-group">
	                                                        <label class="col-md-2 control-label" for="example-email">BD</label>
	                                                        <div class="col-md-8">
	                                                        	<s:select id="bdId" list="employeeList" name="dspVO.employeeId" listKey="id" listValue="name" cssClass="form-control select2" headerKey="0" headerValue="--All--" ></s:select>
	                                                        </div>
	                                                    </div>
	                                                </role:RoleEqual>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Bid Mode</label>
                                                        <div class="col-md-8">
                                                        	<s:select id="priceMethod" list="#{'1':'CPC','2':'CPM' }" name="dspVO.priceMethod" cssClass="form-control select2" headerKey="0" headerValue="--All--"></s:select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Type</label>
                                                        <div class="col-md-8">
                                                        	<div style="float:left;width:49%">
	                                                        	<select id="adType" name="dspVO.adType" class="form-control select2" multiple="multiple"  data-placeholder="--All--">
	                                                        		<option value="0">--All--</option>
	                                                        		<option value="1">Banner</option>
	                                                        	</select>
                                                        	</div>
                                                        	<div style="float:right;width:49%">
	                                                        	<select id="size" name="dspVO.size" class="form-control select2" multiple="multiple"  data-placeholder="--All--">
	                                                        		<option value="0">--All--</option>
	                                                        	</select>
                                                        	</div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Country</label>
                                                        <div class="col-md-8">
                                                        	<select id="countryIds" class="form-control select2" name="dspVO.countryIds" multiple="multiple" data-placeholder="--All--">
                                                        		 <s:action name="getAllCountry" namespace="/system"  executeResult="true">
                                                               </s:action>
                                                        	</select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group" style="text-align: center;">
														<button type="button" class="btn btn-custom waves-light waves-effect w-md" onclick="submitDsp()">Submit</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                </div>

                        </div>
                    </div> <!-- container -->
                </div> <!-- content -->
            </div>
    	 </div>
     </div>       
</div>
<script src="<%=request.getContextPath()%>/js/select2.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-tagsinput.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-select.min.js" type="text/javascript"></script>
<script type="text/javascript">
$("#menu-2,#menu-2 a").addClass("active");
$("#menu-2 ul").addClass("in");
$("#menu-2-2,#menu-2-2 a").addClass("active");
$(".select2").select2();
$('#countryIds,#adType').find('option[value=0]').attr('disabled', true);
var  banner = new Array();
<s:iterator value="#Option.offerSize" status="stat"  >
	var str = new Array();
	str.push('<s:property value="key"/>');
	str.push('<s:property value="value" escape="false"/>');
	banner.push(str);
</s:iterator>


var adTypeselect2 = $("#adType").select2();
var adTypeValue = '<s:property value="dspVO.adType"/>';
var adTypedata = adTypeValue.split(",");
adTypeselect2.val(adTypedata).trigger("change");

//var offer_size = '<s:property value="dspVO.size"/>';
//$("#size").val(size);

changeOfferType();
function changeOfferType(){
	var offer_adType = $("#adType").val();
	var offer_size = document.getElementById("size");
 	$("#size").val("0");
 	removeOptions(offer_size);
	if(offer_adType==1) {
		offer_size.options[0] = new Option("----",0);
		var index = 0;
		for(var i=0;i<banner.length;i++){
			index +=1;
			offer_size.options[index] = new Option(banner[i][1],banner[i][0]);
		}
	} else {
		offer_size.options[0] = new Option("----",0);
		//将id置为 0		
	}
	$("#size").find('option[value=0]').attr('disabled', true);
	
	if ($("#id").val() > 0) {
		var sizeselect2 = $("#size").select2();
		var sizeValue = '<s:property value="dspVO.size"/>';
		var sizedata = sizeValue.split(",");
		sizeselect2.val(sizedata).trigger("change");

	}
}
var countryselect2 = $("#countryIds").select2();
var conIds = '<s:property value="dspVO.countryIds"/>';
var data = conIds.split(",");
countryselect2.val(data).trigger("change");

function removeOptions(form){
	if(form.options.length>0){
		for(var i=(form.options.length-1);i>=0;i--){
			var o=form.options[i];
			form.options[i] = null;
		}	
	}
}
$("#adType").change(function(){
	changeOfferType();
})
function updateValue() {
	var adType = '<s:property value="dspVO.adType"/>';
	var size = '<s:property value="dspVO.size"/>';
	$("#adType").val(adType);
	changeOfferType();
	$("#size").val(size);
}
//updateValue();
function submitDsp(){
	var name = $("#name").val();
	if (name == "") {
		showMiddle("Name cannot be empty!");
		$("#name").focus();
		return;
	}
	var company = $("#company").val();
	if (company == "") {
		showMiddle("Company cannot be empty!");
		$("#company").focus();
		return;
	}
	var employeeId = 0;
	var email = $("#email").val();
	var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    if(!re.test(email)){
        showMiddle("Pease check your email !");
        $("#email").focus();
        return false;
    }
    var password = $("#password").val();
    if (password.length < 6) {
        showMiddle("Please enter no less than 6 password!");
        $("#password").focus();
        return false;
	}
	<role:RoleEqual roleName="SP,AM">
	employeeId = $("#bdId").val();
	if (employeeId == 0 && employeeId != undefined) {
		showMiddle("Please choose a BD!");
		$("#employeeId").focus();
		return;
	}
	</role:RoleEqual>
	var priceMethod = $("#priceMethod").val();
	if (priceMethod == 0) {
		showMiddle("Please choose a Bid Mode!");
		$("#priceMethod").focus();
		return;
	}
	var adType = $("#adType").val();
	var selectAdType = ",";
	if (adType == 0) {
		showMiddle("Please choose a Type!");
		$("#adType").focus();
		return;
	}else{
		for(var i=0;i<adType.length;i++) {
			if (adType[i] != 0) {
				selectAdType+=adType[i]+",";
			}
		}
	}
	var size = $("#size").val();
	var selectSize = ",";
	if (size == 0) {
		showMiddle("Please choose a size!");
		$("#size").focus();
		return;
	}else{
		for(var i=0;i<size.length;i++) {
			if (size[i] != 0) {
				selectSize+=size[i]+",";
			}
		}
	}
	var selectCountryIds = ",";
	var countryIds = $("#countryIds").val();
	if (countryIds == null) {
		showMiddle("Please choose a country!");
		$("#countryIds").focus();
		return;
	}else{
		if (countryIds.length == 1 && countryIds[0] == 0) {
			showMiddle("Please choose a country!");
			$("#countryIds").focus();
			return;
		}else{
			for(var i=0;i<countryIds.length;i++) {
				if (countryIds[i] != 0) {
					selectCountryIds+=countryIds[i]+",";
				}
			}
		}
	}
	var id = $("#id").val();
	var url = "<%=request.getContextPath()%>/dsp/save";
	jQuery.post(url,{"dspVO.id":id,"dspVO.company":company,"dspVO.employeeId":employeeId,
				"dspVO.priceMethod":priceMethod,"dspVO.adType":selectAdType,"dspVO.size":selectSize,
				"dspVO.countryIds":selectCountryIds,"dspVO.name":name,"dspVO.email":email,"dspVO.password":password
	},function(response){
		if (response == "-1") {
			showMiddle("Error!");
		}else{
			setTimeout(function(){
	   			if ("1" == response) {
		    		window.location.href= "<%=request.getContextPath()%>/dsp/query";
				} else {
					history.go(-1);
				}
	   		},500);
		}
	})
}
</script>

</body>
</html>