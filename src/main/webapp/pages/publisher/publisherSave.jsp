<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <style type="text/css">
        .form-horizontal .form-group {
            margin-left: 100px !important;
        }
    </style>
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
                                    <h4 class="page-title"><s:if test="publisherVO.id>0">Update</s:if><s:else>Create</s:else> Publisher</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Publisher
                                        </li>
                                        <li class="active">
                                            <s:if test="publisherVO.id>0">Update</s:if><s:else>Create</s:else> Publisher
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- 中心内容  end-->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box">
                                    <h4 class="m-t-0 header-title"><b><s:if test="publisherVO.id>0">Update</s:if><s:else>Create</s:else></b></h4>
                                    <p class="text-muted m-b-30 font-14">
                                    </p>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="p-20">
                                                <form class="form-horizontal" role="form">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Name</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="name" class="form-control" placeholder="Name"
                                                            value='<s:property value="publisherVO.name"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <role:RoleEqual roleName="SP,AM,PY">
	                                                    <div class="form-group">
	                                                        <label class="col-md-2 control-label">AM</label>
	                                                        <div class="col-md-4">
	                                                            <select id="amId" class="form-control select2"
	                                                                name="publisherVO.amId" >
	                                                                <s:action name="getAllAm" namespace="/system"
	                                                                    executeResult="true">
	                                                                    <s:param name="nameVO.type">1</s:param>
	                                                                </s:action>
	                                                            </select>
	                                                        </div>
	                                                    </div>
                                                    </role:RoleEqual>
                                                    
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Email</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="email" name="example-email" class="form-control" 
                                                            placeholder="Email" value='<s:property value="publisherVO.email"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')" >
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Password</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="password" class="form-control" placeholder="Password"
                                                            value='<s:property value="publisherVO.password"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Phone</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="phone" class="form-control" placeholder="Phone"
                                                            value='<s:property value="publisherVO.phone"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Company</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="company" class="form-control" placeholder="Company"
                                                            value='<s:property value="publisherVO.company"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Country</label>
                                                        <div class="col-md-4">
                                                           <select id="countryId" class="form-control input-inline input-medium"
                                                               name="publisherVO.countryId">
                                                               <s:action name="getAllCountry" namespace="/system"
                                                                  executeResult="true">
                                                               </s:action>
                                                           </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Street</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="street" class="form-control" placeholder="Street"
                                                            value='<s:property value="publisherVO.street"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">City</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="city" class="form-control" placeholder="City"
                                                            value='<s:property value="publisherVO.city"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">State</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="state" class="form-control" placeholder="State"
                                                            value='<s:property value="publisherVO.state"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Zip</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="zip" class="form-control" placeholder="Zip"
                                                            value='<s:property value="publisherVO.zip"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Skype</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="skype" class="form-control" placeholder="Skype"
                                                            value='<s:property value="publisherVO.skype"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">QQ</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="qq" class="form-control" placeholder="QQ"
                                                            value='<s:property value="publisherVO.qq"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">PostBack</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="postBack" class="form-control" placeholder="PostBack"
                                                            value='<s:property value="publisherVO.postBack"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <role:RoleEqual roleName="AM,SP">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">PricePercent</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="pricePercent" class="form-control" placeholder="PricePercent"
                                                            value='<s:property value="publisherVO.pricePercent"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    </role:RoleEqual>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Description</label>
                                                        <div class="col-md-4">
                                                            <textarea class="form-control" id="desc" rows="5" onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')"><s:property value="publisherVO.desc"/></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label"></label>
                                                        <div class="col-md-4">
                                                            <button class="btn btn-primary waves-effect waves-light" 
                                                                    type="button" onclick="savePublisher()">Submit
                                                            </button>
                                                            <a type="button" class="btn btn-default waves-effect m-l-5"
                                                                    href="<%=request.getContextPath()%>/publisher/publisher!publisherListPage">
                                                                Cancel
                                                            </a>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end row -->
                                </div> <!-- end card-box -->
                            </div><!-- end col -->
                        </div>
                        <!-- end row -->
                        <!-- 中心内容  end-->
                </div> <!-- content -->
            </div>
</div>
<script type="text/javascript">
    $("#menu-4,#menu-4 a").addClass("active");
    $("#menu-4 ul").addClass("in");
</script>

<script type="text/javascript">

    $("#amId").select2();
    $("#countryId").select2();
    
    var id          =   "<s:property value="publisherVO.id"/>";
    debugger
    if(id>0){
	    var countryId   =   "<s:property value="publisherVO.countryId"/>";
	    var amId        =   "<s:property value="publisherVO.amId"/>";
	    $("#countryId").val(countryId).trigger("change");
	    $("#amId").val(amId).trigger("change");
    }
  
    function savePublisher(){
    	debugger
        var countryId   =   $('#countryId').val();
        var name        =   $('#name').val();
        var amId        =   0;
        <role:RoleEqual roleName="SP,AM,PY">
        	$('#amId').val();
        </role:RoleEqual>
        var email       =   $('#email').val();
        var password    =   $('#password').val();
        var phone       =   $('#phone').val();
        var company     =   $('#company').val();
        var street      =   $('#street').val();
        var city        =   $('#city').val();
        var state       =   $('#state').val();
        var zip         =   $('#zip').val();
        var skype       =   $('#skype').val();
        var qq          =   $('#qq').val();
        var desc        =   $('#desc').val();
        var postBack    =$('#postBack').val();
        var pricePercent =$("#pricePercent").val();
        
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
        }else if(company==""){
            showMiddle("Company Cannot Be Empty");
            $("#company").focus();
            return false;
        }else if(password==""){
            showMiddle("Password Cannot Be Empty");
            $("#password").focus();
            return false;
        }
        
        <role:RoleEqual roleName="AM,SP">
        var reg_0_100 = /^(?:0|[1-9][0-9]?|100)$/;//1-100的正整数验证
        if(!reg_0_100.test(pricePercent) && typeof(pricePercent) != "undefined"){ //判断输入的是否是1-100的正整数
            showMiddle("Please enter a 0-100 positive integer");
            $("#pricePercent").focus();
            return;
        }
        </role:RoleEqual>
        
        if(typeof(pricePercent) == "undefined"){
        	pricePercent = 0;
        }
        
        $('#submit').attr("disabled",true);
        
        var url =   "<%=request.getContextPath()%>/publisher/publisher!publisherSave";
        $.post(url,
        		{"publisherVO.id":id,             "publisherVO.name":name,        "publisherVO.amId":amId,        "publisherVO.email":email, 
                 "publisherVO.password":password, "publisherVO.phone":phone,      "publisherVO.company":company,  "publisherVO.countryId":countryId,
                 "publisherVO.street":street,     "publisherVO.city":city,        "publisherVO.state":state,      "publisherVO.zip":zip,
                 "publisherVO.skype":skype,       "publisherVO.qq":qq,            "publisherVO.postBack":postBack,"publisherVO.pricePercent":pricePercent,
                 "publisherVO.desc":desc},
            function(response){
            if(response==-1){
                showMiddle("System Error");
            }else{
                showMiddle("Success");
                $('#submit').attr("disabled",false);
            }
        })
    }
    
//     function backToList(){
<%--     	post('<%=request.getContextPath()%>/pages/publisher/', {}); --%>
//     }
    
</script>
</body>
</html>