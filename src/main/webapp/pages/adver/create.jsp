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
                                    <h4 class="page-title">Create Adver</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Adver
                                        </li>
                                        <li class="active">
                                            Create Adver
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-12">
                                <div class="card-box">
                                    <h4 class="m-t-0 header-title"><b>Create</b></h4>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="p-20">
                                                <form class="form-horizontal" >
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Name</label>
                                                        <div class="col-md-8">
                                                        	<input type="hidden" id="id" value="${adverVO.id }">
                                                            <input type="text" id="name" class="form-control" placeholder="Name" value='<s:property value="adverVO.name"/>'>
                                                        </div>
                                                    </div>
	                                                    <div class="form-group">
	                                                        <label class="col-md-2 control-label" for="example-email">BD</label>
	                                                        <div class="col-md-8">
	                                                        	<s:select id="amId" list="employeeList" name="adverVO.amId" listKey="id" listValue="name" cssClass="form-control select2" headerKey="0" headerValue="--All--"></s:select>
	                                                        </div>
	                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Is Cpa</label>
                                                        <div class="col-md-8">
                                                        	<s:select id="isCpa" list="#{'0':'No','1':'Yes' }" name="adverVO.isCpa" cssClass="form-control select2"></s:select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Email</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="email" class="form-control" placeholder="Email" value="${adverVO.email }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Phone</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="phone" class="form-control" placeholder="Phone" value="${adverVO.phone }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Company</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="company" class="form-control" placeholder="Company" value="${adverVO.company }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Street</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="street" class="form-control" placeholder="Street" value="${adverVO.street }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">City</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="city" class="form-control" placeholder="City" value="${adverVO.city }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">State</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="state" class="form-control" placeholder="State" value="${adverVO.state }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Zip</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="zip" class="form-control" placeholder="Zip" value="${adverVO.zip }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Skype</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="skype" class="form-control" placeholder="Skype" value="${adverVO.skype }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">QQ</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="qq" class="form-control" placeholder="QQ" value="${adverVO.qq }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Password</label>
                                                        <div class="col-md-8">
                                                            <input type="text" id="password" class="form-control" placeholder="Password" value="${adverVO.password }">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Country</label>
                                                        <div class="col-md-8">
                                                        	<s:select id="countryId" list="countryList" listKey="id" listValue="name" name="adverVO.countryId" cssClass="form-control select2" headerKey="0" headerValue="--All--"></s:select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Description</label>
                                                        <div class="col-md-8">
                                                        <textarea id="desc" class="form-control" rows="4">${adverVO.desc }</textarea>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group" style="text-align: center;">
														<button type="button" class="btn btn-custom waves-light waves-effect w-md" onclick="submitAdver()">Submit</button>
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
$("#menu-3,#menu-3 a").addClass("active");
$("#menu-3 ul").addClass("in");
$("#menu-3-2,#menu-3-2 a").addClass("active");
$(".select2").select2();
function submitAdver(){
	var name = $("#name").val();
	if (name == "") {
		showMiddle("Name cannot be empty!");
		$("#name").focus();
		return;
	}
	var amId = 0;
	amId = $("#amId").val();
	if (amId == 0 && amId != undefined) {
		showMiddle("Please choose a BD!");
		$("#amId").focus();
		return;
	}
	var isCpa = $("#isCpa").val();
	var email = $("#email").val();
	if (email=="") {
		showMiddle("Email cannot be empty!");
		$("#email").focus();
		return;
	}else{
    	var checkMail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    	if(!checkMail.test(email)){
    		showMiddle("Invalid email！");
    		$("#email").focus();
    		return ;
    	}
    }
	var phone = $("#phone").val();
	if (phone == "") {
		showMiddle("Phone cannot be empty!");
		$("#phone").focus();
		return;
	}
	var company = $("#company").val();
	if (company == "") {
		showMiddle("Company cannot be empty!");
		$("#company").focus();
		return;
	}
	var street = $("#street").val();
	var city = $("#city").val();
	var state = $("#state").val();
	var zip = $("#zip").val();
	var skype = $("#skype").val();
	var qq = $("#qq").val();
	var password = $("#password").val();
	if (password == "" || password.length < 6) {
		showMiddle("Please enter no less than 6 password!");
		$("#password").focus();
		return;
	}
	var countryId = $("#countryId").val();
	if (countryId == 0) {
		showMiddle("Please choose a country!");
		$("#countryId").focus();
		return;
	}
	var desc = $("#desc").val();
	var id = $("#id").val();
	var url = "<%=request.getContextPath()%>/adver/save";
	jQuery.post(url,{"adverVO.id":id,"adverVO.amId":amId,"adverVO.isCpa":isCpa,"adverVO.email":email,"adverVO.phone":phone,"adverVO.name":name,
					"adverVO.company":company,"adverVO.street":street,"adverVO.city":city,"adverVO.state":state,"adverVO.zip":zip,
					"adverVO.skype":skype,"adverVO.qq":qq,"adverVO.password":password,"adverVO.countryId":countryId,"adverVO.desc":desc
	},function(response){
		if (response == "-1") {
			showMiddle("Error!");
		}else{
			setTimeout(function(){
	   			if ("insert" == response) {
		    		window.location.href= "<%=request.getContextPath()%>/adver/query";
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