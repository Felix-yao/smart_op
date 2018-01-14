<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Login</title>

<link href="css/bootstrap-select.min.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/core.css" rel="stylesheet" type="text/css" />
<link href="css/components.css" rel="stylesheet" type="text/css" />
<link href="css/pages.css" rel="stylesheet" type="text/css" />
<!-- Modernizr JS -->
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
<![endif]-->
</head>
    <body class="bg-accpunt-pages">
 <!-- HOME -->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">

                        <div class="wrapper-page">

                            <div class="account-pages">
                                <div class="account-box">
                                    <div class="account-logo-box">
                                        <h2 class="text-uppercase text-center">
                                              <span style="color: gainsboro;">Smart</span>
                                        </h2>
                                    </div>
                                    <div class="account-content">
                                        <form class="form-horizontal">

                                            <div class="form-group m-b-20">
                                                <div class="col-xs-12">
                                                    <label for="emailaddress">Account</label>
                                                    <input class="form-control" type="email" id="username" placeholder="Enter your account">
                                                </div>
                                            </div>

                                            <div class="form-group m-b-20">
                                                <div class="col-xs-12">
                                                    <label for="password">Password</label>
                                                    <input class="form-control" type="password" id="password" placeholder="Enter your password">
                                                </div>
                                            </div>
                                            <div id="showError" style="text-align: center;color: crimson;font-family: 'Nunito Sans', sans-serif;" class="form-group m-b-20">
                                            </div>


                                            <div class="form-group text-center m-t-10">
                                                <div class="col-xs-12">
                                                    <a class="btn btn-md btn-block btn-primary waves-effect waves-light" onclick="login()">Sign In</a>
                                                </div>
                                            </div>

                                        </form>


                                    </div>
                                </div>
                            </div>
                            <!-- end card-box-->


                        </div>
                        <!-- end wrapper -->

                    </div>
                </div>
            </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    
    function login() {
        //清空carriers
        var un = $('#username').val();
        var ps = $('#password').val();
        
        url = "<%=request.getContextPath()%>/login";
        jQuery.post(url,{"loginUser.email":un,"loginUser.password":ps},function(rs){
        	if(rs == -2){
        		$("#showError").text("Email or password invalid!");
        	}else if(rs == -3){
        		$("#showError").text("Account  is Reviewing!");
            }else if(rs == -4){
        		$("#showError").text("Account  is Deny!");
            }else if(rs == -5){
        		$("#showError").text("Account  is Lock!");
            }else if(rs == 1){
        		window.location.href = "<%=request.getContextPath()%>/firstPage";
        	}
        });
    }
    
    </script>
    
    </body>
</html>

