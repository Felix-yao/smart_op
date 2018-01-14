<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:bean id="Option" name="com.kkgame.adx.tag.action.Option"/>
<%-- <%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    
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
                                    <h4 class="page-title"><s:if test="employee.id > 0">Update Employee</s:if>
                                        	<s:else>Create Employee</s:else></h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Employee
                                        </li>
                                        <li class="active">
                                        	<s:if test="employee.id > 0">Update Employee</s:if>
                                        	<s:else>Create Employee</s:else>
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-12">
                                <div class="card-box">
                                    <h4 class="m-t-0 header-title"><b><s:if test="employee.id > 0">Update</s:if>
                                        	<s:else>Create</s:else></b></h4>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="p-20">
                                                <form class="form-horizontal" >
													<div class="form-group">
														<label class="col-md-2 control-label">Role Type</label>
														<div class="col-md-8">
															<input type="hidden" id="id" value="${employee.id }">
	                                                        <s:select id="roleType" list="#{'AMA':'BD','AMP':'AM','AM':'OP' }" name="employee.roleType" cssClass="form-control select2" headerKey="" headerValue="--All--"></s:select>
	                                                    </div>
													</div>
													<div class="form-group" style="display:none;" id = "proxyDiv">
														<label class="col-md-2 control-label">Agent</label>
														<div class="col-md-8">
	                                                        <s:select id="proxyId" list="agentList" name="employee.proxyId" listKey="id" listValue="name" cssClass="form-control select2" headerKey="0" headerValue="--All--"></s:select>
	                                                    </div>
													</div>
                                                    <div class="form-group">
														<label class="col-md-2 control-label">Name</label>
														<div class="col-md-8">
															<input type="text" class="form-control input-inline input-medium"
																id="name" name="employee.name" placeholder="Name" value="${employee.name }">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Email</label>
														<div class="col-md-8">
															<input type="text" class="form-control input-inline input-medium"
																id="email" name="employee.email" placeholder="Email" value="${employee.email }"<s:if test="employee.id>0">style="cursor:default;" disabled</s:if>>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Password</label>
														<div class="col-md-8">
															<input type="text" id="password"
																class="form-control input-inline input-medium"
																name="employee.password" placeholder="Password" value="${employee.password }">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Phone</label>
														<div class="col-md-8">
															<input type="text" id="phone"
																class="form-control input-inline input-medium"
																name="employee.phone" placeholder="Phone" value="${employee.phone }">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Skype</label>
														<div class="col-md-8">
															<input type="text" id="skype"
																class="form-control input-inline input-medium"
																name="employee.skype" placeholder="Skype" value="${employee.skype }"> 
														</div>
													</div>
													<span class="help-inline"></span>
													<div class="form-group">
														<label class="col-md-2 control-label">QQ</label>
														<div class="col-md-8">
															<input type="text" id="qq"
																class="form-control input-inline input-medium" name="employee.qq"
																placeholder="QQ" value="${employee.qq }"> 
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">JobTitle</label>
														<div class="col-md-8">
															<input type="text" id="jobTitle" class="form-control input-inline input-medium"
																name="employee.jobTitle" placeholder="JobTitle" value="${employee.jobTitle }">
														</div>
													</div>
                                                    <div class="form-group" style="text-align: center;">
														<button type="button" id="submit" class="btn btn-custom waves-light waves-effect w-md" onclick="submitEmployee()">Submit</button>
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
<script type="text/javascript">
$("#menu-1,#menu-1 a").addClass("active");
$("#menu-1 ul").addClass("in");
$("#menu-1-2,#menu-1-2 a").addClass("active");
$(".select2").select2();
$(function(){
	var roleTypeWin = $("#roleType").val();
	var idWin = $("#id").val();
	if (idWin > 0) {
		$("#roleType").attr("disabled","disabled");
	}
	if (roleTypeWin == "AMP") {
		$("#proxyDiv").show();
	}
})
function submitEmployee(){
	var id=$("#id").val();
	var name=$('#name').val();
	var email=$('#email').val();
	var phone=$('#phone').val();
	var skype=$('#skype').val();
	var qq=$('#qq').val();
	var password=$('#password').val();
	var roleType=$("#roleType").val();
	var jobTitle=$("#jobTitle").val();
	var proxyId=$("#proxyId").val();
	if(name==""){
		showMiddle("Name Cannot Be Empty");
    	$("#name").focus();
        return false;
	}else if(email==""){
		showMiddle("Email Cannot Be Empty");
    	$("#email").focus();
        return false;
	}else if(phone==""){
		showMiddle("Phone Cannot Be Empty");
    	$("#phone").focus();
        return false;
	}else if(skype==""){
		showMiddle("Skype Cannot Be Empty");
    	$("#skype").focus();
        return false;
	}else if(qq==""){
		showMiddle("QQ Cannot Be Empty");
    	$("#qq").focus();
        return false;
	}else if(password==""){
		showMiddle("Password Cannot Be Empty");
    	$("#password").focus();
        return false;
	}
	if (roleType == "AMP") {
		if (proxyId == 0) {
			showMiddle("Please choose an Agent");
	    	$("#proxyId").focus();
	        return false;
		}
	}
	
    var  re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    if(!re.test(email)){
        showMiddle("Pease check your email !");
        $("#email").focus();
        return false;
    }
	$('#submit').attr("disabled",true);
	var url = "<%=request.getContextPath()%>/employee/save";
	jQuery.post(url,{"employee.id":id,"employee.name":name,"employee.roleType":roleType,
		"employee.email":email,"employee.password":password,"employee.phone":phone,
		"employee.skype":skype,"employee.qq":qq,"employee.jobTitle":jobTitle
	},function(response){
		if (response == "-1") {
			showMiddle("Error!");
		}else{
			setTimeout(function(){
	   			if ("1" == response) {
		    		window.location.href= "<%=request.getContextPath()%>/employee/query";
				} else {
					history.go(-1);
				}
	   		},500);
		}
	})
}
$("#roleType").change(function(){
	var roleType = $("#roleType").val();
	if (roleType == "AMP") {
		$("#proxyDiv").show();
	}else{
		$("#proxyDiv").hide();
	}
})
</script>

</body>
</html>