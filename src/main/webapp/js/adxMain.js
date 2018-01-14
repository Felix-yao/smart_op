	function loadDataNew(url) {
	    window.location.href=url;
	}
	
	//loding效果层开关方法
    function startLoding(){
    	$("#main").hide();
    	$("#main_hidden").show();
    }
    function closeLoding(){
    	$("#main_hidden").hide();
		$("#main").show();
    }
    
    //post提交数据  post('pages/statisticsJsp/excel.action', {html :prnhtml,cm1:'sdsddsd',cm2:'haha'});
    function post(URL, PARAMS) {
    	debugger
    	  var temp = document.createElement("form");
    	  temp.action = URL;
    	  temp.method = "post";
    	  temp.style.display = "none";
    	  for (var x in PARAMS) {
    	    var opt = document.createElement("textarea");
    	    opt.name = x;
    	    opt.value = PARAMS[x];
    	    // alert(opt.name)
    	    temp.appendChild(opt);
    	  }
    	  document.body.appendChild(temp);
    	  temp.submit();
    	  return temp;
    }
    
//    function post(URL){
//    	post(URL, {});
//    }
    
    var host = window.location.host;
	if (host == "www.api.braverymob.com") {//正式服务器则返回host（有域名情况下）
		$("#indexLog").attr("src",getRootPath()+"/css/assets/pages/img/bravemobLogo.png");
		$("#indexLog").css("height","80px");
		$("#registerLog").attr("src",getRootPath()+"/css/assets/pages/img/bravemobLogo.png");
		$("#registerLog").css("height","80px");
		$("#mainLog").attr("src",getRootPath()+"/css/assets/pages/img/bravemobLogo.png");
		$("#mainLog").css("width","170px");
		$("#mainWord").html("braverymob");
		$("#pageFooterWord").html("2017 &copy; Braverymob.");
		$("title").html("Braverymob"); 
	}else if(host == "ssp.mobikok.com"){
		$("#indexLog").attr("src",getRootPath()+"/css/assets/pages/img/logo-big-white.png");
		$("#registerLog").attr("src",getRootPath()+"/css/assets/pages/img/logo-big-white.png");
		$("#mainLog").attr("src",getRootPath()+"/css/assets/layouts/layout/img/logo.png");
		$("#mainWord").html("MobiKok");
		$("#pageFooterWord").html("2017 &copy; MobiKok.");
		$("title").html("MobiKok"); 
	}else{
		$("#indexLog").attr("src",getRootPath()+"/css/assets/pages/img/logo-big-white.png");
		$("#registerLog").attr("src",getRootPath()+"/css/assets/pages/img/logo-big-white.png");
		$("#mainLog").attr("src",getRootPath()+"/css/assets/layouts/layout/img/logo.png");
		$("#mainWord").html("MobiKok");
		$("#pageFooterWord").html("2017 &copy; MobiKok.");
		$("title").html("MobiKok"); 
	}
	
	//js获取项目根路径，如： http://localhost:8083/uimcardprj
	function getRootPath() {
		var host = window.location.host;
		if (host == "ssp.mobikok.com" || host == "www.api.braverymob.com") {//正式服务器则返回host（有域名情况下）
			return "";
		} else {//（没有域名情况下）
			//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
			var curWwwPath = window.document.location.href;
			//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
			var pathName = window.document.location.pathname;
			var pos = curWwwPath.indexOf(pathName);
			//获取主机地址，如： http://localhost:8083
			var localhostPaht = curWwwPath.substring(0, pos);
			//获取带"/"的项目名，如：/uimcardprj
			var projectName = pathName.substring(0,
					pathName.substr(1).indexOf('/') + 1);
			return (localhostPaht + projectName);
		}
	}
	
	function changePassword(){
    	$('#myModal').modal({
			keyboard: true
		});
    }
	
    function resetPasswordDate(){
        var email= $("#email").html();
        var cpassword=$("#cpassword").val();
        var npassword=$("#npassword").val();
        var rnpassword=$("#rnpassword").val();
        
        if(cpassword == ""){
            showMiddle("Current Password can not be empty");
            $("#cpassword").focus();
            return false;
        }else if(npassword == ""){
            showMiddle("New Password can not be empty");
            $("#npassword").focus();
            return false;
        }else if(rnpassword == ""){
            showMiddle("Re-type New Password can not be empty");
            $("#rnpassword").focus();
            return false;
        }
        if(npassword!=rnpassword){
            showMiddle("New Password And Re-type New Password should be the same");
            return false;
        }
        if(npassword == cpassword){
            showMiddle("The new password is the same as the Current password");
            return false;
        }
        startLoding();
        var url=getRootPath()+"/advertiser/login!resetPassword.action";
        $.post(url,
                {"loginUser.newPassword":npassword,"loginUser.password":cpassword,
                  "loginUser.email":email},
        function(response){
            if(response==-1) {
                showMiddle("System Eorror");
            } else if (response==2){
                showMiddle("The original password is incorrect");
            }else {
                showMiddle("Success!");
                $('#myModal').modal('hide');
            }
            closeLoding();
        })
    }
    
    $("#logOut").click(function() {
    	var url=getRootPath()+"/logOut!logOut.action";
    	loadDataNew(url)
    });