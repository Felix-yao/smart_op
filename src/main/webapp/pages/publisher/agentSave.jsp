<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
                                    <h4 class="page-title"><s:if test="agentVO.id>0">Update</s:if><s:else>Create</s:else> Agent</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Publisher
                                        </li>
                                        <li class="active">
                                            <s:if test="agentVO.id>0">Update</s:if><s:else>Create</s:else> Agent
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
                                    <h4 class="m-t-0 header-title"><b><s:if test="agentVO.id>0">Update</s:if><s:else>Create</s:else></b></h4>
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
                                                            value='<s:property value="agentVO.name"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="example-email">Email</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="email" name="example-email" class="form-control" 
                                                            placeholder="Email" value='<s:property value="agentVO.email"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')" >
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Password</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="password" class="form-control" placeholder="Password"
                                                            value='<s:property value="agentVO.password"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Text area</label>
                                                        <div class="col-md-4">
                                                            <textarea class="form-control" id="desc" rows="5" onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')"><s:property value="agentVO.desc"/></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label"></label>
                                                        <div class="col-md-4">
                                                            <button class="btn btn-primary waves-effect waves-light" 
                                                                    type="button" onclick="saveAgent()">Submit
	                                                        </button>
	                                                        <a type="button" class="btn btn-default waves-effect m-l-5"
                                                                    href="<%=request.getContextPath()%>/publisher/agent!agentListPage">
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
  
    function saveAgent(){
        var name = $('#name').val();
        var email = $('#email').val();
        var password = $('#password').val();
        var desc = $('#desc').val();
        var id = "<s:property value="agentVO.id"/>";
        if(id == ""){id = 0;}
        
        if(name==""){
            showMiddle("Name Cannot Be Empty");
            $("#name").focus();
            return false;
        }else if(email==""){
            showMiddle("Email Cannot Be Empty");
            $("#email").focus();
            return false;
        }else if(password==""){
            showMiddle("Password Cannot Be Empty");
            $("#password").focus();
            return false;
        }
        var  re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        if(!re.test(email)){
            showMiddle("Pease check your email !");
            $("#email").focus();
            return false;
        }
        $('#submit').attr("disabled",true);
        var url = "<%=request.getContextPath()%>/publisher/agent!agentSave";
        $.post(url,{"agentVO.name":name,"agentVO.id":id,
	            "agentVO.email":email,"agentVO.password":password,
	            "agentVO.desc":desc,},
		    function(response){
		    if(response==-1){
		        showMiddle("System Error");
		    }else{
		        showMiddle("Success");
		        $('#submit').attr("disabled",false);
		    }
	    })
    }
    
</script>
</body>
</html>